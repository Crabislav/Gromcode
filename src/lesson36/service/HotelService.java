package lesson36.service;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

import java.io.IOException;


public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

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
        for (Hotel hotel : hotelRepository.getAllObjects()) {
            if (hotel.getId() == hotelId) {
                //delete a hotel from repository
                hotelRepository.remove(hotel);
            }
        }

        //if there is no such hotel - throw Exception
        throw new BadRequestException(methodName + ": hotel was not found");
    }

    private void validateHotel(Hotel hotel) throws BadRequestException {
        String methodName = "validateHotel";
        String msg = "field can't be null";

        if (hotel == null) {
            throw new BadRequestException(methodName + ": Input " + msg);
        }

        if (hotel.getCity() == null) {
            throw new BadRequestException(methodName + ": hotel's city " + msg);
        }

        if (hotel.getName() == null) {
            throw new BadRequestException(methodName + ": hotel's name " + msg);
        }

        if (hotel.getCountry() == null) {
            throw new BadRequestException(methodName + ": hotel's country " + msg);
        }

        if (hotel.getStreet() == null) {
            throw new BadRequestException(methodName + ": hotel's street " + msg);
        }
    }
}
