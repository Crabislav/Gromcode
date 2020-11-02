package gromcode.main.lesson21;

public class Company {
    private int numberOfEmployees;
    private String name;
    private static String license;

    private static int maxNumberOfEmployees = 100;

    static {
        System.out.println("Code block is called");
        init();
    }

    public Company(int numberOfEmployees, String name) throws Exception {
        if (numberOfEmployees > maxNumberOfEmployees) {
            throw new Exception("Company can have " + maxNumberOfEmployees + " employees");
        }

        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
    }

    private static void init() {
        maxNumberOfEmployees = 100;
    }

    public static void validate() throws Exception {
        if (!license.equals("TTT111")) {
            throw new Exception("Wrong license" + license);
        }

    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    public static void setLicense(String license) {
        Company.license = license;
    }

    private static class Test {

    }
}
