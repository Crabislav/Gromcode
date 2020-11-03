package lesson36.repository;

import lesson36.Session;
import lesson36.exceptions.BadRequestException;
import lesson36.exceptions.MappingException;
import lesson36.model.User;
import lesson36.model.enums.UserType;

import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    User getMappedObject(String[] objValues) {
        Long id = Long.parseLong(objValues[0]);
        String userName = objValues[1];
        String password = objValues[2];
        String country = objValues[3];
        UserType userType = UserType.valueOf(objValues[4]);

        return new User(id, userName, password, country, userType);
    }

    @Override
    public String getPath() {
        return super.getPath();
    }

    @Override
    public ArrayList<User> getAllObjects() throws MappingException, IOException {
        return super.getAllObjects();
    }
}
