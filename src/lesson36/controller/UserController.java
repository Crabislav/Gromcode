package lesson36.controller;

import lesson36.exceptions.BadRequestException;
import lesson36.model.User;
import lesson36.service.UserService;

public class UserController extends Controller {
    private static final UserService userService = new UserService();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() throws BadRequestException {
        userService.logout();
    }

    public void deleteUser(long id) throws Exception {
        userService.deleteUser(id);
    }
}
