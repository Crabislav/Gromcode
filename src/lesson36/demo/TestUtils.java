package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;

public class TestUtils {
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
}