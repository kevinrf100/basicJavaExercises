import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        CurrentAccount currentAccount = new CurrentAccount();

        //printing initial Account balance;
        currentAccount.getAccountBalance();

        currentAccount.addTransaction(100, TransactionType.DEPOSIT);
        currentAccount.addTransaction(100, TransactionType.DEPOSIT);
        currentAccount.addTransaction(100, TransactionType.DEPOSIT);

        currentAccount.getAccountBalance();

        currentAccount.addTransaction(20, TransactionType.WITHDRAW);
        currentAccount.addTransaction(80, TransactionType.WITHDRAW);

        currentAccount.getAccountBalance();

        currentAccount.addTransaction(100, TransactionType.TRANSFER_OUT);
        currentAccount.addTransaction(100, TransactionType.TRANSFER_OUT);
        currentAccount.addTransaction(100, TransactionType.TRANSFER_OUT);

        currentAccount.getAccountBalance();

        currentAccount.addTransaction(1000, TransactionType.TRANSFER_IN);

        currentAccount.getAccountBalance();

        currentAccount.addTransaction(1000, TransactionType.WITHDRAW);

        currentAccount.getAccountBalance();

        Date startDate = Date.from(LocalDate.now().minusYears(1).atStartOfDay().toInstant(ZoneOffset.UTC));
        Date finalDate = Date.from(LocalDate.now().plusYears(1).atStartOfDay().toInstant(ZoneOffset.UTC));
        System.out.println(currentAccount.extractByPeriod(startDate, finalDate));

        currentAccount.cancelAccount("Spent too much with coffee!");
        System.out.println(currentAccount.getAccountStatus().toString());
    }
}
