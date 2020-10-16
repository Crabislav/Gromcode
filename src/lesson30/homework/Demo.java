package lesson30.homework;


import lesson30.homework.entityDAO.*;

public class Demo {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        FirmDAO firmDAO = new FirmDAO(DepartmentDAO.getDepartments(), CustomerDAO.getCustomers());


//        Utils.printResults(CustomerDAO.getCustomers());
//        Utils.printResults(DepartmentDAO.getDepartments());
//        Utils.printResults(EmployeeDAO.getEmployees());
//        Utils.printResults(ProjectDAO.getProjects());
//        Utils.printResults(FirmDAO.getFirm());

        Utils.testEmployeeDAOMethods();
        Utils.testProjectDAOMethods();
    }


}
