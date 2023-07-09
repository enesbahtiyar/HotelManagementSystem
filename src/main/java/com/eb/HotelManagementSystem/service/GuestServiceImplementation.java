package com.eb.HotelManagementSystem.service;

import com.eb.HotelManagementSystem.model.Address;
import com.eb.HotelManagementSystem.model.Guest;
import com.eb.HotelManagementSystem.repository.GuestRepository;
import com.eb.HotelManagementSystem.repository.GuestRepositoryImplementation;

import java.util.Scanner;

public class GuestServiceImplementation implements GuestService
{
    private final Scanner scanner = new Scanner(System.in);
    private final GuestRepository guestRepository;

    public GuestServiceImplementation(GuestRepository guestRepository)
    {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest saveGuest()
    {
        Guest guest = new Guest();
        System.out.println("Enter guest name: ");
        guest.setName(scanner.nextLine());

        Address address = new Address();

        System.out.println("Enter Guest Country: ");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter City Country: ");
        address.setCity(scanner.nextLine());

        System.out.println("Enter Guest Street: ");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter Guest ZipCode: ");
        address.setZipCode(scanner.nextInt());

        guest.setAddress(address);

        guestRepository.saveGuest(guest);

        System.out.println("Guest successfully saved. Guest Id: " + guest.getId());

        return guest;
    }
}
