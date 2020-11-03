package lesson36.controller;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.service.RoomService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomController {
    private RoomService roomService = new RoomService();

    //TODO: finish + add a check for user is signed in the system
    public List<Room> findRooms(Filter filter) {
        return roomService.findRooms(filter);
    }



    //TODO: finish + add user role verification
    //only admins
    public void addRoom(Room room) {
        roomService.addRoom(room);
    }

    //TODO: finish + add user role verification
    //only admins
    public void deleteRoom(long roomId) {
        roomService.deleteRoom(roomId);
    }
}
