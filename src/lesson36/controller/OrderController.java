package lesson36.controller;

import lesson36.service.OrderService;

import java.io.IOException;
import java.util.Date;

public class OrderController extends Controller {
    private final OrderService orderService = new OrderService();

    public OrderController() throws IOException {
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        checkIsUserAuthorized("bookRoom");
        orderService.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        checkIsUserAuthorized("cancelReservation");
        orderService.cancelReservation(roomId, userId);
    }

}
