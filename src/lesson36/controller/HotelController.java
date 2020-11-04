package lesson36.controller;

import lesson36.exceptions.AuthorizationException;
import lesson36.exceptions.NotEnoughRightsException;
import lesson36.model.Hotel;
import lesson36.service.HotelService;

public class HotelController extends Controller {
    private HotelService hotelService = new HotelService();

    //TODO: test
    public Hotel findHotelByName(String name) throws AuthorizationException {
        checkIsUserAuthorized();
        return hotelService.findHotelByName(name);
    }

    //TODO: test
    public Hotel findHotelByCity(String city) throws NotEnoughRightsException {
        checkUserRights();
        return hotelService.findHotelByCity(city);
    }

    //only admins
    //TODO: test
    public void addHotel(Hotel hotel) throws NotEnoughRightsException, AuthorizationException {
        checkIsUserAuthorized();
        checkUserRights();
        hotelService.addHotel(hotel);
    }

    //only admins
    //TODO: test
    public void deleteHotel(long hotelId) throws NotEnoughRightsException, AuthorizationException {
        checkIsUserAuthorized();
        checkUserRights();
        hotelService.deleteHotel(hotelId);
    }
}
