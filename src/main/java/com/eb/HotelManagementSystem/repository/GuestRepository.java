package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.model.Guest;

public interface GuestRepository
{
    void saveGuest(Guest guest);

    Guest findGuestById(Long id);
}
