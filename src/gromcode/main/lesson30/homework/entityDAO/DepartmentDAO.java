package gromcode.main.lesson30.homework.entityDAO;

import gromcode.main.lesson30.homework.entities.enums.DepartmentType;
import gromcode.main.lesson30.homework.entities.Department;


import java.util.ArrayList;

public class DepartmentDAO {
    private static ArrayList<Department> departments = new ArrayList<>();

    public DepartmentDAO() {
        Department management = new Department(DepartmentType.MANAGEMENT);
        Department analysts = new Department(DepartmentType.ANALYSTS);
        Department designers = new Department(DepartmentType.DESIGNING);
        Department developers = new Department(DepartmentType.DEVELOPING);
        Department finances = new Department(DepartmentType.FINANCE);

        departments.add(management);
        departments.add(analysts);
        departments.add(designers);
        departments.add(developers);
        departments.add(finances);

    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }
}
