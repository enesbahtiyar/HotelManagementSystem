package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.model.Hotel;

import java.util.List;

public interface HotelRepository
{
    Hotel saveHotel(Hotel hotel);

    Hotel findHotelById(Long id);


    void deleteHotelById(Long id);

    List<Hotel> findAllHotels();

    void updateHotel(Hotel existingHotel);
}
