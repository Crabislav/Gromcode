package lesson30.homework.entities;

import lesson30.homework.entities.enums.DepartmentType;

import java.util.Collection;

public class Department {
    private DepartmentType type;
    private Collection<Employee> employees;

    public Department(DepartmentType type) {
        this.type = type;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "\n\nDepartment\n{" +
                "type=" + type +
                ", \nemployees=" + employees +
                '}';
    }
}
