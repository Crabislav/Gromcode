package lesson36.service;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

public class HotelService extends Service {
    private static final HotelRepository hotelRepository = new HotelRepository();

    public Hotel findHotelByName(String name) throws Exception {
        String methodName = "findHotelByName";

        if (name == null || name.isBlank()) {
            throw new BadRequestException(methodName + ": input can't be null");
        }

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

        Hotel hotel = hotelRepository.findObjById(hotelId);
        if (hotel == null) {
            throw new BadRequestException(methodName + ": hotel was not found");
        }

        hotelRepository.remove(hotel);

    }

    private void validateHotel(Hotel hotel) throws BadRequestException {
        validate(hotel);
        validate(hotel.getCity());
        validate(hotel.getName());
        validate(hotel.getCountry());
        validate(hotel.getStreet());
    }
}
