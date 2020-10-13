package lesson30.homework.entityDAO;

import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;

import java.util.ArrayList;

public class ProjectDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public static void init(int amount) {
        for (int i = 0; i < amount; i++) {
            projects.add(new Project("project" + i, CustomerDAO.getCustomers().get(i)));
        }
    }

    public static ArrayList<Project> projectsByEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("projectsByEmployee : null input");
        }
        return (ArrayList<Project>) employee.getProjects();
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer) throws Exception {
        if (customer == null) {
            throw new Exception("projectsByCustomer : null input");
        }

        ArrayList<Project> res = new ArrayList<>();

        for (Project project : getProjects()) {
            if (customer.equals(project.getCustomer())) {
                res.add(project);
            }
        }

        return res;
    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }
}
