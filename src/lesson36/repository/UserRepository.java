package lesson36.repository;

import lesson36.model.User;
import lesson36.model.enums.UserType;

public class UserRepository extends Repository<User> {
    public UserRepository() {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/UserDb.txt");
        createRepositoryFile(UserRepository.class.getSimpleName());
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
}
