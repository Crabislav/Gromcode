package lesson36.controller;

import lesson36.exceptions.BadRequestException;
import lesson36.service.UserService;
import lesson36.model.User;

import java.io.IOException;

public class UserController extends Controller {
    private final UserService userService = new UserService();

    public UserController() throws IOException {
    }

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
