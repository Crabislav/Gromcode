package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.io.IOException;

public class HotelController extends Controller {
    private HotelService hotelService = new HotelService();

    public HotelController() throws IOException {
    }


    //TODO: test
    public Hotel findHotelByName(String name) throws Exception {
        checkIsUserAuthorized("findHotelByName");
        return hotelService.findHotelByName(name);
    }

    //TODO: test
    public Hotel findHotelByCity(String city) throws Exception {
        checkIsUserAuthorized("findHotelByCity");
        return hotelService.findHotelByCity(city);
    }

    //only admins
    //TODO: test
    public void addHotel(Hotel hotel) throws Exception {
        checkIsUserAuthorized("addHotel");
        checkUserRights();
        hotelService.addHotel(hotel);
    }

    //only admins
    //TODO: test
    public void deleteHotel(long hotelId) throws Exception {
        checkIsUserAuthorized("deleteHotel");
        checkUserRights();
        hotelService.deleteHotel(hotelId);
    }
}
