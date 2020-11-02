package gromcode.main.lesson27.homework2;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        throw new Exception("findById : User with id=" + id + " wasn't found");
    }

    public User save(User user) throws Exception {
        if (user == null) {
            throw new Exception("save : Can't save null user");
        }

        if (users.contains(user)) {
            throw new Exception("save : User (id =" + user.getId() + ") is already exists. Can't save this user again.");
        }

        users.add(user);
        return user;
    }

    public User update(User user) throws Exception {
        if (user == null) {
            throw new Exception("update : Can't update null user");
        }

        if (!users.contains(user)) {
            throw new Exception("update : User (id=" + user.getId() + ") doesn't exist. Can't do update");
        }

        int index = 0;
        for (User element : users) {
            if (element.equals(user)) {
                users.set(index, user);
                return users.get(index);
            }
            index++;
        }
        throw new Exception("update : Unexpected error");
    }

    public void delete(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                users.remove(findById(id));
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}

