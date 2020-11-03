package lesson36.repository;

import lesson36.model.Hotel;

public class HotelRepository extends Repository {
    {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/HotelDb.txt");
    }

    //TODO: finish
    public Hotel findHotelByName(String name) {
        return null;
    }

    //TODO: finish
    public Hotel findHotelByCity(String city) {
        return null;
    }

    //only admins
    //TODO: finish
    public Hotel addHotel(Hotel hotel) throws Exception {
        save(getPath(), hotel);
        return hotel;
    }

    //only admins
    //TODO: finish
    public void deleteHotel(long hotelId) {

    }
}
