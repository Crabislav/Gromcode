package lesson36.service;

import lesson36.repository.OrderRepository;

import java.util.Date;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    //TODO: finish
    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) {
        orderRepository.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    //TODO: finish
    public void cancelReservation(long roomId, long userId) {
        orderRepository.cancelReservation(roomId, userId);
    }

}
