package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.model.*;
import lesson36.model.filter.Filter;
import lesson36.model.filter.FilterBuilder;

import java.util.ArrayList;

public class DemoRoom extends Demo {
    public static void main(String[] args) {
        try {
            RoomController roomController = getRoomController();
            HotelController hotelController = getHotelController();
            UserController userController = getUserController();

            User user = getUser();
            User admin = getAdmin();

            Hotel[] hotels = {getHotel1(), getHotel2()};

            Room[] rooms = {getRoom1(), getRoom2()};

            initHotels(hotelController, userController, hotels);

            Filter filter = new FilterBuilder().setNumberOfGuests(5)
                    .setPrice(20d)
                    .createFilter();

            complexTest(userController, admin, roomController, rooms, filter, false, false);

//            complexTest(userController, user, roomController, rooms, filter, true, false);

//            complexTest(userController, user, roomController, rooms, filter, true, true);

            deleteTestHotels(hotelController, userController, hotels);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteTestHotels(HotelController hotelController, UserController userController, Hotel[] hotels) {
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

    private static void initHotels(HotelController hotelController, UserController userController, Hotel[] hotels) {
        try {
            User admin = getAdmin();
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

    private static void complexTest(UserController userController, User user, RoomController roomController, Room[] rooms,
                                    Filter filter, boolean doUserRegistration, boolean doUserLogin) {
        if (doUserRegistration) {
            Demo.registerAnUser(userController, user, doUserLogin);
        }

        testAccessRightsAddAndDeleteRooms(roomController, rooms);

        //findRooms
        initTestRooms(userController, roomController, rooms, user, doUserLogin);
        System.out.println("findRooms results : " + findRooms(roomController, filter));
        deleteTestRooms(userController, roomController, rooms, user, doUserLogin);

        if (doUserRegistration) {
            Demo.deleteTestUser(userController, user, doUserLogin);
        }
    }

    private static void initTestRooms(UserController userController, RoomController roomController, Room[] rooms, User userBefore, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }

            User admin = getAdmin();
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

    private static void deleteTestRooms(UserController userController, RoomController roomController, Room[] rooms, User userBefore, boolean doUserLogin) {
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

}