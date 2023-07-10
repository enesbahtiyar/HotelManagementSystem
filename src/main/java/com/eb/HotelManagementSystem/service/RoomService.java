package com.eb.HotelManagementSystem.service;

import com.eb.HotelManagementSystem.model.Room;

public interface RoomService
{
    Room saveRoom();

    Room findRoomById(Long roomId);
}
