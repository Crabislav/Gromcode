package lesson36.service;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;
import lesson36.repository.RoomRepository;

import java.io.IOException;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();
    private RoomRepository roomRepository = new RoomRepository();

    public HotelService() throws IOException {
    }

    public Hotel findHotelByName(String name) throws Exception {
        String methodName = "findHotelByName";

        //input validation
        if (name == null || name.isBlank()) {
            throw new BadRequestException(methodName + ": input can't be null");
        }

        //find a hotel by name
        for (Hotel hotel : hotelRepository.getAllObjects()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }

        throw new BadRequestException(methodName + ": Hotel was not found");
    }

    public Hotel findHotelByCity(String city) throws Exception {
        String methodName = "findHotelByCity";

        if (city == null) {
            throw new BadRequestException(methodName + ": input can't be null");
        }

        for (Hotel hotel : hotelRepository.getAllObjects()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }

        throw new BadRequestException(methodName + ": hotel was not found");
    }

    public void addHotel(Hotel hotel) throws Exception {
        validateHotel(hotel);
        hotelRepository.save(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        String methodName = "deleteHotel";

        ServiceUtils.validateId(hotelId);

        //find a hotel
        Hotel hotel = hotelRepository.findObjById(hotelId);

        if (hotel == null) {
            throw new BadRequestException(methodName + ": hotel was not found");
        }

        hotelRepository.remove(hotel);

    }

    private void validateHotel(Hotel hotel) throws BadRequestException {
        String methodName = "validateHotel";
        String msg = "can't be null or empty";

        if (hotel == null) {
            throw new BadRequestException(methodName + ": Input " + msg);
        }

        String hotelCity = hotel.getCity();
        if (hotelCity == null || hotelCity.isEmpty()) {
            throw new BadRequestException(methodName + ": hotel's city " + msg);
        }

        String hotelName = hotel.getName();
        if (hotelName == null || hotelName.isEmpty()) {
            throw new BadRequestException(methodName + ": hotel's name " + msg);
        }

        String hotelCountry = hotel.getCountry();
        if (hotelCountry == null || hotelCountry.isEmpty()) {
            throw new BadRequestException(methodName + ": hotel's country " + msg);
        }

        String hotelStreet = hotel.getStreet();
        if (hotelStreet == null || hotelStreet.isEmpty()) {
            throw new BadRequestException(methodName + ": hotel's street " + msg);
        }
    }
}
