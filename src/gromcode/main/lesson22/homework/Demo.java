package gromcode.main.lesson22.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date todayDate = new Date();

        Transaction transaction1 = new Transaction(0, "Kiev", 10, "Money", TransactionType.INCOME, todayDate);
        Transaction transaction2 = new Transaction(1, "Odessa", 10, "Paper", TransactionType.OUTCOME, todayDate);
        Transaction transactionInvalidCity = new Transaction(2, "Zaporoje", 20, "MOOONEY", TransactionType.INCOME, todayDate);
        Transaction transaction4 = new Transaction(3, "Odessa", 10, "Paper", TransactionType.OUTCOME, todayDate);
        Transaction transaction5 = new Transaction(4, "Odessa", 10, "Paper", TransactionType.OUTCOME, todayDate);
        Transaction transaction6 = new Transaction(5, "Odessa", 10, "Paper", TransactionType.OUTCOME, todayDate);
        Transaction transaction7 = new Transaction(6, "Odessa", 5, "Paper", TransactionType.OUTCOME, todayDate);

        Transaction[] trNormal = {transaction1, transaction2, transaction4, transaction5, transaction6};
        Transaction[] trInvalidCity = {transaction1, transaction2, transactionInvalidCity, transaction4, transaction5, transaction6};
        Transaction[] trNoSpace = {transaction1, transaction2, transaction4, transaction5, transaction6, transaction7};
        Transaction[] trInvalidAllAmount = {transaction1, transaction2, transaction4, transaction5, transaction6, transaction7};

//        testMethods(trNormal, "Kiev", 10);
//        testMethods(trInvalidCity, "Kiev", 10);
//        testMethods(trNoSpace, "Kiev", 10);
        testMethods(trInvalidAllAmount, "Kiev", 10);
    }

    private static void testMethods(Transaction[] trNormal, String city, int amount) {
        //save test
        for (Transaction element : trNormal) {
            try {
                Controller.save(element);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        //transactionList - empty
        try {
            System.out.println("Transaction list. No filter");
            System.out.println(Arrays.toString(Controller.transactionList()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //transactionList - amount
        try {
            System.out.println("\nTransaction list. Amount filter");
            System.out.println(Arrays.toString(Controller.transactionList(amount)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //transactionList - city
        try {
            System.out.println("\nTransaction list. City filter");
            System.out.println(Arrays.toString(Controller.transactionList(city)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
