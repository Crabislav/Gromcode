package lesson30.homework;

import lesson30.homework.entities.Department;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;
import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entities.enums.Position;
import lesson30.homework.entityDAO.*;

import java.util.ArrayList;
import java.util.Collection;

public class Utils {
    static <T> void printResults(Collection<T> input) {
        printDivider();
        System.out.println(input);
        printDivider();
    }

    private static void printDivider() {
        for (int i = 0; i < EmployeeDAO.getEmployees().get(0).toString().length(); i++) {
            System.out.print('=');
        }
        System.out.println();
    }

    static void testEmployeeDAOMethods() {
        ArrayList<Collection<Employee>> testResults = new ArrayList<>();

        //employeesByProject +
        try {
            testResults.add(Controller.employeesByProject(ProjectDAO.getProjects().get(0).getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //employeesByDepartmentWithoutProject +
        try {
            testResults.add(Controller.employeesByDepartmentWithoutProject(DepartmentType.FINANCE));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //employeesWithoutProject +
        try {
            testResults.add(Controller.employeesWithoutProject());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //employeesByTeamLead +
        try {
            testResults.add(Controller.employeesByTeamLead(findTeamLead()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //teamLeadsByEmployee +
        try {
            testResults.add(Controller.teamLeadsByEmployee(EmployeeDAO.getEmployees().get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }


        //employeesByProjectEmployee +
        try {
            testResults.add(Controller.employeesByProjectEmployee(EmployeeDAO.getEmployees().get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //employeesByCustomerProjects +
        try {
            testResults.add(Controller.employeesByCustomerProjects(CustomerDAO.getCustomers().get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Collection<Employee> testValue : testResults) {
            printResults(testValue);
        }

    }

    static void testProjectDAOMethods() {
        ArrayList<Collection<Project>> testResults = new ArrayList<>();

        //projectsByEmployee +
        try {
            testResults.add(Controller.projectsByEmployee(EmployeeDAO.getEmployees().get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //projectsByCustomer +
        try {
            testResults.add(Controller.projectsByCustomer(CustomerDAO.getCustomers().get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Collection<Project> testValue : testResults) {
            printResults(testValue);
        }
    }

    private static Employee findTeamLead() {
        ArrayList<Employee> employees = EmployeeDAO.getEmployees();
        Employee lead = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getPosition() == Position.TEAM_LEAD) {
                lead = employee;
                break;
            }
        }
        return lead;
    }

}
