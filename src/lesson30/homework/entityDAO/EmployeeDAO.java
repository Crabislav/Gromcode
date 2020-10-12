package lesson30.homework.entityDAO;

import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entities.enums.Position;
import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Department;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;

import java.util.ArrayList;

public class EmployeeDAO {
    private static ArrayList<Employee> employees = new ArrayList<>();

    //TODO: finish
    public static void init(int amount) {
        Position position = null;
        String firstName = "";
        Employee employee;

        ArrayList<Department> departments = DepartmentDAO.getDepartments();

        int index = 0;
        for (Department department : departments) {
            for (int i = 0; i < amount; i++) {
                switch (department.getType()) {
                    case MANAGEMENT:
                        position = Position.MANAGER;
                        firstName = "Manager";
                        break;
                    case FINANCE:
                        position = Position.FINANCE;
                        firstName = "Finance";
                        break;
                    case ANALYSTS:
                        position = Position.ANALYST;
                        firstName = "Analyst";
                        break;
                    case DESIGNING:
                        position = Position.DESIGNER;
                        firstName = "Designer";
                        break;
                    case DEVELOPING:
                        position = Position.DEVELOPER;
                        firstName = "Developer";
                        break;
                    default:
                        System.err.println("Unknown department");
                }
                employee = new Employee(firstName + (i + 1), position, departments.get(index));
                employee.setDepartment(department);
                employees.add(employee);
            }
            index++;
        }

        ArrayList<Employee> decEmployees = new ArrayList<>();

        for (Department department : DepartmentDAO.getDepartments()) {
            decEmployees.clear();
            if (department.getEmployees() == null) {
                for (Employee element : EmployeeDAO.getEmployees()) {
                    if (department.getType() == DepartmentType.DEVELOPING && element.getPosition() == Position.DEVELOPER) {
                        decEmployees.add(element);
                    }
                }
            }
            department.setEmployees(decEmployees);
        }
    }

    //TODO: test
    //список сотрудников, работающих над заданным проектом
    public static ArrayList<Employee> employeesByProject(String projectName) throws Exception {
        if (projectName == null) {
            throw new Exception("employeesByProject : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Employee employee : EmployeeDAO.getEmployees()) {
            for (Project project : ProjectDAO.getProjects()) {
                if (project != null && projectName.equals(project.getName())) {
                    res.add(employee);
                }
            }
        }

        return res;
    }

    //TODO: refactor + test
    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        if (departmentType == null) {
            throw new Exception("employeesByDepartmentWithoutProject : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Department department : DepartmentDAO.getDepartments()) {
            if (department.getType().equals(departmentType)) {
                for (Employee employee : department.getEmployees()) {
                    if (employee.getProjects().isEmpty()) {
                        res.add(employee);
                    }
                }
            }
        }

        return res;
    }

    //TODO: refactor + test
    //список сотрудников, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> res = new ArrayList<>();

        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee != null && employee.getProjects().isEmpty()) {
                res.add(employee);
            }
        }

        return res;
    }

    //TODO: test
    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public static ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {
        if (lead == null) {
            throw new Exception("employeesByTeamLead : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Project project : lead.getProjects()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getProjects().contains(project)) {
                    res.add(employee);
                }
            }
        }
        return res;
    }

    //TODO: test + refactor
    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("teamLeadsByEmployee : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Employee element : employees) {
            for (Project elementProject : element.getProjects()) {
                for (Project employeeProject : employee.getProjects()) {
                    if (elementProject.equals(employeeProject) && element.getPosition() == Position.TEAM_LEAD) {
                        res.add(element);
                    }
                }
            }

        }
        return res;
    }

    //TODO: test + refactor
    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("employeesByProjectEmployee : null input");
        }
        ArrayList<Employee> res = new ArrayList<>();

        for (Employee element : employees) {
            for (Project elementProject : element.getProjects()) {
                for (Project employeeProject : employee.getProjects()) {
                    if (elementProject.equals(employeeProject)) {
                        res.add(element);
                    }
                }
            }
        }
        return res;
    }

    //TODO: test
    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {
        if (customer == null) {
            throw new Exception("employeesByCustomerProjects : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Employee element : employees) {
            for (Project project : element.getProjects()) {
                if (project.getCustomer().equals(customer)) {
                    res.add(element);
                }
            }
        }
        return res;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
