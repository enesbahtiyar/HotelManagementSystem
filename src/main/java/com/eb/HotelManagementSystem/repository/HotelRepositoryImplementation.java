package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.config.HibernateUtils;
import com.eb.HotelManagementSystem.exception.HotelResourceNotFoundException;
import com.eb.HotelManagementSystem.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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


    @Override
    public Hotel findHotelById(Long id)
    {
        Session session= HibernateUtils.getSessionFactory().openSession();
        return session.get(Hotel.class,id);
    }

    @Override
    public void deleteHotelById(Long id)
    {
        try (Session session= HibernateUtils.getSessionFactory().openSession())
        {
            Transaction transaction=session.beginTransaction();

            Hotel deleteHotel =    session.get(Hotel.class,id);

            if (deleteHotel!=null)
            {
                session.delete(deleteHotel);
                transaction.commit();
                HibernateUtils.closeSession(session);
            }
            else
            {
                throw new HotelResourceNotFoundException("Hotel not Found with Id : " +id);
            }

        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> findAllHotels()
    {
        Session session= HibernateUtils.getSessionFactory().openSession();
        List<Hotel> hotels = session.createQuery("FROM Hotel",Hotel.class).getResultList();
        return hotels;
    }

    @Override
    public void updateHotel(Hotel hotel)
    {
        try(Session session= HibernateUtils.getSessionFactory().openSession();)
        {
            Transaction transaction = session.beginTransaction();



            Hotel existingHotel = session.get(Hotel.class, hotel.getId());

            if(existingHotel != null)
            {
                existingHotel.setName(hotel.getName());
                existingHotel.setLocation(hotel.getLocation());
                session.update(existingHotel);
            }


            transaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
