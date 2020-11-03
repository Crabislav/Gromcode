package lesson36.demo;

import lesson36.model.User;
import lesson36.model.enums.UserType;
import lesson36.repository.UserRepository;

//test entity here
public class DemoUser {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        try {

//            userRepository.registerUser(User.newInstance(1L, "Alex", "asd", "UA", UserType.USER));
//            userRepository.registerUser(User.newInstance("", "asdas", "UA", UserType.USER));
            userRepository.registerUser(User.newInstance("Andrey", "asdas", "UA", UserType.USER));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
