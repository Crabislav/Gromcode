package lesson30.homework.entityDAO;

import lesson30.homework.entities.Customer;

import java.util.ArrayList;

public class CustomerDAO {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void init(int amount) {
        for (int i = 0; i < amount; i++) {
            customers.add(new Customer("customer" + i, "city" + i, (i + 1) * 100));
        }
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

}

