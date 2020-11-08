package lesson36.repository;

import lesson36.model.Hotel;
import lesson36.model.Room;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class RoomRepository extends Repository<Room> {
    private HotelRepository hotelRepository = new HotelRepository();

    public RoomRepository() throws IOException {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/RoomDb.txt");
        RepositoryUtils.createFileIfNotExists(getPath());
    }

    @Override
    Room getMappedObject(String[] objValues) throws Exception {
        Long id = Long.parseLong(objValues[0]);
        Integer numberOfGuests = Integer.parseInt(objValues[1]);
        Double price = Double.parseDouble(objValues[2]);
        Boolean breakfastIncluded = Boolean.parseBoolean(objValues[3]);
        Boolean petsAllowed = Boolean.parseBoolean(objValues[4]);
        Date dateAvailableFrom = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"))
                .parse(objValues[5]);
        Hotel hotel = hotelRepository.findObjById(Long.parseLong(objValues[6]));

        return new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
    }

    @Override
    public String getPath() {
        return super.getPath();
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }
}
