package lesson9.home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        UserRepository userRepository = new UserRepository(generateUsers(5));

        User[] users = new User[5];
        UserRepository emptyUserRepository = new UserRepository(users);

        System.out.println("Part 2");
        checkHomeworkPart2(userRepository);
        checkHomeworkPart2(emptyUserRepository);

        System.out.println("\nPart 3");
        checkHomeworkPart3(userRepository);
        checkHomeworkPart3(emptyUserRepository);

        System.out.println("\nPart 4");
        User[] users1 = new User[1];
        UserRepository userRepository2 = new UserRepository(users1);
        checkHomeworkPart4(userRepository2);
        checkHomeworkPart4(emptyUserRepository);


        System.out.println("\nPart 5");
        User[] users2 = new User[5];
        UserRepository userRepository3 = new UserRepository(users2);
        checkHomeworkPart5(userRepository3);
        checkHomeworkPart5(emptyUserRepository);

    }

    public static User[] generateUsers(int count) {
        if (count > 0) {
            User[] users = new User[count];
            for (int i = 0; i <= users.length - 1; i++) {
                users[i] = new User(i, "Name" + i, "Session" + i);
            }
            return users;
        }
        return null;
    }

    public static void checkHomeworkPart2(UserRepository userRepository) {
        //getUserNames test
        String[] userNames = userRepository.getUserNames();
        System.out.println(Arrays.toString(userNames));

        //getUserIds test
        long[] ids = userRepository.getUserIds();
        System.out.println(Arrays.toString(ids));

        //getUserNameById test
        System.out.println(userRepository.getUserNameById(1));
        System.out.println(userRepository.getUserNameById(-1));
    }

    public static void checkHomeworkPart3(UserRepository userRepository) {
        //getUserByName test
        System.out.println(userRepository.getUserByName("Name1"));
        System.out.println(userRepository.getUserByName("Name")); //null

        //getUserNameById became private
//        System.out.println("\n" + userRepository.findUserById(1));
//        System.out.println(userRepository.findUserById(-1));  //null

        System.out.println(userRepository.getUserBySessionId("Session1"));
        System.out.println(userRepository.getUserBySessionId("session") + "\n");  //null
    }

    public static void checkHomeworkPart4(UserRepository userRepository) {
        User user = new User(8, "Name8", "Session8");
        System.out.println(userRepository.save(user));

        User user1 = new User(8, "Name7", "Session8");
        System.out.println(userRepository.save(user1));

    }

    public static void checkHomeworkPart5(UserRepository userRepository) {
        User user = new User(9, "Name9", "Session9");
        System.out.println(userRepository.save(user));
        userRepository.delete(9);
        System.out.println(userRepository.toString());
    }
}
