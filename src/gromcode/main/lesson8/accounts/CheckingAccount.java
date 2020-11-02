package gromcode.main.lesson8.accounts;

public class CheckingAccount extends Account {
    int limitOFExpences;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOFExpences) {
        super(bankName, ownerName, moneyAmount);
        this.limitOFExpences = limitOFExpences;
    }

    void withDraw(int amount) {
        if (amount > limitOFExpences)
            return;
        moneyAmount -= amount;
    }



}
