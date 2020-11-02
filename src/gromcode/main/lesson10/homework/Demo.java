package gromcode.main.lesson10.homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Денис", "Киев", "Мужской");
        Customer customer2 = new Customer("Аня", "Одесса", "Женский");
        Customer customer3 = new Customer("Тест", "Киев", "Мужской");
        Customer customer4 = new Customer("НеТест", "Мухосранск", "Мужской");


        String[] cities = {"Киев", "Одесса", "Днепр", "Мухосранск", "Львов"};
        Customer[] customers = new Customer[]{customer1, customer2, customer3, customer4};


        checkElectronicsOrder(customers, cities, 500);
        checkFurnitureOrder(customers, cities, 500);

    }


    private static void checkElectronicsOrder(Customer[] customers, String[] shipToCity, int price) {
        for (Customer customer : customers) {
            for (String city : shipToCity) {
                ElectronicsOrder electronicsOrder = new ElectronicsOrder("ElectronicsOrder", new Date(), customer.getCity(), city, price, customer, 5);

                System.out.println("Before validation" + electronicsOrder);
                electronicsOrder.validateOrder();
//                electronicsOrder.calculatePrice();
//                electronicsOrder.confirmShipping();

                if (electronicsOrder.getDateConfirmed() != null) {
                    electronicsOrder.calculatePrice();
                    electronicsOrder.confirmShipping();
                }

                System.out.println("After validation" + electronicsOrder);
            }
        }
    }

    private static void checkFurnitureOrder(Customer[] customers, String[] shipToCity, int price) {
        for (Customer customer : customers) {
            for (String city : shipToCity) {
                FurnitureOrder furnitureOrder = new FurnitureOrder("FurnitureOrder1", new Date(), customer.getCity(), city, price, customer, "54");

                System.out.println("Before validation" + furnitureOrder);
                furnitureOrder.validateOrder();
//                furnitureOrder.calculatePrice();
//                furnitureOrder.confirmShipping();

                if (furnitureOrder.getDateConfirmed() != null) {
                    furnitureOrder.calculatePrice();
                    furnitureOrder.confirmShipping();
                }
                System.out.println("After validation" + furnitureOrder);
            }
        }
    }
}
