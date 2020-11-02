package gromcode.main.lesson30.homework;

import gromcode.main.lesson30.homework.entities.Customer;
import gromcode.main.lesson30.homework.entities.Employee;
import gromcode.main.lesson30.homework.entities.Project;
import gromcode.main.lesson30.homework.entities.enums.DepartmentType;
import gromcode.main.lesson30.homework.entityDAO.EmployeeDAO;
import gromcode.main.lesson30.homework.entityDAO.ProjectDAO;

import java.util.ArrayList;
import java.util.Set;


public class Controller {

    //список сотрудников, работающих над заданным проектом
    public static Set<Employee> employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    //список сотрудников, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public static Set<Employee> employeesByTeamLead(Employee lead) {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }

    //список проектов, в которых участвует заданный сотрудник
    public static ArrayList<Project> projectsByEmployee(Employee employee) {
        return ProjectDAO.projectsByEmployee(employee);
    }

    //список проектов, выполняемых для заданного заказчика
    public static ArrayList<Project> projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }
}
