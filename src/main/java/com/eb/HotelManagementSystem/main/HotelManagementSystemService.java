package com.eb.HotelManagementSystem.main;

import com.eb.HotelManagementSystem.exception.HotelResourceNotFoundException;
import com.eb.HotelManagementSystem.model.Hotel;
import com.eb.HotelManagementSystem.repository.*;
import com.eb.HotelManagementSystem.service.*;

import java.util.Scanner;

public class HotelManagementSystemService
{
    private final static Scanner scanner = new Scanner(System.in);


    public static void displayMenuHotelManagementSystem()
    {
        HotelRepository hotelRepository = new HotelRepositoryImplementation();
        HotelService hotelService = new HotelServiceImplementation(hotelRepository);


        RoomRepository roomRepository= new RoomRepositoryImplementation();
        RoomService roomService = new RoomServiceImplementation(roomRepository,hotelRepository);


        GuestRepository guestRepository = new GuestRepositoryImplementation();
        GuestService guestService = new GuestServiceImplementation(guestRepository);

        boolean exit = false;
        while (!exit)
        {
            System.out.println("==== Hotel Management System  Menu ====");
            System.out.println("1. Hotel Operations");
            System.out.println("2. Room Operations");
            System.out.println("3. Guest Operations");
            System.out.println("4. Reservation Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    displayHotelOperationMenu(hotelService);
                    break;
                case 2:
                    displayRoomOperationMenu(roomService);
                    break;
                case 3:
                    displayGuestOperationMenu(guestService);
                    break;
                case 4:
                    displayReservationOperationMenu();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("invalid choice please select from 1 to 5");
            }
        }
    }

    private static void displayHotelOperationMenu(HotelService hotelService)
    {
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character// "/n"

            switch (choice) {
                case 1:
                    System.out.println("==== Add a new hotel ====");
                    hotelService.saveHotel();
                    break;
                case 2:
                    System.out.println("Enter the hotel ID: ");
                    Long hotelId = scanner.nextLong();
                    hotelService.findHotelById(hotelId);
                    break;
                case 3:
                    System.out.print("Enter the hotel ID to delete: ");
                    Long deleteHotelId  =scanner.nextLong();
                    hotelService.deleteHotelById(deleteHotelId);
                    break;
                case 4:
                    System.out.println("==== Find All Hotels ====");
                    hotelService.findAllHotels();
                    break;
                case 5:
                    System.out.println("==== Update Hotel By ID ====");

                    System.out.println("Enter the hotel id");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); //consumes next line

                    System.out.println("Please enter the updated hotel name");
                    String name = scanner.nextLine();

                    System.out.println("Please enter the updated hotel location");
                    String location = scanner.nextLine();

                    Hotel updatedHotel = new Hotel();

                    try
                    {
                        updatedHotel.setId(id);
                        updatedHotel.setName(name);
                        updatedHotel.setName(location);

                        hotelService.updateHotelById(id, updatedHotel);
                    }
                    catch (HotelResourceNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void displayRoomOperationMenu(RoomService roomService)
    {
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("==== Add New Room ====");
                    roomService.saveRoom();
                    break;
                case 2:
                    System.out.print("Enter the Room ID to Find: ");
                    break;
                case 3:
                    System.out.println("==== Delete Room By ID ====");
                    System.out.print("Enter the room ID to delete: ");
                    break;
                case 4:
                    System.out.println("==== Find All Rooms ====");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void displayGuestOperationMenu(GuestService guestService)
    {
        boolean exit = false;
        while (!exit)
        {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("==== Add New Guest ====");
                    guestService.saveGuest();
                    break;
                case 2:
                    System.out.print("Enter the Guest ID to Find: ");
                    break;
                case 3:
                    System.out.println("==== Delete Guest By ID ====");
                    break;
                case 4:
                    System.out.println("==== Find All Guests ====");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    public static void displayReservationOperationMenu()
    {

    }
}
