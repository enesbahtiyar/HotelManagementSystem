package com.eb.HotelManagementSystem.main;

import java.util.Scanner;

public class HotelManagementSystemService
{
    private static Scanner scanner = new Scanner(System.in);

    public void displayMenuHotelManagementSystem()
    {
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
                    displayHotelOperationMenu();
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

    private static void displayHotelOperationMenu()
    {

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
