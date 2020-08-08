package lesson15.userrepository;

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
        //if there is a such user with the same id - we don't need to save him
        if (/*user == null || */findUser(user) != null || !isIdAvailable(user)) {
            return null;
        }
        int index = 0;
        for (User user1 : users) {
            if (user1 == null /*&& isIdAvailable(user)*/) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        return null;
    }

    public User update(User user) {
    /*    if (user == null) {
            return null;
        }*/
        int index = 0;
        for (User user1 : users) {
            if (user1 != null && user.getId() == user1.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        return null;
    }


    //if id is unique - it works fine
    public void delete(long id) {
        int index = 0;
        for (User user : users) {
            if (user != null && user.getId() == id) {
                users[index] = null;
                return;
            }
            index++;
        }
    }

    public User findUser(User user) {
/*        if (user == null) {
            return null;
        }*/
        for (User resultUser : users) {
            if (user.equals(resultUser)) {
                return resultUser;
            }
        }
        return null;
    }

    private boolean isIdAvailable(User user) {
        for (User resultUser : users) {
            if (resultUser != null && user.getId() == resultUser.getId()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}
