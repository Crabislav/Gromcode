package gromcode.main.lesson30.homework.entities;

import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private Collection<Department> departments;
    private Collection<Customer> customers;

    public Firm(Date dateFounded, Collection<Department> departments, Collection<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "\nFirm{" +
                "\ndateFounded=" + dateFounded +
                ", \ndepartments=" + departments +
                ", \n\ncustomers=" + customers +
                '}';
    }
}
