package lesson5;

import java.util.Arrays;

public class BankPractice {
    public static void main(String[] args) {
        String[] clients = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        BankPractice bankPractice1 = new BankPractice();

        System.out.println(Arrays.toString(bankPractice1.findClientsByBalance(clients, balances, -100)));
        System.out.println(Arrays.toString(bankPractice1.findClientsWithNegativeBalance(clients, balances)));

        bankPractice1.depositMoney(clients, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));



        //Homework
//        System.out.println(bankPractice1.withdraw(clients, balances, "Nikolay", 1200));
    }

    public String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public void depositMoney(String[] clients, int[] balances, String client, int money) {
        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterComission(money);
    }

    static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client)
                break;
            clientIndex++;
        }
        return clientIndex;
    }

    int calculateDepositAmountAfterComission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.010);
    }

    //Homework
//    public int withdraw(String[] clients, int[] balances, String client, int amount) {
//        int clientIndex = findClientIndexByName(clients, client);
//
//        if (clientIndex <= (clients.length - 1)) {
//            //int clientIndex = findClientIndexByName(clients, client);
//            if (balances[clientIndex] < amount) {
//                return -1;
//            } else {
//                return (balances[clientIndex]) -= amount;
//            }
//        } else {
//            System.out.println("\nClient is absent");
//            return -1;
//        }
//    }
}