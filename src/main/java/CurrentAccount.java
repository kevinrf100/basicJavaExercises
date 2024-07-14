import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrentAccount {
    private AccountStatus accountStatus = new AccountStatus(true);
    private final List<Transaction> transactions = new ArrayList<>();

    public CurrentAccount() {
    }

    public List<Transaction> extractByPeriod(Date initialDate, Date finalDate) {
        return this.transactions.stream().filter(transaction -> transaction.getDate().compareTo(initialDate) > 0 && transaction.getDate().compareTo(finalDate) < 0).toList();
    }

    public void cancelAccount(String description) {
        AccountStatus newAccountStatus = new AccountStatus(false);
        newAccountStatus.setDescription(description);

        this.setAccountStatus(newAccountStatus);
    }

    public void addTransaction(int value, TransactionType type) {
        Transaction transaction = new Transaction();

        transaction.setType(type);
        transaction.setValue(value);
        transaction.setDate(new Date());

        this.transactions.add(transaction);

        System.out.println("Transaction Created");
    }

    public void getAccountBalance() {
        int balance = 0;
        for (Transaction transaction : this.transactions) {
            TransactionType type = transaction.getType();
            balance = switch (type) {
                case DEPOSIT, TRANSFER_IN -> balance + transaction.getValue();
                case WITHDRAW, TRANSFER_OUT -> balance - transaction.getValue();
            };
        }

        System.out.println("You account balance is:" + balance);
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
