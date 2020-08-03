package lesson15.homework;

import java.util.Arrays;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        //user exists if findUser(user) != null
        if (user == null || findUser(user) != null) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
        return user;
    }
//
//    public User update(User user) {
//
//    }
//
//    public void delete(long id) {
//
//    }

    public User findUser(User user) {
        if (user == null) {
            return null;
        }
        for (User resultUser : users) {
            if (user.equals(resultUser) && user.hashCode() == resultUser.hashCode()) {
                return resultUser;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}
