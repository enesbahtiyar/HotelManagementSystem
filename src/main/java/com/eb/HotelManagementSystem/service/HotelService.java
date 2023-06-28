package com.eb.HotelManagementSystem.service;

import com.eb.HotelManagementSystem.model.Hotel;
import java.util.List;

public interface HotelService
{
    Hotel saveHotel();

    Hotel findHotelById(Long hotelId);

    void deleteHotelById(Long id);

    List<Hotel> findAllHotels();

}
