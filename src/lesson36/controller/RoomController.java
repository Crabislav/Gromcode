package lesson36.controller;

import lesson36.model.filter.Filter;
import lesson36.model.Room;
import lesson36.service.RoomService;

import java.io.IOException;
import java.util.List;

public class RoomController extends Controller {
    private final RoomService roomService = new RoomService();

    public RoomController() throws IOException {
    }

    public List<Room> findRooms(Filter filter) throws Exception {
        checkIsUserAuthorized("findRooms");
        return roomService.findRooms(filter);
    }

    /**
     * only admins
     */
    public void addRoom(Room room) throws Exception {
        checkIsUserAuthorized("addRoom");
        checkUserRights();
        roomService.addRoom(room);
    }

    /**
     * only admins
     */
    public void deleteRoom(long roomId) throws Exception {
        checkIsUserAuthorized("deleteRoom");
        checkUserRights();
        roomService.deleteRoom(roomId);
    }
}
