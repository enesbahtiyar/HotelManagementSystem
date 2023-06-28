package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.config.HibernateUtils;
import com.eb.HotelManagementSystem.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomRepositoryImplementation implements RoomRepository
{
    @Override
    public Room saveRoom(Room room)
    {
        try(Session session = HibernateUtils.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();

            session.save(room);

            transaction.commit();
            session.close();

            return room;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
