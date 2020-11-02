package gromcode.main.lesson27.homework2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        testMethods();
    }

    private static void testMethods() {
        ArrayList<User> users = new ArrayList<>();
        UserRepository userRepository = new UserRepository(users);

        testSaveMethod(userRepository);
        System.out.println();

        testUpdateMethod(userRepository);
        System.out.println();

        testFindByIdMethod(userRepository);
        System.out.println();

        testDeleteMethod(userRepository);
    }

    private static void testUpdateMethod(UserRepository userRepository) {
        System.out.println("Before testUpdateMethod\n" + userRepository.getUsers());
        //update an existing user +
        //update an invalid user+

        User userToUpdate = new User(6, "Alex", "session885");
        User invalidUser = new User(8, "name", "session");

        User[] users = {userToUpdate, invalidUser};

        for (User user : users) {
            try {
                userRepository.update(user);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("After testUpdateMethod\n" + userRepository.getUsers());
    }

    private static void testFindByIdMethod(UserRepository userRepository) {
        System.out.println("testFindByIdMethod");

        //existing id+
        //invalid id +

        int[] ids = {6, 9};
        for (int id : ids) {
            try {
                System.out.println(userRepository.findById(id));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void testDeleteMethod(UserRepository userRepository) {
        System.out.println("Before testDeleteMethod");

        //existing id+
        //invalid id +

        int[] ids = {6, 9};
        for (int id : ids) {
            try {
                System.out.println(userRepository.findById(id));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("After testDeleteMethod");
    }

    private static void testSaveMethod(UserRepository userRepository) {
        System.out.println("Before testSaveMethod\n" + userRepository.getUsers());
        User user = new User(6, "name6", "session6");

        //normal saving+
        try {
            userRepository.save(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //saving the same user +
        try {
            userRepository.save(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //saving null
        try {
            userRepository.save(null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("After testSaveMethod\n" + userRepository.getUsers());
    }
}
