package gromcode.main.lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        //fully filled array
        UserRepository userRepository = new UserRepository(generateUsers(5));

        //empty array
        UserRepository emptyUserRepository = new UserRepository(new User[5]);

        //getUserNames test
        System.out.println("getUserNames test");
        //fully filled array +
        System.out.println("Fully filled array");
        System.out.println(Arrays.toString(userRepository.getUserNames()) + "\n");
        //empty array +
        System.out.println("Empty array");
        System.out.println(Arrays.toString(emptyUserRepository.getUserNames()) + "\n");

        //getUserIds test
        System.out.println("getUserIds test");
        //fully filled array +
        System.out.println("Fully filled array");
        System.out.println(Arrays.toString(userRepository.getUserIds()) + "\n");
        //empty array +
        System.out.println("Empty array");
        System.out.println(Arrays.toString(emptyUserRepository.getUserIds()) + "\n");

        //getUserNameById test
        System.out.println("getUserNameById test");
        long userId = 1;
        //fully filled array +
        System.out.println("Fully filled array");
        //get user by correct id +
        System.out.println(userRepository.getUserNameById(userId));
        //get user by wrong id +
        System.out.println(userRepository.getUserNameById(userId * -1) + "\n");

        //empty array +
        System.out.println("Empty array");
        //get user by correct id +
        System.out.println(emptyUserRepository.getUserNameById(userId));
        //get user by wrong id +
        System.out.println(emptyUserRepository.getUserNameById(userId * -1) + "\n");

        //getUserByName test
        System.out.println("getUserByName test");
        //fully filled array +
        System.out.println("Fully filled array");
        //correct name +
        System.out.println(userRepository.getUserByName("Name1"));
        //wrong name +
        System.out.println(userRepository.getUserByName("asdasd"));
        //null input +
        System.out.println(userRepository.getUserByName(null) + "\n");

        //empty array +
        System.out.println("Empty array");
        //any name +
        System.out.println(emptyUserRepository.getUserByName("asdasd"));
        //null input +
        System.out.println(emptyUserRepository.getUserByName(null) + "\n");

        //getUserBySessionId test
        System.out.println("getUserBySessionId test");
        //fully filled array +
        System.out.println("Fully filled array");
        //correct session +
        System.out.println(userRepository.getUserBySessionId("Session2"));
        //wrong session +
        System.out.println(userRepository.getUserBySessionId("Session2aasddasdasdasd"));
        //null input +
        System.out.println(userRepository.getUserBySessionId(null) + "\n");

        //empty array +
        System.out.println("Empty array");
        //any session +
        System.out.println(emptyUserRepository.getUserBySessionId("Session2"));
        //null input +
        System.out.println(emptyUserRepository.getUserBySessionId(null) + "\n");

        User user1 = new User(8, "Name8", "Session8");
        User user2 = new User(8, "sadsd", "asdasdasd");

        //save test
        System.out.println("save test");
        //fully filled array +
        System.out.println("Fully filled array");
        //saving a user when there is no space for him +
        System.out.println(userRepository.toString());
        userRepository.save(user1);
        System.out.println(userRepository.toString());
        //null input
        userRepository.save(null);
        System.out.println(userRepository.toString() + "\n");

        //empty array +
        System.out.println("Empty array");
        //saving a user +
        System.out.println(emptyUserRepository.toString());
        emptyUserRepository.save(user1);
        System.out.println(emptyUserRepository.toString() + "\n");

        //saving the user with the same id +
        System.out.println(emptyUserRepository.toString());
        emptyUserRepository.save(user2);
        System.out.println(emptyUserRepository.toString() + "\n");

        //null input +
        System.out.println(emptyUserRepository.toString());
        emptyUserRepository.save(null);
        System.out.println(emptyUserRepository.toString() + "\n");

        //delete test
        System.out.println("delete test");
        //fully filled array +
        System.out.println("Fully filled array");
        System.out.println(userRepository.toString());

        //delete using correct id +
        userRepository.delete(1);
        System.out.println(userRepository.toString() + "\n");
        //delete using wrong id +
        userRepository.delete(1);
        System.out.println(userRepository.toString() + "\n");

        //empty array +
        System.out.println("Empty array");
        System.out.println(emptyUserRepository.toString() + "\n");
        //delete using correct id +
        emptyUserRepository.delete(8);
        System.out.println(emptyUserRepository.toString() + "\n");
        //delete using wrong id +
        emptyUserRepository.delete(8);
        System.out.println(emptyUserRepository.toString() + "\n");


        //update test
        System.out.println("Update test");
        //fully filled array
        System.out.println("Fully filled array");
        //update using correct user id +
        System.out.println(userRepository.toString());
        User user3 = new User(0, "Alex", "asdasda");
        userRepository.update(user3);
        System.out.println(userRepository.toString() + "\n");

        //update using wrong user id  +
        System.out.println(userRepository.toString());
        user3 = new User(545, "Alex", "asdasda");
        userRepository.update(user3);
        System.out.println(userRepository.toString() + "\n");

        //null input +
        System.out.println(userRepository.toString());
        userRepository.update(null);
        System.out.println(userRepository.toString() + "\n");

        //empty array +
        System.out.println("Empty array");
        //update any user id +
        System.out.println(emptyUserRepository.toString());
        emptyUserRepository.update(user3);
        System.out.println(emptyUserRepository.toString() + "\n");

        //null input
        System.out.println(emptyUserRepository.toString());
        emptyUserRepository.update(null);
        System.out.println(emptyUserRepository.toString() + "\n");
    }

    public static User[] generateUsers(int count) {
        if (count > 0) {
            User[] users = new User[count];
            for (int i = 0; i <= users.length - 1; i++) {
                users[i] = new User(i, "Name" + i, "Session" + i);
            }
            return users;
        }
        return new User[0];
    }
}
