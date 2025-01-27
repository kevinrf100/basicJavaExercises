import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrentAccount {
    Integer number;
    Integer agency;
    String clientName;
    Date birthDayDate;
    private AccountStatus accountStatus = new AccountStatus(true);
    private final List<Transaction> transactions = new ArrayList<>();

    public CurrentAccount(Integer number, Integer agency, String clientName, Date birthDayDate) {
        this.number = number;
        this.agency = agency;
        this.clientName = clientName;
        this.birthDayDate = birthDayDate;
    }

    public List<Transaction> extractByPeriod(Date initialDate, Date finalDate) {
        return this.transactions.stream().filter(transaction -> transaction.getDate().compareTo(initialDate) > 0 && transaction.getDate().compareTo(finalDate) < 0).toList();
    }

    public void cancelAccount(String description) {
        AccountStatus newAccountStatus = new AccountStatus(false);
        newAccountStatus.setDescription(description);

        this.setAccountStatus(newAccountStatus);
    }

    public void transferOut(int value, CurrentAccount toAccount) {
        Transaction transaction = new Transaction();

        transaction.setType(TransactionType.TRANSFER);
        transaction.setValue(value);
        transaction.setDate(new Date());
        transaction.setFromAccount(this);

        toAccount.addTransaction(transaction);
        this.addTransaction(transaction);
    }

    public void addTransaction(int value, TransactionType type) {
        Transaction transaction = new Transaction();

        transaction.setType(type);
        transaction.setValue(value);
        transaction.setDate(new Date());

        this.transactions.add(transaction);

        System.out.println("Transaction Created");
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void getAccountBalance() {
        int balance = 0;
        for (Transaction transaction : this.transactions) {
            TransactionType type = transaction.getType();
            balance = switch (type) {
                case DEPOSIT -> balance + transaction.getValue();
                case WITHDRAW -> balance - transaction.getValue();
                case TRANSFER -> {
                    if (transaction.getFromAccount().equals(this)) {
                        yield balance - transaction.getValue();
                    } else {
                        yield balance + transaction.getValue();
                    }
                }
            };
        }

        System.out.println(clientName + " balance is:" + balance);
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
