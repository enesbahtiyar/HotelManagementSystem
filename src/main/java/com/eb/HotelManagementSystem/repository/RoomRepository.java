package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.model.Room;

public interface RoomRepository
{
    Room saveRoom(Room room);

    Room findRoomById(Long roomId);
}
