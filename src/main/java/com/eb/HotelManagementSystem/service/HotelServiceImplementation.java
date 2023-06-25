package com.eb.HotelManagementSystem.service;

import com.eb.HotelManagementSystem.model.Hotel;
import com.eb.HotelManagementSystem.repository.HotelRepository;

import java.util.Scanner;

public class HotelServiceImplementation implements HotelService
{
    private static Scanner scanner = new Scanner(System.in);

    //injection
    private final HotelRepository hotelRepository;

    public HotelServiceImplementation(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel() {
        Hotel hotel = new Hotel();


        System.out.println("Enter Hotel ID");
        Long id = scanner.nextLong();
        hotel.setId(id);

        System.out.println("Enter hotel name");
        String name = scanner.nextLine();
        hotel.setName(name);

        System.out.println("Enter the Hotel Location");
        String location = scanner.nextLine();
        hotel.setLocation(location);

        hotelRepository.saveHotel(hotel);

        System.out.println("Hotel successfully saved" + hotel.getId());

        return hotel;
    }
}
