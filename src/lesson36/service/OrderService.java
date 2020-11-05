package lesson36.service;

import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import java.util.Date;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private UserRepository userRepository = new UserRepository();

    public OrderService() throws IOException {
    }


    //TODO: finish
    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) {
        orderRepository.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    //TODO: finish
    public void cancelReservation(long roomId, long userId) {
        orderRepository.cancelReservation(roomId, userId);
    }

}
