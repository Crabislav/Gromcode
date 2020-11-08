package lesson36.demo;

import gromcode.main.lesson24.firstexample.Demo;
import lesson36.controller.HotelController;
import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.model.*;
import lesson36.model.filter.Filter;
import lesson36.model.filter.FilterBuilder;

import java.util.ArrayList;

public class DemoRoom {
    public static void main(String[] args) {
        try {
            RoomController roomController = DemoUtils.getRoomController();
            HotelController hotelController = DemoUtils.getHotelController();
            UserController userController = DemoUtils.getUserController();

            User user = DemoUtils.getUser();
            User admin = DemoUtils.getAdmin();

            Hotel[] hotels = {DemoUtils.getHotel1(), DemoUtils.getHotel2()};

            Room[] rooms = {DemoUtils.getRoom1(), DemoUtils.getRoom2()};

            initTestHotels(hotelController, userController, hotels);

            Filter filter = new FilterBuilder().setNumberOfGuests(5)
                    .setPrice(20d)
                    .createFilter();

//            complexTest(userController, admin, roomController, rooms, filter, false, false);

//            complexTest(userController, user, roomController, rooms, filter, true, false);

//            complexTest(userController, user, roomController, rooms, filter, true, true);

            DemoUtils.deleteTestHotels(hotelController, userController, hotels);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void complexTest(UserController userController, User user, RoomController roomController, Room[] rooms,
                                    Filter filter, boolean doUserRegistration, boolean doUserLogin) {
        if (doUserRegistration) {
            DemoUtils.registerAnUser(userController, user, doUserLogin);
        }

        testAccessRightsAddAndDeleteRooms(roomController, rooms);

        //findRooms
        initTestRooms(userController, roomController, rooms, user, doUserLogin);
        System.out.println("findRooms results : " + findRooms(roomController, filter));
        DemoUtils.deleteTestRooms(userController, roomController, rooms, user, doUserLogin);

        if (doUserRegistration) {
            DemoUtils.deleteTestUser(userController, user, doUserLogin);
        }
    }

    private static void testAccessRightsAddAndDeleteRooms(RoomController roomController, Room[] rooms) {
        boolean res1 = addRoom(roomController, rooms[0]) &&
                addRoom(roomController, rooms[1]) &&
                addRoom(roomController, rooms[1]);
        System.out.println("addRoom results : " + res1);

        boolean res2;
        try {
            res2 = deleteRoom(roomController, rooms[0].getId()) &&
                    deleteRoom(roomController, rooms[1].getId()) &&
                    //invalid id
                    !deleteRoom(roomController, rooms[1].getId() + 156) &&
                    deleteRoom(roomController, rooms[1].getId());
        } catch (NullPointerException e) {
            res2 = true;
        }

        System.out.println("deleteRoom results : " + res1);

        System.out.println("access rights results : " + (res1 && res2));
    }

    private static boolean findRooms(RoomController roomController, Filter filter) {
        try {
            ArrayList<Room> rooms = (ArrayList<Room>) roomController.findRooms(filter);

            if (rooms.size() == 0) {
                return true;
            }

            System.out.println("\nFound rooms using a such filter" + "\n(" + filter.toString() + ")");
            for (Room room : rooms) {
                System.out.println(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static boolean addRoom(RoomController roomController, Room room) {
        try {
            roomController.addRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean deleteRoom(RoomController roomController, long id) {
        try {
            roomController.deleteRoom(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static void initTestRooms(UserController userController, RoomController roomController, Room[] rooms, User userBefore, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }

            User admin = DemoUtils.getAdmin();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            roomController.addRoom(rooms[0]);
            roomController.addRoom(rooms[1]);
            userController.logout();
            userController.deleteUser(admin);

            if (doUserLogin) {
                userController.login(userBefore.getUserName(), userBefore.getPassword());
            }
        } catch (Exception e) {
            System.err.println("Can't init test rooms");
            e.printStackTrace();
        }
    }

    static void initTestHotels(HotelController hotelController, UserController userController, Hotel[] hotels) {
        try {
            User admin = DemoUtils.getAdmin();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            for (Hotel hotel : hotels) {
                hotelController.addHotel(hotel);
            }
            userController.logout();
            userController.deleteUser(admin);
        } catch (Exception e) {
            System.err.println("Can't init hotels");
            e.printStackTrace();
        }
    }
}