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
        Employee employee1 = new Employee("employe1", Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(0));
        Employee employee2 = new Employee("employe2", Position.ANALYST, DepartmentDAO.getDepartments().get(1));
        Employee employee3 = new Employee("employe3", Position.FINANCE, DepartmentDAO.getDepartments().get(0));
        Employee employee4 = new Employee("employe4", Position.MANAGER, DepartmentDAO.getDepartments().get(0));
        Employee employee5 = new Employee("employe5", Position.DEVELOPER, DepartmentDAO.getDepartments().get(0));
        Employee employee6 = new Employee("employe6", Position.MANAGER, DepartmentDAO.getDepartments().get(1));
        Employee employee7 = new Employee("employe7", Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(1));

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
        employee7.getProjects().add(ProjectDAO.getProjects().get(1));

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

        for (Employee employee : employees) {

            //TODO: refactor
            for (Project project : employee.getProjects()) {
                if (employee.getProjects() != null && projectName.equals(project.getName())) {
                    res.add(employee);
                }
            }

        }
        return res;
    }

//    private static void getEmployeesByProject(Collection<Project> projects, Collection<Employee> result, Object element, boolean condition) {
//        for (Project project : projects) {
//            if (condition) {
//                result.add(element);
//            }
//        }
//    }


    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        for (Department department : DepartmentDAO.getDepartments()) {
            if (department.getType() == departmentType) {
                return getEmployeesWithoutProjects(department.getEmployees());
            }
        }
        return new ArrayList<>();
    }

    //список сотрудников, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
        return getEmployeesWithoutProjects(EmployeeDAO.getEmployees());
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

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public static Set<Employee> employeesByTeamLead(Employee lead) {
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


    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> res = new HashSet<>();

        for (Employee element : employees) {

            for (Project elementProject : element.getProjects()) {

                //TODO:refactor
                for (Project employeeProject : employee.getProjects()) {
                    if (elementProject.equals(employeeProject) && element.getPosition() == Position.TEAM_LEAD) {
                        res.add(element);
                    }
                }
            }

        }
        return res;
    }


    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> res = new HashSet<>();

        for (Employee element : employees) {
            for (Project elementProject : element.getProjects()) {

                //TODO: refactor
                for (Project employeeProject : employee.getProjects()) {
                    if (elementProject.equals(employeeProject)) {
                        res.add(element);
                    }
                }
            }
        }
        return res;
    }


    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) {
        ArrayList<Employee> res = new ArrayList<>();

        for (Employee element : employees) {

            //TODO: refactor
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
