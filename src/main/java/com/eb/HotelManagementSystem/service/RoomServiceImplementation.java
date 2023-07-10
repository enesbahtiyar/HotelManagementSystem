package com.eb.HotelManagementSystem.service;

import com.eb.HotelManagementSystem.exception.HotelResourceNotFoundException;
import com.eb.HotelManagementSystem.exception.RoomResourceNotFoundException;
import com.eb.HotelManagementSystem.model.Hotel;
import com.eb.HotelManagementSystem.model.Room;
import com.eb.HotelManagementSystem.repository.HotelRepository;
import com.eb.HotelManagementSystem.repository.RoomRepository;

import java.util.Scanner;

public class RoomServiceImplementation implements RoomService
{
    private final static Scanner scanner = new Scanner(System.in);

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomServiceImplementation(RoomRepository roomRepository, HotelRepository hotelRepository)
    {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Room saveRoom()
    {
        Room room = new Room();
        System.out.println("Enter the room ID: ");
        room.setId(scanner.nextLong());

        System.out.println("Enter the Room Number: ");
        room.setNumber(scanner.next());

        System.out.println("Enter room capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine(); //consume next line

        System.out.println("Please Enter Hotel Id: ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        try
        {
            Hotel existingHotel = hotelRepository.findHotelById(hotelId);
            if(existingHotel == null)
            {
                throw new HotelResourceNotFoundException("hotel not found with Id: " + hotelId);
            }

            room.setHotel(existingHotel);

            Room saveRoom = roomRepository.saveRoom(room);

            existingHotel.getRooms().add(saveRoom);

            System.out.println("Room successfully added to the given hotel room id is: " + saveRoom.getId());
        }
        catch (HotelResourceNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        return room;
    }


    @Override
    public Room findRoomById(Long roomId)
    {
        try
        {
            Room room = roomRepository.findRoomById(roomId);

            if(room != null)
            {
                System.out.println("------------------");
                return room;
            }
            else
            {
                throw new RoomResourceNotFoundException("Room could not be found with id: " + roomId);
            }
        }
        catch (RoomResourceNotFoundException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
