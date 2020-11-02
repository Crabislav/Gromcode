package gromcode.main.lesson20.task1;

import gromcode.main.lesson20.task1.exception.BadRequestException;
import gromcode.main.lesson20.task1.exception.InternalServelException;
import gromcode.main.lesson20.task1.exception.UserNotFoundException;

import java.util.Arrays;

public class UserRepository {
    private User[] users;


    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }


    public User save(User user) throws Exception {
        if (user == null) {
            throw new BadRequestException("Can't save null user");
        }

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exists");
        } catch (UserNotFoundException e) {
            //catch block must be filled with something
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        int index = 0;
        for (User element : users) {
            if (element == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServelException("Not enough space to save with id: " + user.getId());
    }

    public User update(User user) throws Exception {
        if (user == null) {
            throw new BadRequestException("Can't update null user");
        }

        findById(user.getId());

        int index = 0;
        for (User element : users) {
            if (element != null && user.getId() == element.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServelException("Unexpected error");
    }

    public void delete(long id) throws Exception {
        findById(id);

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

