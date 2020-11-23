package lesson36.demo;

import lesson36.Session;
import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.enums.UserType;

public class DemoUser {
    public static void main(String[] args) {

        User user = new User("User", "user", "UA", UserType.USER);
        User admin = new User("Admin", "admin", "UA", UserType.ADMIN);

        try {
            UserController userController = new UserController();

            //login using empty file-db - throws exception +
            emptyRepositoryLogin(user, userController);

            //login without registration - throws exception +
            testLoginWithoutRegistration(user, admin, userController);

            //null input - throws exception +
            testNullInput(userController);

            //login when other user has already authorized +
            testLoginAndLogout(user, admin, userController);

            //remove method
            testRemoveMethod(user, userController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testRemoveMethod(User user, UserController userController) {
        try {
            userController.registerUser(user);
            userController.registerUser(user);
            userController.registerUser(user);

            userController.deleteUser(user.getId());
            userController.deleteUser(1);
            userController.deleteUser(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testLoginAndLogout(User user, User admin, UserController userController) {
        try {
            userController.registerUser(admin);
            userController.registerUser(user);

            //first login
            userController.login(user.getUserName(), user.getPassword());
            System.out.println("Logged in user : " + Session.getAuthorizedUser());

            //second login must be unavailable +
            userController.login(admin.getUserName(), admin.getPassword());
            System.out.println("Logged in user : " + Session.getAuthorizedUser());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //first logout
            userController.logout();
            System.out.println("Logged in user : " + Session.getAuthorizedUser());
            //second logout must throw an exception
            userController.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //clear file
        try {
            userController.deleteUser(user.getId());
            userController.deleteUser(admin.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testNullInput(UserController userController) {
        try {
            userController.registerUser(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testLoginWithoutRegistration(User user, User admin, UserController userController) {
        try {
            userController.registerUser(admin);
            userController.registerUser(admin);
            userController.login(user.getUserName(), user.getPassword());
            System.out.println("Logged in user : " + Session.getAuthorizedUser());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            userController.deleteUser(admin.getId());
            userController.deleteUser(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void emptyRepositoryLogin(User user, UserController userController) {
        try {
            userController.login(user.getUserName(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
