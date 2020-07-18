package lesson10.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer0 = new Customer("Denis", "Kiev", "male");
        ElectronicsOrder electronicsOrder0 = new ElectronicsOrder("Electronics0", new Date(), customer0.getCity(), "Dnepr", 900, customer0, 5);

        electronicsOrder0.validateOrder();
        electronicsOrder0.calculatePrice();
        electronicsOrder0.confirmShipping();

        System.out.println(electronicsOrder0);

        Customer customer1 = new Customer("Ann", "Odessa", "female");
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Electronics1", new Date(), customer1.getCity(), "Kiev", 1000, customer1, 6);

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();
        electronicsOrder1.confirmShipping();

        System.out.println(electronicsOrder1);

    }

}
