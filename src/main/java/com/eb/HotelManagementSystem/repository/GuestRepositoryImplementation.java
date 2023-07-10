package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.config.HibernateUtils;
import com.eb.HotelManagementSystem.model.Address;
import com.eb.HotelManagementSystem.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cache.spi.support.AbstractDomainDataRegion;


public class GuestRepositoryImplementation implements GuestRepository
{
    @Override
    public void saveGuest(Guest guest)
    {
        try(Session session = HibernateUtils.getSessionFactory().openSession();)
        {
            Transaction transaction = session.beginTransaction();

            //create a new address
            Address address = new Address();
            address.setCity(guest.getAddress().getCity());
            address.setStreet(guest.getAddress().getStreet());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            guest.setAddress(address);

            session.save(guest);


            transaction.commit();
            HibernateUtils.closeSession(session);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Guest findGuestById(Long guestId)
    {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Guest.class, guestId);
    }
}
