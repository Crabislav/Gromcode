package gromcode.main.lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() + amount - amount * user.getBank().getCommission(amount));
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
    }

    @Override
    public void paySalary(User user) {
        int salary = user.getSalary();
        user.setBalance(user.getBalance() + salary - user.getBank().getCommission(salary));
    }

//    private void printWithdrawalErrorMsg(int amount, User user) {
//        System.err.println("Can't withdraw money " + amount + "\n   from " + user.toString());
//    }

//    private void printFundErrorMsg(int amount, User user) {
//        System.err.println("Can't fund money " + amount + "\n   from " + user.toString());
//    }

/*    private void printTransferErrorMsg(int amount, User fromUser, User toUser) {
        System.err.println("Can't transfer money " + amount + "\n   from" + fromUser.toString() + "\n   to " + toUser.toString());
    }*/

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
}
