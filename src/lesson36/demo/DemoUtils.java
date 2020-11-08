package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.OrderController;
import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.model.User;
import lesson36.model.enums.UserType;

import java.io.IOException;
import java.util.Date;

public class DemoUtils {
    private static RoomController roomController;
    private static HotelController hotelController;
    private static UserController userController;
    private static OrderController orderController;

    private static User user = new User("User", "user", "UA", UserType.USER);
    private static User admin = new User("Admin", "admin", "UA", UserType.ADMIN);

    private static Hotel hotel1 = new Hotel("hotel1", "UA", "ZP", "street1");
    private static Hotel hotel2 = new Hotel("hotel2", "RU", "Mosc", "street2");

    private static Room room1 = new Room(5, 25d, true, true, new Date(172_800_000L), hotel1);
    private static Room room2 = new Room(5, 20d, false, false, new Date(172_800_000L), hotel2);

    static {
        try {
            roomController = new RoomController();
            hotelController = new HotelController();
            userController = new UserController();
            orderController = new OrderController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void registerAnUser(UserController userController, User user, boolean doUserLogin) {
        try {
            userController.registerUser(user);
            if (doUserLogin) {
                doUserLogin(userController, user);
            }
        } catch (Exception e) {
            System.err.println("Can't register an user");
            e.printStackTrace();
        }
    }

    static void doUserLogin(UserController userController, User user) {
        try {
            userController.login(user.getUserName(), user.getPassword());
        } catch (Exception e) {
            System.err.println("Can't login user");
            e.printStackTrace();
        }
    }

    static void deleteTestUser(UserController userController, User user, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }
            userController.deleteUser(user);
        } catch (Exception e) {
            System.err.println("Can't clean up test values");
            e.printStackTrace();
        }
    }

    static void deleteTestHotels(HotelController hotelController, UserController userController, Hotel[] hotels) {
        try {
            User admin = getAdmin();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            for (Hotel hotel : hotels) {
                hotelController.deleteHotel(hotel.getId());
            }
            userController.logout();
            userController.deleteUser(admin);
        } catch (Exception e) {
            System.err.println("Can't init hotels");
            e.printStackTrace();
        }
    }



    static void deleteTestRooms(UserController userController, RoomController roomController, Room[] rooms, User userBefore, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }

            User admin = getAdmin();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            roomController.deleteRoom(rooms[0].getId());
            roomController.deleteRoom(rooms[1].getId());
            userController.logout();
            userController.deleteUser(admin);

            if (doUserLogin) {
                userController.login(userBefore.getUserName(), userBefore.getPassword());
            }
        } catch (Exception e) {
            System.err.println("Can't delete test rooms");
            e.printStackTrace();
        }
    }


    public static RoomController getRoomController() {
        return roomController;
    }

    public static HotelController getHotelController() {
        return hotelController;
    }

    public static UserController getUserController() {
        return userController;
    }

    public static OrderController getOrderController() {
        return orderController;
    }

    public static User getUser() {
        return user;
    }

    public static User getAdmin() {
        return admin;
    }

    public static Hotel getHotel1() {
        return hotel1;
    }

    public static Hotel getHotel2() {
        return hotel2;
    }

    public static Room getRoom1() {
        return room1;
    }

    public static Room getRoom2() {
        return room2;
    }
}