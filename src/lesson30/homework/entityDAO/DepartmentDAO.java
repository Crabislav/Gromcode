package lesson30.homework.entityDAO;

import lesson30.homework.entities.enums.DepartmentType;
import lesson30.homework.entities.Department;



import java.util.ArrayList;

public class DepartmentDAO {
    private static ArrayList<Department> departments = new ArrayList<>();

    public static void init(int amount) {
        for (DepartmentType depType : DepartmentType.values()) {
            departments.add(new Department(depType));
        }
    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }
}
