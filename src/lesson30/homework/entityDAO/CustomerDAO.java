package lesson30.homework.entityDAO;

import lesson30.homework.entities.Customer;

import java.util.ArrayList;

public class CustomerDAO {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        Customer customer1 = new Customer("customer0", "country", 100);
        Customer customer2 = new Customer("customer1", "country", 200);
        Customer customer3 = new Customer("customer2", "country", 300);
        Customer customer4 = new Customer("customer3", "country", 400);
        Customer customer5 = new Customer("customer4", "country", 500);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

}

