package lesson36.repository;

import lesson36.model.Hotel;

public class HotelRepository extends Repository<Hotel> {
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

    @Override
    Hotel getMappedObject(String[] objValues) {
        Long id = Long.parseLong(objValues[0]);
        String name = objValues[1];
        String country = objValues[2];
        String city = objValues[3];
        String street = objValues[4];

        return new Hotel(id, name, country, city, street);
    }
}
