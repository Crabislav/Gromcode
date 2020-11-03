package lesson36.controller;

import lesson36.exceptions.AuthorizationException;
import lesson36.exceptions.BadRequestException;
import lesson36.service.UserService;
import lesson36.model.User;

//presentation layer
public class UserController {
    private UserService userService = new UserService();

    //TODO: finish method
    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    //TODO: finish
    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    //TODO: finish
    public void logout() throws AuthorizationException {
        userService.logout();
    }
}
