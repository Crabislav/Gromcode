package lesson36.service;

import lesson36.Session;
import lesson36.exceptions.BadRequestException;
import lesson36.model.User;
import lesson36.repository.UserRepository;

import java.io.IOException;

//business layer
public class UserService extends Service {
    private UserRepository userRepository = new UserRepository();

    public UserService() throws IOException {
    }

    public User registerUser(User user) throws Exception {
        validateUser(user);
        return userRepository.save(user);
    }

    public void login(String userName, String password) throws Exception {
        String methodName = "login";
        if (Session.getAuthorizedUser() != null) {
            throw new BadRequestException(methodName + ": Can't do login for a new User. User(" +
                    Session.getAuthorizedUser().toString() + ") has already authorized at system");
        }

        User userToLogin = null;
        //finds a user at users repository
        for (User user : userRepository.getAllObjects()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userToLogin = user;
                break;
            }
        }

        //if there is no such user
        if (userToLogin == null) {
            throw new BadRequestException(methodName + ": Can't find a such user at repository");
        }

        Session.setAuthorizedUser(userToLogin);
    }

    public void logout() throws BadRequestException {
        if (Session.getAuthorizedUser() == null) {
            throw new BadRequestException("logout: Can't do logout for null user");
        }
        Session.setAuthorizedUser(null);
    }

    private void validateUser(User user) throws BadRequestException {
        validate(user);
        validate(user.getUserName());
        validate(user.getPassword());
        validate(user.getCountry());
        validate(user.getUserType());
    }

    public void deleteUser(long userId) throws Exception {
        User user = userRepository.findObjById(userId);
        if (user == null) {
            throw new BadRequestException("User with id=" + userId + ") wasn't found");
        }
        userRepository.remove(user);
    }
}
