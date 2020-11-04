package lesson36.controller;

import lesson36.exceptions.AuthorizationException;
import lesson36.exceptions.NotEnoughRightsException;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.service.RoomService;

import java.util.List;

public class RoomController extends Controller {
    private RoomService roomService = new RoomService();

    //TODO: test
    public List<Room> findRooms(Filter filter) throws NotEnoughRightsException {
        checkUserRights();
        return roomService.findRooms(filter);
    }

    //TODO: test
    //only admins
    public void addRoom(Room room) throws NotEnoughRightsException, AuthorizationException {
        checkIsUserAuthorized();
        checkUserRights();
        roomService.addRoom(room);
    }

    //TODO: test
    //only admins
    public void deleteRoom(long roomId) throws NotEnoughRightsException, AuthorizationException {
        checkIsUserAuthorized();
        checkUserRights();
        roomService.deleteRoom(roomId);
    }
}
