package lesson30.examples.task1;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444_343_434);
        User user = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(user, 150);
        Thread.sleep(2000);
        bankSystem.withdraw(user, 10);

        System.out.println(bankSystem.getTransactions());
    }
}
