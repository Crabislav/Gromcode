package lesson10.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        //ElectronicsOrder check
        Customer customer0 = new Customer("Денис", "Киев", "Мужской");
        ElectronicsOrder electronicsOrder0 = new ElectronicsOrder("Electronics0", new Date(), customer0.getCity(), "Днепр", 900, customer0, 5);

        electronicsOrder0.validateOrder();
        electronicsOrder0.calculatePrice();
        electronicsOrder0.confirmShipping();

        System.out.println(electronicsOrder0);

        Customer customer1 = new Customer("Аня", "Одесса", "Женский");
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Electronics1", new Date(), customer1.getCity(), "Киев", 1000, customer1, 6);

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();
        electronicsOrder1.confirmShipping();

        System.out.println(electronicsOrder1);

        //FurnitureOrder check
        Customer customer3 = new Customer("Тест", "Киев", "Мужской");
        FurnitureOrder furnitureOrder0 = new FurnitureOrder("FurnitureOrder0", new Date(), customer3.getCity(), "Одесса", 6000, customer3, "5454");

        furnitureOrder0.validateOrder();
        furnitureOrder0.calculatePrice();
        furnitureOrder0.confirmShipping();

        System.out.println(furnitureOrder0);

        Customer customer4 = new Customer("НеТест", "Мухосранск", "Мужской");
        FurnitureOrder furnitureOrder1 = new FurnitureOrder("FurnitureOrder1", new Date(), customer4.getCity(), "Одесса", 600, customer4, "54");

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();
        furnitureOrder1.confirmShipping();

        System.out.println(furnitureOrder1);
    }

}
