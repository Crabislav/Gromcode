package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        //Cумма транзакции больше указанного лимита +
        //Cумма транзакций за день больше дневного лимита +
        //Kоличество транзакций за день больше указанного лимита +
        //Eсли город оплаты (совершения транзакции) не разрешен - BadRequestException +
        //saving null - BadRequestException +
        //not enough space at array - InternalServerException +
        //saving the same transaction - BadRequestException +

        validate(transaction);

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        //not enough space at array
        throw new InternalServerException("No space for transaction (id=" + transaction.getId() + ")");
    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new BadRequestException("Can't save null transaction");
        }

        //saving the same transaction
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new BadRequestException("Can't save the same transaction (id=" + transaction.getId() + ")");
            }
        }

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ".  Can't be saved");
        }

        int sum = 0;
        int count = 0;

        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed (id=" + transaction.getId() + ").  Can't be save");
        }

        if (count + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit  per day count exceed (id=" + transaction.getId() + ").  Can't be saved");
        }

        validateTransactionCity(transaction);
    }

    private void validateTransactionCity(Transaction transaction) throws BadRequestException {
        for (String city : utils.getCities()) {
            if (transaction.getCity().equals(city)) {
                return;
            }
        }
        throw new BadRequestException("Invalid transaction's (id=" + transaction.getId() + ") city");
    }

    public Transaction[] transactionList() {
        return transactions;
    }

    public Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                result[index] = tr;
                index++;
            }
        }

        return result;
    }

    public Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    count++;
                }
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }
}
