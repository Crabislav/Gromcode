package lesson36.repository;

import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;

public class RoomRepository extends Repository<Room> {
    private static final HotelRepository hotelRepository = new HotelRepository();

    public RoomRepository() {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/RoomDb.txt");
        createRepositoryFile(RoomRepository.class.getSimpleName());
    }

    @Override
    Room getMappedObject(String[] objValues) throws Exception {
        Long id = Long.parseLong(objValues[0]);
        Integer numberOfGuests = Integer.parseInt(objValues[1]);
        Double price = Double.parseDouble(objValues[2]);
        Boolean breakfastIncluded = Boolean.parseBoolean(objValues[3]);
        Boolean petsAllowed = Boolean.parseBoolean(objValues[4]);
        Date dateAvailableFrom = dateFormat.parse(objValues[5]);
        Hotel hotel = hotelRepository.findObjById(Long.parseLong(objValues[6]));

        return new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
    }
}
