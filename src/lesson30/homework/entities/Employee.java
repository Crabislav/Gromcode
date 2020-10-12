package lesson30.homework.entities;

import lesson30.homework.entities.enums.Position;

import java.util.Collection;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;

    private static Date dateHired = new Date();

    private Position position;
    private Department department;

    private Collection<Project> projects;

    public Employee(String firstName, Position position, Department department) {
        this.firstName = firstName;
        this.position = position;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int compareTo(Employee o) {
        return this.lastName.compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return "\n\nEmployee{" +
                "\nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \ndateHired=" + dateHired +
                ", \nposition=" + position +
                ", \ndepartment=" + department +
                ", \nprojects=" + projects +
                '}';
    }
}
