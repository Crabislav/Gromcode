package gromcode.main.lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public static User[] getUsers() {
        return users;
    }

    public static String[] getUserNames() {
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

    public static long[] getUserIds() {
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

    public static String getUserNameById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id)
                    return user.getName();
            }
        }
        return null;
    }

    public static User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && user.getSessionId().equals(sessionId)) {
                return user;
            }
        }
        return null;
    }

    public static User save(User user) {
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

    public static User update(User user) {
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

    public static void delete(long id) {
        int index = 0;
        for (User user : users) {
            if (user != null && user.getId() == id) {
                users[index] = null;
                return;
            }
            index++;
        }
    }
}
