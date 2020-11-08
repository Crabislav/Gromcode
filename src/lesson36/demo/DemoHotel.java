package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.UserController;
import lesson36.exceptions.BadRequestException;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.enums.UserType;

import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.function.Supplier;


public class DemoHotel {
    public static void main(String[] args) {
        try {
            HotelController hotelController = new HotelController();
            Hotel hotel = new Hotel("hotel1", "UA", "ZP", "street");

            UserController userController = new UserController();
            User user = new User("User", "user", "UA", UserType.USER);
            User admin = new User("Admin", "admin", "UA", UserType.ADMIN);

            //method usage without registration - throws exception +
//            complexTest(hotelController, hotel, userController, admin, false, false);

            ///no access rights
//            complexTest(hotelController, hotel, userController, user, true, true);

            //all good
            complexTest(hotelController, hotel, userController, admin, true, true);

            //delete an existing hotel at DB - already tested at complexTest +
            //findHotelByCity +
            //findHotelByName +

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tests for: users access rights, addHotel, deleteHotel, findHotelByCity, findHotelByName
    //boolean doUserRegistration - to test method executing without user registration
    //boolean forceAddHotel - for testing methods that are only for UserType.USER;
    //if forceAddHotel true - doUserRegistration must be also true
    private static void complexTest(HotelController hotelController, Hotel hotel, UserController userController, User user, boolean doUserRegistration, boolean forceAddHotel) throws Exception {
        boolean res1;
        boolean res2;

        User admin = new User("testAdmin", "admin", "UA", UserType.ADMIN);

        //user init
        if (doUserRegistration) {
            userController.registerUser(user);
            userController.login(user.getUserName(), user.getPassword());
        }

        //access rights tests - methods must be executed only by admins
        res1 = addHotel(hotelController, hotel);
        System.out.println("addHotel results : " + res1);
        res2 = deleteHotel(hotelController, hotel);
        System.out.println("deleteHotel results : " + res1);
        System.out.println("access rights results : " + (res1 && res2));

        if (forceAddHotel) {
            userController.logout();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            addHotel(hotelController, hotel);
            userController.logout();
            userController.deleteUser(admin);
            userController.login(user.getUserName(), user.getPassword());
        }

        //findHotelByName tests
        res1 = findHotelByName(hotelController, hotel.getName());
        res2 = findHotelByName(hotelController, hotel.getName() + "asdsad");
        System.out.println("findHotelByName results : " + (res1 && !res2));

        //findHotelByCity tests
        res1 = findHotelByCity(hotelController, hotel.getCity());
        res2 = findHotelByCity(hotelController, hotel.getCity() + "asdasd");
        System.out.println("findHotelByCity results : " + (res1 && !res2));

        //cleaning up test values
        if (forceAddHotel) {
            userController.logout();
            userController.registerUser(admin);
            userController.login(admin.getUserName(), admin.getPassword());
            deleteHotel(hotelController, hotel);
            userController.logout();
            userController.deleteUser(admin);
            userController.login(user.getUserName(), user.getPassword());
        }

        //cleaning up test values
        if (doUserRegistration) {
            userController.logout();
            userController.deleteUser(user);
        }
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

    private static boolean deleteHotel(HotelController hotelController, Hotel hotel) throws Exception {
        try {
            hotelController.deleteHotel(hotel.getId());
        } catch (NullPointerException e) {
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
