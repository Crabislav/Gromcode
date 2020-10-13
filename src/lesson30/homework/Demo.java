package lesson30.homework;


import lesson30.homework.entityDAO.*;

public class Demo {
    public static void main(String[] args) {
        Utils.init(3);

//        Utils.printResults(CustomerDAO.getCustomers());
//        Utils.printResults(DepartmentDAO.getDepartments());
//        Utils.printResults(EmployeeDAO.getEmployees());
//        Utils.printResults(ProjectDAO.getProjects());
//        Utils.printResults(FirmDAO.getFirm());

        Utils.testEmployeeDAOMethods();
    }


}
