package gromcode.main.lesson6;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        //Car class
        Car car = new Car(1000, 2015, "Anton");
        car.startRun();
        car.stopRun();
        car.changeOwner("Andrey");

        //DbConnector class
        DbConnector dbConnector = new DbConnector();
        dbConnector.connect();

        //User class
        User user = new User();
        User user1 = new User("Jack");
        User user2 = new User("Max", 90, "Kiev", new Date(), true);

        user2.isActive(false);
        System.out.println(user2.isActive);

        user2.increaseAge();
        System.out.println(user2.age);

        user2.logIn();
        System.out.println(user2.lastActiveDate);

        System.out.println(user1.name);
    }
}
