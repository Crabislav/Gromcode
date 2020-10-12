package lesson30.examples.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {
    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), amount, TransactionType.WITHDRAW, "aasd");
    }


    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() + amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), amount, TransactionType.FUNDING, "aasd");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //withdraw money from User
        //fund money to User

        if (!checkWithdraw(fromUser, amount) && !checkFund(toUser, amount)) {
            System.err.println("Can't transfer money " + amount + "\n   from" + fromUser.toString() + "\n   to " + toUser.toString());
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount - amount * toUser.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), amount, TransactionType.TRANSFER, "transfer");
    }

    @Override
    public void paySalary(User user) {
        int salary = user.getSalary();
        user.setBalance(user.getBalance() + salary - user.getBank().getCommission(salary));

        createAndSaveTransaction(new Date(), salary, TransactionType.SALARY_INCOME, "salary");
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkFund(User user, int amount) {
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + "\n   from " + user.toString());
            return false;
        }
        return true;
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            System.err.println("Can't withdraw money " + amount + "\n   from " + user.toString());
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated, int amount, TransactionType type, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
