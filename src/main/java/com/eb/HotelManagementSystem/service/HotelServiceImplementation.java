package com.eb.HotelManagementSystem.service;

import com.eb.HotelManagementSystem.exception.HotelResourceNotFoundException;
import com.eb.HotelManagementSystem.model.Hotel;
import com.eb.HotelManagementSystem.repository.HotelRepository;

import java.util.List;
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
        scanner.nextLine();//consume next line
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


    @Override
    public Hotel findHotelById(Long id)
    {
        try {
            Hotel foundHotel=hotelRepository.findHotelById(id);
            if (foundHotel!=null)
            {
                System.out.println("-----------------------------------");
                System.out.println(foundHotel);
                return foundHotel;
            }else
            {
                throw new HotelResourceNotFoundException("Hotel not found With Id :" +id);
            }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteHotelById(Long id)
    {
        try {
            Hotel hotelDeleted =  hotelRepository.findHotelById(id);
            if (hotelDeleted==null){
                throw new HotelResourceNotFoundException("Hotel not found With Id ; "+id);
            }
            System.out.println(hotelDeleted);

            System.out.println("Are you sure You want to delete the hotel with id  :" +hotelDeleted.getId());//101
            String confirmation =  scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Y")){
                hotelRepository.deleteHotelById(hotelDeleted.getId());
                System.out.println("Hotel deleted successfully Id :" +hotelDeleted.getId());
            }else {
                System.out.println("Delete operation canceled ....");
            }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Hotel> findAllHotels()
    {
        try
        {
            List<Hotel> hotels =  hotelRepository.findAllHotels();

            if (!hotels.isEmpty()){
                System.out.println("List of Hotels: ");

                for (Hotel hotel:hotels){
                    System.out.println(hotel);
                    System.out.println("------------------------------");
                }
            }else {
                System.out.println("Hotel List is Empty ..");
            }
            return hotels;
        }
        catch (Exception e)
        {
            System.out.println("An error occurred while retrieving hotel : "+e.getMessage());
            return null;
        }
    }

    @Override
    public void updateHotelById(Long id, Hotel updateHotel) throws HotelResourceNotFoundException
    {
        try
        {
            Hotel existingHotel = hotelRepository.findHotelById(id);

            if(existingHotel == null)
            {
                throw new HotelResourceNotFoundException("Hotel not found with with this id: " + id);
            }

            existingHotel.setName(updateHotel.getName());
            existingHotel.setLocation(updateHotel.getLocation());

            hotelRepository.updateHotel(existingHotel);

            System.out.println("hotel updated successfully");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
