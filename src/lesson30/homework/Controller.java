package lesson30.homework;

import lesson30.homework.entities.Customer;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Project;
import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entityDAO.EmployeeDAO;
import lesson30.homework.entityDAO.ProjectDAO;

import java.util.ArrayList;


public class Controller {

    //список сотрудников, работающих над заданным проектом
    public static ArrayList<Employee> employeesByProject(String projectName) throws Exception {
        return EmployeeDAO.employeesByProject(projectName);
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    //список сотрудников, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public static ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }

    //список проектов, в которых участвует заданный сотрудник
    public static ArrayList<Project> projectsByEmployee(Employee employee) throws Exception {
        return ProjectDAO.projectsByEmployee(employee);
    }

    //список проектов, выполняемых для заданного заказчика
    public static ArrayList<Project> projectsByCustomer(Customer customer) throws Exception {
        return ProjectDAO.projectsByCustomer(customer);
    }
}
