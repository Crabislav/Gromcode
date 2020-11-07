package lesson36.demo;

import lesson36.Session;
import lesson36.controller.HotelController;
import lesson36.controller.UserController;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.enums.UserType;


public class DemoHotel {
    public static void main(String[] args) {
        try {
            HotelController hotelController = new HotelController();
            Hotel hotel = new Hotel("hotel1", "UA", "ZP", "street");

            UserController userController = new UserController();
            User user = new User("User", "user", "UA", UserType.USER);
            User admin = new User("Admin", "admin", "UA", UserType.ADMIN);

            //add hotel without login - throw exception +
//            testExecutingWithoutLogin(hotelController, hotel);

            //add hotel with authorized user-not admin - throws exception +
//            complexTest(hotelController, hotel, userController, user);

            //add hotel with authorized user-admin +
            complexTest(hotelController, hotel, userController, admin);

            //delete an existing hotel at DB - already tested at complexTest +

            //find by non-existing hotelName
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tests for: users access rights, addHotel, deleteHotel, findHotelByCity, findHotelByName
    private static void complexTest(HotelController hotelController, Hotel hotel, UserController userController, User user) throws Exception {
        boolean res1;
        //used for invalid input
        boolean res2;

        //user init
        userController.registerUser(user);
        userController.login(user.getUserName(), user.getPassword());

        //addHotel + user access rights tests
        res1 = testAddHotelAndAccessRights(hotelController, hotel);
        System.out.println("\naddHotelTest + accessRights results : " + (res1));

        //findHotelByName tests
        res1 = testFindHotelByName(hotelController, hotel.getName());
        res2 = testFindHotelByName(hotelController, hotel.getName() + "asdsad");
        System.out.println("findHotelByName results : " + (res1 && !res2));

        //findHotelByCity tests
        res1 = testFindHotelByCity(hotelController, hotel.getCity());
        res2 = testFindHotelByCity(hotelController, hotel.getCity() + "asdasd");
        System.out.println("findHotelByCity results : " + (res1 && !res2));

        //deleteHotel test
        res1 = testDeleteHotel(hotelController, hotel);
        System.out.println("deleteHotel results : " + res1);

        //cleaning up test values
        userController.logout();
        userController.deleteUser(user);
    }

    private static boolean testAddHotelAndAccessRights(HotelController hotelController, Hotel hotel) {
        try {
            hotelController.addHotel(hotel);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean testDeleteHotel(HotelController hotelController, Hotel hotel) throws Exception {
        try {
            hotelController.deleteHotel(hotel.getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean testFindHotelByCity(HotelController hotelController, String hotelName) {
        try {
            hotelController.findHotelByCity(hotelName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean testFindHotelByName(HotelController hotelController, String hotelName) {
        try {
            hotelController.findHotelByName(hotelName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void testExecutingWithoutLogin(HotelController hotelController, Hotel hotel) {
        boolean res = true;
        try {
            hotelController.addHotel(hotel);
        } catch (Exception e) {
            res = false;
            e.printStackTrace();
        }

        System.out.println("\ntestExecutingWithoutLogin results : " + res);
    }

}
