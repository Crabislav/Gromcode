package lesson25.examples;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(1);
        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("rrr"));

        int variable = 100;
        Long variable2 = 222L; //new Long(222);

        generalDAO.validate(variable2);

        generalDAO.validate(variable);
    }
}
