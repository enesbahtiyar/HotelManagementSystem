package com.eb.HotelManagementSystem.repository;

import com.eb.HotelManagementSystem.model.Reservation;

public interface ReservationRepository
{
    Reservation saveReservation(Reservation reservation);
}
