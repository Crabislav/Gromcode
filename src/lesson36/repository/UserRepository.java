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
        return save(getPath(), user);
    }

    //TODO: probably return old params or delete method
    public void login(User user) {
        Session.setAuthorizedUser(user);
    }

    //TODO: test
    public void logout() {
        Session.setAuthorizedUser(null);
    }

}
