package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444_343_434);
        Bank usBank = new USBank(122, "USA", Currency.USD, 66, 15500, 2, 123_456_789);
        Bank chinaBank = new ChinaBank(11, "China", Currency.USD, 89, 150, 2, 987_456);


        User euUser1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);
        User euUser2 = new User(133, "Alex", 500, 40, "GMD", 1500, euBank);
        User usUser1 = new User(800, "Jack", 900, 40, "GMD", 600, usBank);
        User usUser2 = new User(465, "Joseph", 12200, 40, "GMD", -500, usBank);
        User chinaUser1 = new User(9, "Lee", 805, 40, "GMD", 700, chinaBank);
        User chinaUser2 = new User(5, "Sinhuan", 3000, 40, "GMD", 1500, chinaBank);

        User[] users = new User[]{euUser1, euUser2, usUser1, usUser2, chinaUser1, chinaUser2};

        BankSystem bankSystem = new UkrainianBankSystem();

        checkUpBankSystemMethods(users, bankSystem, euUser1, 50);
    }

    private static void checkUpBankSystemMethods(User[] users, BankSystem bankSystem, User toUser, int amount) {
        for (User user : users) {
            printDivider('=');
            System.out.println("Amount of money is " + amount);
            printDivider('=');
            System.out.println(user.getName() + "'s balance before withdraw " + user.getBalance());
            bankSystem.withdraw(user, amount);
            System.out.println(user.getName() + "'s balance after withdraw " + user.getBalance() + "\n");

            System.out.println(user.getName() + "'s balance before transferMoney " + user.getBalance());
            bankSystem.transferMoney(user, toUser, amount);
            System.out.println(user.getName() + "'s balance after transferMoney " + user.getBalance() + "\n");

            System.out.println(user.getName() + "'s balance before paySalary " + user.getBalance());
            bankSystem.paySalary(user);
            System.out.println(user.getName() + "'s balance after paySalary " + user.getBalance() + "\n");

            System.out.println(user.getName() + "'s balance before fund " + user.getBalance());
            bankSystem.fund(user, amount);
            System.out.println(user.getName() + "'s balance after fund " + user.getBalance() + "\n");


            System.out.println('\n');
        }
    }

    private static void printDivider(char symbol) {
        for (int i = 0; i < 50; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
