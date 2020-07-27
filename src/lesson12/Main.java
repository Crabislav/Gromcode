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

        checkAndPrintMethodResults(users, euUser2, bankSystem, 50);

    }

    //Method is only for beautiful console output
    private static void printDivider(char symbol) {
        for (int i = 0; i < 50; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    //Method is only for beautiful console output
    private static void printOperationResults(User fromUser, User toUser, int amount, BankSystem bankSystem, OperationName operationName) {
        printDivider('=');
        System.out.println("Operation - " + operationName);
        System.out.println(fromUser.getBank().getClass());
        printDivider('=');

        if (operationName == OperationName.PAY_SALARY) {
            printAmountMsg(operationName, fromUser.getSalary());
        } else {
            printAmountMsg(operationName, amount);
        }

        printDivider('-');

        printBalanceMsg(operationName, "Before", fromUser);
        defineOperationToUse(fromUser, toUser, amount, bankSystem, operationName);
        printBalanceMsg(operationName, "After", fromUser);

        System.out.println("\n");
    }

    //Method is only for beautiful console output
    private static void printBalanceMsg(OperationName operationName, String msg, User user) {
        System.out.println(msg + " " + operationName + " balance is " + user.getBalance());
    }

    //Method is only for beautiful console output
    private static void printAmountMsg(OperationName operationName, int output) {
        System.out.println("Amount of money to " + operationName + " is " + output);
    }

    //Method is only for beautiful console output
    private static void defineOperationToUse(User user, User toUser, int amount, BankSystem bankSystem, OperationName operationName) {
        switch (operationName) {
            case WITHDRAW:
                bankSystem.withdraw(user, amount);
                break;
            case FUND:
                bankSystem.fund(user, amount);
                break;
            case TRANSFER:
                bankSystem.transferMoney(user, toUser, amount);
                break;
            case PAY_SALARY:
                bankSystem.paySalary(user);
                break;
            default:
                System.err.println("Wrong operation was chosen");
                break;
        }
    }

    //Method is only for beautiful console output
    private static void checkAndPrintMethodResults(User[] users, User toUser, BankSystem bankSystem, int amount) {
        for (User user : users) {
            printDivider('/');
            System.out.println("User " + user.getName());
            printDivider('/');
            System.out.println();

            for (OperationName operationName : OperationName.values()) {
                printOperationResults(user, toUser, amount, bankSystem, operationName);
            }
        }
    }
}
