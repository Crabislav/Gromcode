package lesson30.homework.entityDAO;

import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entities.enums.Position;
import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Department;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void init(int amount) {
        createEmployees(amount);
        settEmployeesToDepartments();
        settEmployeesToProjects();
    }

    private static void settEmployeesToProjects() {
        int index = 0;
        for (Employee employee : employees) {
            if (employees != null && (index < employees.toArray().length / 2)) {
                employee.setProjects(ProjectDAO.getProjects());
                index++;
            }
        }
    }

    private static void settEmployeesToDepartments() {
        for (Department department : DepartmentDAO.getDepartments()) {
            ArrayList<Employee> departmentEmployees = new ArrayList<>();

            for (Employee employee : employees) {
                if (employee.getDepartment().getType() == department.getType()) {
                    departmentEmployees.add(employee);
                }
            }
            department.setEmployees(departmentEmployees);
        }
    }

    private static void createEmployees(int amount) {
        Position position = null;
        String firstName = "";

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
                //adding an employee for current department
                addAnEmployee(firstName + (i + 1), position, departments.get(index));
            }
            //adding a teamLead for each department
            addAnEmployee("TeamLead-" + department.getType(), Position.TEAM_LEAD, departments.get(index));
            index++;
        }
    }

    private static void addAnEmployee(String firstName, Position position, Department department) {
        Employee employee = new Employee(firstName, position, department);
        employee.setDepartment(department);
        employees.add(employee);
    }


    //TODO: refactor
    //список сотрудников, работающих над заданным проектом
    public static ArrayList<Employee> employeesByProject(String projectName) throws Exception {
        if (projectName == null) {
            throw new Exception("employeesByProject : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee != null) {
                for (Project project : employee.getProjects()) {
                    if (employee.getProjects() != null && projectName.equals(project.getName())) {
                        res.add(employee);
                    }
                }
            }
        }

        return res;
    }

    //TODO: refactor + test
    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws
            Exception {
        if (departmentType == null) {
            throw new Exception("employeesByDepartmentWithoutProject : null input");
        }

        ArrayList<Employee> res = new ArrayList<>();

        for (Department department : DepartmentDAO.getDepartments()) {
            if (department.getType() == departmentType) {
                for (Employee employee : department.getEmployees()) {
                    if (employee.getProjects().isEmpty()) {
                        res.add(employee);
                    }
                }
            }
        }
        return res;
    }

    //TODO: refactor
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
    public static Set<Employee> employeesByTeamLead(Employee lead) throws Exception {
        if (lead == null) {
            throw new Exception("employeesByTeamLead : null input");
        }

        Set<Employee> res = new HashSet<>();

        for (Project project : lead.getProjects()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getProjects().contains(project) && lead.getDepartment() == employee.getDepartment()) {
                    res.add(employee);
                }
            }
        }
        return res;
    }

    //TODO: test + refactor
    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static Set<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("teamLeadsByEmployee : null input");
        }

        Set<Employee> res = new HashSet<>();

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
    public static Set<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("employeesByProjectEmployee : null input");
        }
        Set<Employee> res = new HashSet<>();

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

    //TODO: refactor
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