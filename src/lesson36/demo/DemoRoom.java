package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.model.*;
import lesson36.model.enums.UserType;
import lesson36.model.filter.Filter;
import lesson36.model.filter.FilterBuilder;

import java.util.ArrayList;
import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) {
        try {
            RoomController roomController = new RoomController();
            HotelController hotelController = new HotelController();
            UserController userController = new UserController();

            User user = new User("User", "user", "UA", UserType.USER);
            User admin = new User("Admin", "admin", "UA", UserType.ADMIN);

            Hotel hotel1 = new Hotel("hotel1", "UA", "ZP", "street1");
            Hotel hotel2 = new Hotel("hotel2", "RU", "Mosc", "street2");
            Hotel[] hotels = {hotel1, hotel2};

            Room room1 = new Room(5, 25d, true, true, new Date(), hotel1);
            Room room2 = new Room(5, 20d, false, false, new Date(), hotel2);

            Room[] rooms = {room1, room2};

            initHotels(hotelController, userController, admin, hotels);

            Filter filter = new FilterBuilder().setNumberOfGuests(5)
                    .setPrice(20d)
                    .createFilter();

            complexTest(userController, admin, roomController, rooms, filter, false, false);

//            complexTest(userController, user, roomController, rooms, filter, true, false);

//            complexTest(userController, user, roomController, rooms, filter, true, true);

            deleteTestHotels(hotelController, userController, admin, hotels);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteTestHotels(HotelController hotelController, UserController userController, User admin, Hotel[] hotels) {
        try {
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

    private static void initHotels(HotelController hotelController, UserController userController, User admin, Hotel[] hotels) {
        try {
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

    private static void complexTest(UserController userController, User user, RoomController roomController, Room[] rooms, Filter filter, boolean doUserRegistration, boolean doUserLogin) {
        if (doUserRegistration) {
            registerAnUser(userController, user, doUserLogin);
        }

        testAccessRightsAddAndDeleteRooms(roomController, rooms);

        //findRooms
        initTestRooms(userController, roomController, rooms, user, doUserLogin);
        System.out.println("findRooms results : " + findRooms(roomController, filter));
        deleteTestRooms(userController, roomController, rooms, user, doUserLogin);

        if (doUserRegistration) {
            deleteTestUser(userController, user, doUserLogin);
        }
    }

    private static void registerAnUser(UserController userController, User user, boolean doUserLogin) {
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

    private static void doUserLogin(UserController userController, User user) {
        try {
            userController.login(user.getUserName(), user.getPassword());
        } catch (Exception e) {
            System.err.println("Can't login user");
            e.printStackTrace();
        }
    }

    private static void initTestRooms(UserController userController, RoomController roomController, Room[] rooms, User userBefore, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }

            User admin = new User("Admin", "admin", "UA", UserType.ADMIN);
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

            User admin = new User("Admin", "admin", "UA", UserType.ADMIN);
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

    private static void deleteTestUser(UserController userController, User user, boolean doUserLogin) {
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