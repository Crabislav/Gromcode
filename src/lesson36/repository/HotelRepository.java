package lesson36.repository;

import lesson36.model.Hotel;

public class HotelRepository extends Repository<Hotel> {
    public HotelRepository() {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/HotelDb.txt");
        createRepositoryFile(HotelRepository.class.getSimpleName());
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
