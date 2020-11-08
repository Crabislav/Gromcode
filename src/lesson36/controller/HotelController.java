package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.io.IOException;

public class HotelController extends Controller {
    private HotelService hotelService = new HotelService();

    public HotelController() throws IOException {
    }

    public Hotel findHotelByName(String name) throws Exception {
        checkIsUserAuthorized("findHotelByName");
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        checkIsUserAuthorized("findHotelByCity");
        return hotelService.findHotelByCity(city);
    }

    /**only admins*/
    public void addHotel(Hotel hotel) throws Exception {
        checkIsUserAuthorized("addHotel");
        checkUserRights();
        hotelService.addHotel(hotel);
    }

    /**only admins*/
    public void deleteHotel(long hotelId) throws Exception {
        checkIsUserAuthorized("deleteHotel");
        checkUserRights();
        hotelService.deleteHotel(hotelId);
    }
}
