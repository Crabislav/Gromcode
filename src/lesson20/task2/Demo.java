package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date todayDate = new Date();

        Transaction transaction1 = new Transaction(0, "Kiev", 10, "Money", TransactionType.INCOME, todayDate);
        Transaction transaction2 = new Transaction(1, "Odessa", 10, "Paper", TransactionType.OUTCOME, todayDate);
        Transaction transaction3 = new Transaction(2, "Zaporoje", 20, "MOOONEY", TransactionType.INCOME, todayDate);
        Transaction transaction4 = new Transaction(3, "Odessa", 20, "Paper", TransactionType.OUTCOME, todayDate);

        Transaction[] transactions = {transaction1, transaction2, transaction3, transaction4};
        Controller controller = new Controller();


        //save test
        for (Transaction element : transactions) {
            try {
                controller.save(element);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }


        //transactionList - empty
        try {
            System.out.println("Transaction list. No filter");
            System.out.println(Arrays.toString(controller.transactionList()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //transactionList - amount
        try {
            System.out.println("\nTransaction list. Amount filter");
            System.out.println(Arrays.toString(controller.transactionList(10)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //transactionList - city
        try {
            System.out.println("\nTransaction list. City filter");
            System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
