package com.eb.HotelManagementSystem.exception;

public class RoomResourceNotFoundException extends RuntimeException
{
    public RoomResourceNotFoundException(String message)
    {
        super(message);
    }
}
