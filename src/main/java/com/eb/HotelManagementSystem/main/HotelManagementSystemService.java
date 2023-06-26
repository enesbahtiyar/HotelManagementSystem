package com.eb.HotelManagementSystem.main;

import com.eb.HotelManagementSystem.repository.HotelRepository;
import com.eb.HotelManagementSystem.repository.HotelRepositoryImplementation;
import com.eb.HotelManagementSystem.service.HotelService;
import com.eb.HotelManagementSystem.service.HotelServiceImplementation;

import java.util.Scanner;

public class HotelManagementSystemService
{
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenuHotelManagementSystem()
    {
        HotelRepository hotelRepository = new HotelRepositoryImplementation();
        HotelService hotelService = new HotelServiceImplementation(hotelRepository);

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
                    displayRoomOperationMenu();
                    break;
                case 3:
                    displayGuestOperationMenu();
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
                    //step 13e:saveHotel
                    System.out.println("==== Add a new hotel ====");
                    hotelService.saveHotel();
                    break;
                case 2:
                    // //step 14e:findHotelById
                    System.out.println("Enter the hotel ID: ");
                    break;
                case 3:
                    ////step 15e :deleteHotelById
                    System.out.print("Enter the hotel ID to delete: ");

                    break;
                case 4:
                    //step 16e: findAllHotels
                    System.out.println("==== Find All Hotels ====");
                    break;
                case 5:
                    //step 17e: updateHotelById
                    System.out.println("==== Update Hotel By ID ====");

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

    public static void displayRoomOperationMenu()
    {

    }

    public static void displayGuestOperationMenu()
    {

    }

    public static void displayReservationOperationMenu()
    {

    }
}
