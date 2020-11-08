package lesson36.demo;

import gromcode.main.lesson24.firstexample.Demo;
import lesson36.controller.HotelController;
import lesson36.controller.OrderController;
import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.model.User;

import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) {
        OrderController orderController = DemoUtils.getOrderController();
        UserController userController = DemoUtils.getUserController();
        HotelController hotelController = DemoUtils.getHotelController();
        RoomController roomController = DemoUtils.getRoomController();

        Room room = DemoUtils.getRoom1();
        User user = DemoUtils.getUser();
        User admin = DemoUtils.getAdmin();

        Hotel hotel = DemoUtils.getHotel1();

        //init test values (rooms and hotels)
        try {
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            hotelController.addHotel(hotel);
            roomController.addRoom(room);
            userController.logout();
            userController.deleteUser(admin);
        } catch (Exception e) {
            System.err.println("Can't init test values");
            e.printStackTrace();
        }


//        complexTest(orderController, userController, user, room, true, false);
        complexTest(orderController, userController, user, room, false, false);
//        complexTest(orderController, userController, user, room, true, true);


        //delete test values
        try {
//            userController.logout();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            roomController.deleteRoom(room.getId());
            hotelController.deleteHotel(hotel.getId());
            userController.logout();
            userController.deleteUser(admin);
        } catch (Exception e) {
            System.err.println("Can't delete test values");
            e.printStackTrace();
        }
    }

    private static void complexTest(OrderController orderController, UserController userController,
                                    User user, Room room, boolean doUserRegistration, boolean doUserLogin) {
        //user init
        if (doUserRegistration) {
            DemoUtils.registerAnUser(userController, user, doUserLogin);
        }


        //172_800_000L - 2 days
        try {
            orderController.bookRoom(room.getId(), user.getId(), new Date(172_800_000L), new Date(345_600_000L));
        } catch (NullPointerException e) {
            System.err.println("User is not at DB");
        } catch (Exception e) {
            System.err.println("Can't book room");
            e.printStackTrace();
        }

        try {
            orderController.cancelReservation(room.getId(), user.getId());

        } catch (NullPointerException e) {
            System.err.println("User is not at DB");
        } catch (Exception e) {
            System.err.println("Can't cancel reservation");
            e.printStackTrace();
        }

        if (doUserRegistration) {
            DemoUtils.deleteTestUser(userController, user, doUserLogin);
        }
    }
}
