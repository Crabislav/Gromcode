package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.UserController;
import lesson36.model.Hotel;
import lesson36.model.User;

public class DemoHotel {
    public static void main(String[] args) {
        try {
            HotelController hotelController = DemoUtils.getHotelController();
            Hotel hotel = DemoUtils.getHotel1();

            UserController userController = new UserController();
            User user = DemoUtils.getUser();
            User admin = DemoUtils.getAdmin();

            //method usage without registration - throws exception +
            complexTest(hotelController, hotel, userController, admin, false, false);

            ///no access rights
//            complexTest(hotelController, hotel, userController, user, true, false);

            //all good
//            complexTest(hotelController, hotel, userController, admin, true, true);

            //delete an existing hotel at DB - already tested at complexTest +
            //findHotelByCity +
            //findHotelByName +

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tests for: users access rights, addHotel, deleteHotel, findHotelByCity, findHotelByName
    //if false - it will test methods without user registration and login
    //if true -
    private static void complexTest(HotelController hotelController, Hotel hotel, UserController userController, User user,
                                    boolean doUserRegistration, boolean doUserLogin) {
        boolean res1;
        boolean res2;

        //user init
        if (doUserRegistration) {
            DemoUtils.registerAnUser(userController, user, doUserLogin);
        }

        //access rights tests - methods must be executed only by admins
        testAccessRightsAddAndDeleteHotel(hotelController, hotel);

        //findBy tests
        initTestHotel(hotelController, hotel, userController, user, doUserLogin);

        //findHotelByName test
        res1 = findHotelByName(hotelController, hotel.getName());
        res2 = findHotelByName(hotelController, hotel.getName() + "asdsad");
        System.out.println("findHotelByName results : " + (res1 && !res2));

        //findHotelByCity test
        res1 = findHotelByCity(hotelController, hotel.getCity());
        res2 = findHotelByCity(hotelController, hotel.getCity() + "asdasd");
        System.out.println("findHotelByCity results : " + (res1 && !res2));

        deleteTestHotel(hotelController, hotel, userController, user, doUserLogin);

        //deleting user test values
        if (doUserRegistration) {
            DemoUtils.deleteTestUser(userController, user, doUserLogin);
        }
    }

    private static void initTestHotel(HotelController hotelController, Hotel hotel, UserController userController, User userBefore, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }

            User admin = DemoUtils.getAdmin();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            hotelController.addHotel(hotel);
            userController.logout();
            userController.deleteUser(admin.getId());

            if (doUserLogin) {
                userController.login(userBefore.getUserName(), userBefore.getPassword());
            }
        } catch (Exception e) {
            System.err.println("Can't init test hotels");
            e.printStackTrace();
        }
    }

    private static void deleteTestHotel(HotelController hotelController, Hotel hotel, UserController userController, User userBefore, boolean doUserLogin) {
        try {
            if (doUserLogin) {
                userController.logout();
            }
            User admin = DemoUtils.getAdmin();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            hotelController.deleteHotel(hotel.getId());
            userController.logout();
            userController.deleteUser(admin.getId());

        } catch (Exception e) {
            System.err.println("Can't delete test hotels");
            e.printStackTrace();
        }
    }

    private static void testAccessRightsAddAndDeleteHotel(HotelController hotelController, Hotel hotel) {
        boolean res1 = addHotel(hotelController, hotel);
        System.out.println("addHotel results : " + res1);

        boolean res2;

        try {
            res2 = deleteHotel(hotelController, hotel.getId());
        } catch (NullPointerException e) {
            res2 = true;
        }

        System.out.println("deleteHotel results : " + res1);

        System.out.println("access rights results : " + (res1 && res2));
    }

    private static boolean addHotel(HotelController hotelController, Hotel hotel) {
        try {
            hotelController.addHotel(hotel);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean deleteHotel(HotelController hotelController, long id) {
        try {
            hotelController.deleteHotel(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static boolean findHotelByCity(HotelController hotelController, String hotelName) {
        try {
            hotelController.findHotelByCity(hotelName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean findHotelByName(HotelController hotelController, String hotelName) {
        try {
            hotelController.findHotelByName(hotelName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
