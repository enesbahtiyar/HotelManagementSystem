package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.config.HibernateUtils;
import com.eb.HotelManagementSystem.model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelRepositoryImplementation implements HotelRepository
{
    @Override
    public Hotel saveHotel(Hotel hotel)
    {
        try(Session session = HibernateUtils.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();

            session.save(hotel);

            transaction.commit();
            HibernateUtils.closeSession(session);
            return hotel;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
