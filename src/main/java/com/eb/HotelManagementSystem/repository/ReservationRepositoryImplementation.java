package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.config.HibernateUtils;
import com.eb.HotelManagementSystem.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepositoryImplementation implements ReservationRepository
{

    @Override
    public Reservation saveReservation(Reservation reservation)
    {
        try (Session session = HibernateUtils.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();

            session.save(reservation);

            transaction.commit();

            return reservation;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
