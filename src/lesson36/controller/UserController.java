package lesson36.controller;

import lesson36.Session;
import lesson36.exceptions.BadRequestException;
import lesson36.service.UserService;
import lesson36.model.User;

import java.io.IOException;

//presentation layer
public class UserController extends Controller {
    private UserService userService = new UserService();

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

    //own method
    public void deleteUser(User user) throws Exception {
        userService.deleteUser(user);
    }

    //own method
    public void deleteUser(long id) throws Exception {
        userService.deleteUser(id);
    }
}
