package lesson30;

import lesson30.homework.entities.Department;
import lesson30.homework.entities.Employee;
import lesson30.homework.entities.Firm;
import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entities.enums.Position;
import lesson30.homework.entityDAO.*;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        init(2);







        /*    System.out.println(CustomerDAO.getCustomers());
        printDivider('=');

        System.out.println(ProjectDAO.getProjects());
        printDivider('=');*/

        System.out.println(DepartmentDAO.getDepartments());
        printDivider('=');

        System.out.println(EmployeeDAO.getEmployees());
        printDivider('=');

      /*  FirmDAO firmDAO = new FirmDAO(DepartmentDAO.getDepartments(), CustomerDAO.getCustomers());
        System.out.println(FirmDAO.getFirm());*/

    }

    public static void init(int amount) {
        CustomerDAO.init(amount);
        ProjectDAO.init(amount);
        DepartmentDAO.init(amount);
        EmployeeDAO.init(amount);
        FirmDAO.init(DepartmentDAO.getDepartments(), CustomerDAO.getCustomers());
    }

    private static void printDivider(char symbol) {
        for (int i = 0; i < 50; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
