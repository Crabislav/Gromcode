package lesson36.repository;

import lesson36.model.User;
import lesson36.model.enums.UserType;

import java.io.IOException;

//data access layer
public class UserRepository extends Repository<User> {

    public UserRepository() throws IOException {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/UserDb.txt");
        RepositoryUtils.createFileIfNotExists(getPath());
    }

    @Override
    User getMappedObject(String[] objValues) {
        Long id = Long.parseLong(objValues[0]);
        String userName = objValues[1];
        String password = objValues[2];
        String country = objValues[3];
        UserType userType = UserType.valueOf(objValues[4]);

        return User.newMappedInstance(id, userName, password, country, userType);
    }

    @Override
    public String getPath() {
        return super.getPath();
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }
}
