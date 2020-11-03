package lesson36.repository;

import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomRepository {

    //TODO: finish
    public List<Room> findRooms(Filter filter) {
        return new ArrayList<>();
    }

    //TODO: finish
    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) {

    }

    //TODO: finish
    public void cancelReservation(long roomId, long userId) {

    }


    //TODO: finish
    //only admins
    public void addRoom(Room room) {

    }

    //TODO: finish
    //only admins
    public void deleteRoom(long RoomId) {

    }
}
