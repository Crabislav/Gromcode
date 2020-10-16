package lesson30.homework.entityDAO;

import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Department;
import lesson30.homework.entities.Firm;

import java.util.Collection;
import java.util.Date;

public class FirmDAO {
    private static Firm firm;

    public FirmDAO(Collection<Department> departments, Collection<Customer> customers) {
        firm = new Firm(new Date(), departments, customers);
    }

    public static Firm getFirm() {
        return firm;
    }
}
