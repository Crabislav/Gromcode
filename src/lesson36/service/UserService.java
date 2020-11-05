package lesson36.service;

import lesson36.Session;
import lesson36.exceptions.BadRequestException;
import lesson36.model.User;
import lesson36.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;

//business layer
public class UserService {
    private UserRepository userRepository = new UserRepository();

    public UserService() throws IOException {
    }

    public User registerUser(User user) throws Exception {
        validateUser(user);
        return userRepository.save(user);
    }

    public void login(String userName, String password) throws Exception {
        if (Session.getAuthorizedUser() != null) {
            throw new BadRequestException("Can't do login for a new User. User(" + Session.getAuthorizedUser().toString() + ") has already authorized at system");
        }

        User userToLogin = null;

        ArrayList<User> users = userRepository.getAllObjects();
        //finds a user
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userToLogin = user;
            }
        }

        if (Session.getAuthorizedUser() == null) {
            Session.setAuthorizedUser(userToLogin);
            return;
        }

        if (userToLogin != null && !Session.getAuthorizedUser().equals(userToLogin)) {
            throw new BadRequestException("Can't do login for a new User. User(" + Session.getAuthorizedUser().toString() + ") has already authorized at system");
        }

        //throws if there is no such user
        throw new BadRequestException("login: Invalid user's name or password");
    }

    public void logout() throws BadRequestException {
        if (Session.getAuthorizedUser() == null) {
            throw new BadRequestException("Can't do logout for null user");
        }
        Session.setAuthorizedUser(null);
    }

    private void validateInput(User user) throws BadRequestException {
        //input object
        if (user == null) {
            throw new BadRequestException("User can't be null");
        }

        //name
        String userName = user.getUserName();
        if (userName == null || userName.isEmpty()) {
            throw new BadRequestException("User's name can't be empty or null. ");
        }

        //userPassword
        String userPassword = user.getPassword();
        if (userPassword == null || userPassword.isEmpty()) {
            throw new BadRequestException("User's password can't be empty or null");
        }

        //country
        String userCountry = user.getPassword();
        if (userCountry == null || userCountry.isEmpty()) {
            throw new BadRequestException("User's country can't be empty or null");
        }

        //userType
        if (user.getUserType() == null) {
            throw new BadRequestException("User's type can't be null");
        }
    }
}
