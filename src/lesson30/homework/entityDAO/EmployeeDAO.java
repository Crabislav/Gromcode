package lesson30.homework.entityDAO;

import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entities.enums.Position;
import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Department;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDAO() {
        Employee employee1 = new Employee("employe0", Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(0));
        Employee employee2 = new Employee("employe1", Position.ANALYST, DepartmentDAO.getDepartments().get(1));
        Employee employee3 = new Employee("employe2", Position.FINANCE, DepartmentDAO.getDepartments().get(0));
        Employee employee4 = new Employee("employe3", Position.MANAGER, DepartmentDAO.getDepartments().get(0));
        Employee employee5 = new Employee("employe4", Position.DEVELOPER, DepartmentDAO.getDepartments().get(0));
        Employee employee6 = new Employee("employe5", Position.MANAGER, DepartmentDAO.getDepartments().get(1));
        Employee employee7 = new Employee("employe6", Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(1));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);

        employee1.getProjects().add(ProjectDAO.getProjects().get(0));
        employee1.getProjects().add(ProjectDAO.getProjects().get(1));
        employee2.getProjects().add(ProjectDAO.getProjects().get(0));
        employee2.getProjects().add(ProjectDAO.getProjects().get(1));
        employee3.getProjects().add(ProjectDAO.getProjects().get(0));
        employee4.getProjects().add(ProjectDAO.getProjects().get(0));
        employee5.getProjects().add(ProjectDAO.getProjects().get(0));
        employee6.getProjects().add(ProjectDAO.getProjects().get(1));
//        employee7.getProjects().add(ProjectDAO.getProjects().get(1));

        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(0));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployees().get(1));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(2));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(3));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(4));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployees().get(5));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployees().get(6));
    }

    //список сотрудников, работающих над заданным проектом
    public static Set<Employee> employeesByProject(String projectName) {
        Set<Employee> res = new HashSet<>();

        for (Project project : ProjectDAO.getProjects()) {
            if (projectName.equals(project.getName())) {
                res.addAll(getEmployeesByProject(project));
            }
        }

        return res;
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Employee> res = new ArrayList<>();

        for (Department department : DepartmentDAO.getDepartments()) {
            if (department != null && department.getType() == departmentType) {
                res.addAll(getEmployeesWithoutProjects(department.getEmployees()));
            }
        }

        return res;
    }

    //список сотрудников, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
        return getEmployeesWithoutProjects(EmployeeDAO.getEmployees());
    }

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public static Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> res = new HashSet<>();

        for (Project project : lead.getProjects()) {
            ArrayList<Employee> employeesByProject = getEmployeesByProject(project);

            for (Employee employee : employeesByProject) {
                if (!employee.equals(lead)) {
                    res.add(employee);
                }
            }
        }

        return res;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> res = new HashSet<>();

        for (Project project : employee.getProjects()) {
            Employee teamLead = getTeamLead(project);

            if (project != null && teamLead != null) {
                res.add(teamLead);
            }
        }

        return res;
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> res = new HashSet<>();

        for (Project project : ProjectDAO.getProjects()) {
            if (employee.getProjects().contains(project)) {
                res.addAll(getEmployeesByProject(project));
            }
        }

        return res;
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) {
        ArrayList<Employee> res = new ArrayList<>();

        for (Project project : ProjectDAO.getProjects()) {
            if (project != null && customer.equals(project.getCustomer())) {
                res.addAll(getEmployeesByProject(project));
            }
        }

        return res;
    }

    private static ArrayList<Employee> getEmployeesByProject(Project project) {
        ArrayList<Employee> res = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().contains(project)) {
                res.add(employee);
            }
        }

        return res;
    }

    private static Employee getTeamLead(Project project) {
        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().contains(project) && employee.getPosition() == Position.TEAM_LEAD) {
                return employee;
            }
        }

        return null;
    }

    private static ArrayList<Employee> getEmployeesWithoutProjects(Collection<Employee> employees) {
        ArrayList<Employee> res = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().isEmpty()) {
                res.add(employee);
            }
        }

        return res;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
