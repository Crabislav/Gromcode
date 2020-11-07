package lesson36.service;

import lesson36.model.Room;

import java.util.ArrayList;
import java.util.Date;

public class RoomFilter {
    public RoomFilter() {
    }

    void filterByHotelStreet(String hotelStreet, ArrayList<Room> filteredRooms) {
        if (hotelStreet != null && !hotelStreet.isEmpty()) {
            filteredRooms.removeIf(room -> !room.getHotel().getStreet().equals(hotelStreet));
        }
    }

    void filterByHotelCity(String hotelCity, ArrayList<Room> filteredRooms) {
        if (hotelCity != null && !hotelCity.isEmpty()) {
            filteredRooms.removeIf(room -> !room.getHotel().getCity().equals(hotelCity));
        }
    }

    void filterByHotelCountry(String hotelCountry, ArrayList<Room> filteredRooms) {
        if (hotelCountry != null && !hotelCountry.isEmpty()) {
            filteredRooms.removeIf(room -> !room.getHotel().getCountry().equals(hotelCountry));
        }
    }

    void filterByHotelName(String hotelName, ArrayList<Room> filteredRooms) {
        if (hotelName != null && !hotelName.isEmpty()) {
            filteredRooms.removeIf(room -> !room.getHotel().getName().equals(hotelName));
        }
    }

    void filterByDateAvailableFrom(Date dateAvailableFrom, ArrayList<Room> filteredRooms) {
        if (dateAvailableFrom != null) {
            filteredRooms.removeIf(room -> !room.getDateAvailableFrom().equals(dateAvailableFrom));
        }
    }

    void filterByPrice(Double price, ArrayList<Room> filteredRooms) {
        if (price != null) {
            filteredRooms.removeIf(room -> !room.getPrice().equals(price));
        }
    }

    void filterByNumberOfGuests(Integer numberOfGuests, ArrayList<Room> filteredRooms) {
        if (numberOfGuests != null) {
            filteredRooms.removeIf(room -> !room.getNumberOfGuests().equals(numberOfGuests));
        }
    }

    void filterByPetsAllowed(Boolean isPetsAllowed, ArrayList<Room> filteredRooms) {
        if (isPetsAllowed != null) {
            filteredRooms.removeIf(room -> !room.getPetsAllowed().equals(isPetsAllowed));
        }
    }

    void filterByBreakfast(Boolean isBreakfastIncluded, ArrayList<Room> filteredRooms) {
        if (isBreakfastIncluded != null) {
            filteredRooms.removeIf(room -> !room.getBreakfastIncluded().equals(isBreakfastIncluded));
        }
    }
}