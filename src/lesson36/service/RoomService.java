package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();
    private OrderRepository orderRepository = new OrderRepository();

    public RoomService() throws IOException {
    }

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
    public void addRoom(Room room) throws Exception {
        validateRoom(room);
        roomRepository.save(room);
    }

    //TODO: finish
    //only admins
    public void deleteRoom(long RoomId) {

    }
}
