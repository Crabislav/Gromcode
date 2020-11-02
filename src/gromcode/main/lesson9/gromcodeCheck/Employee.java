package gromcode.main.lesson9.gromcodeCheck;

import gromcode.main.lesson9.Company;

public class Employee {
    String name;
    Company company;
    int monthlySalary;


    public Employee(String name, Company company, int monthlySalary) {
        this.name = name;
        this.company = company;
        this.monthlySalary = monthlySalary;
    }
}
