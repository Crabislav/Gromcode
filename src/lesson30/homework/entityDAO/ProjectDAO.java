package lesson30.homework.entityDAO;

import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;

import java.util.ArrayList;

public class ProjectDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public ProjectDAO() {
        Project project1 = new Project("project0", CustomerDAO.getCustomers().get(0));
        Project project2 = new Project("project1", CustomerDAO.getCustomers().get(1));
        Project project3 = new Project("project2", CustomerDAO.getCustomers().get(2));
        Project project4 = new Project("project3", CustomerDAO.getCustomers().get(3));
        Project project5 = new Project("project4", CustomerDAO.getCustomers().get(4));

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);

    }

    public static ArrayList<Project> projectsByEmployee(Employee employee) {
        return (ArrayList<Project>) employee.getProjects();
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer) {
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
