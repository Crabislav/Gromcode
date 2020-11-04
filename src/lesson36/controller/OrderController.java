package lesson36.controller;

import lesson36.exceptions.AuthorizationException;
import lesson36.service.OrderService;

import java.util.Date;

public class OrderController extends Controller {
    private OrderService orderService = new OrderService();

    //TODO: test
    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws AuthorizationException {
        checkIsUserAuthorized();
        orderService.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    //TODO: test
    public void cancelReservation(long roomId, long userId) throws AuthorizationException {
        checkIsUserAuthorized();
        orderService.cancelReservation(roomId, userId);
    }

}
