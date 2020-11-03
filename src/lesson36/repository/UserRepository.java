package lesson36.repository;

import lesson36.Session;
import lesson36.model.User;

//data access layer
public class UserRepository extends Repository<User> {
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/UserDb.txt");
    }

    public User registerUser(User user) throws Exception {
        save(getPath(), user);
        return user;
    }

    //TODO: finish
    public void login(String userName, String password) {
        //find a user ->
        // Session.setSignedInUser(user);

    }

    //TODO: test
    public void logout() {
        Session.setSignedInUser(null);
    }

}
