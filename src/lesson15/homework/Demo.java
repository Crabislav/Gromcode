package lesson15.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        //creating userRepository
        UserRepository userRepository = new UserRepository(generateUsers(2, 1, "Alex"));
//        System.out.println(userRepository.toString());

        //findUser test
        User userToFind = new User(1, "Alex", "session1");
//        System.out.println(userRepository.findUser(userToFind).toString());

        //save test
        User userToSave = new User(8, "Andrew", "asdsad");
        userRepository.save(userToSave);
        User userToSave1 = new User(8, "Andrew", "asdsad");
        System.out.println(userRepository.save(userToSave1));
        System.out.println(userRepository.toString());


    }

    private static User[] generateUsers(int amountToGenerate, int startId, String name) {
        if (amountToGenerate <= 0 || name == null || startId <= 0) {
            return new User[0];
        }
        int emptyArraySlotsAmount = 5;
        User[] users = new User[amountToGenerate + emptyArraySlotsAmount];

        for (int i = 0; i < users.length - emptyArraySlotsAmount; i++) {
            users[i] = new User(startId, name, "session" + startId);
            startId++;
        }
        return users;


    }
}
