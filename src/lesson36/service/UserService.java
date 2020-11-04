package lesson36.service;

import lesson36.Session;
import lesson36.exceptions.AuthorizationException;
import lesson36.exceptions.BadRequestException;
import lesson36.model.User;
import lesson36.repository.UserRepository;

//business layer
public class UserService {
    private UserRepository userRepository = new UserRepository();

    //TODO: test method
    public User registerUser(User user) throws Exception {
        validateInput(user);
        return userRepository.registerUser(user);
    }


    public void login(String userName, String password) throws Exception {
        //finds a user
        for (User user : userRepository.getAllObjects()) {
            //if it was found ->
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                //it will do login
                Session.setAuthorizedUser(user);
            }
        }

        //throws if there is no such user
        throw new BadRequestException("UserRepository.login: Invalid user's name or password");
    }

    //TODO: test
    public void logout() {
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
