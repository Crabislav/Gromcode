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

    //renamed from getUserById to findById + public -> private
    public User findById(long id) {
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
        //if there is a such user with the same id - we don't need to save him
        if (user == null || findById(user.getId()) != null) {
            return null;
        }
        int index = 0;
        for (User user1 : users) {
            if (user1 == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        return null;
    }


    //Homework.part5
    public User update(User user) {
        if (user == null/* || findById(user.getId()) == null*/) {
            return null;
        }

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

    public void delete(long id) {
         /*   for (int i = 0; i < users.length; i++) {
                if (users[i] == findById(id)) {
                    users[i] = null;
                    return;
                }
            }*/
        int index = 0;
        for (User user : users) {
            if (user != null && user.getId() == id) {
                users[index] = null;
                return;
            }
            index++;
        }
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}

