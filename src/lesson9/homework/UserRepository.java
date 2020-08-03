package lesson9.homework;

import java.util.Arrays;

public class UserRepository {
    private User[] users;


    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    //Homework.part2
    public String[] getUserNames() {
        if (users == null) {
            return new String[0];
        }

        int index = 0;
        String[] userNames = new String[users.length];

        for (User user : users) {
            if (user != null) {
                userNames[index] = user.getName();
                index++;
            }
        }
        return userNames;
    }

    public long[] getUserIds() {
        if (users == null) {
            return new long[0];
        }

        int index = 0;
        long[] ids = new long[users.length];

        for (User user : users) {
            if (user != null) {
                ids[index] = user.getId();
                index++;
            }
        }
        return ids;
    }

    public String getUserNameById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id)
                    return user.getName();
            }
        }
        return null;
    }

    //Homework.part3
    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    //renamed from getUserById to findUserById + public -> private
    private User findUserById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && user.getSessionId().equals(sessionId)) {
                return user;
            }
        }
        return null;
    }

    //Homework.part4
    public User save(User user) {
        if (user == null || findUserById(user.getId()) != null) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }


    //Homework.part5
    public User update(User user) {
        if (user == null || findUserById(user.getId()) == null) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }


    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == findUserById(id)){
                users[i] = null;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}

