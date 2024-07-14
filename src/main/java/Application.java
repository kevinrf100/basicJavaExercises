import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CurrentAccount kevinAccount = new CurrentAccount(1000, 10, "Kevin Rossetti Fernandes", simpleDateFormat.parse("11/09/1996"));
        CurrentAccount snoopAccount = new CurrentAccount(12131, 12, "Snoop Rossetti Fernandes", simpleDateFormat.parse("27/11/2001"));

        //printing initial Account balance;
        kevinAccount.getAccountBalance();

        kevinAccount.addTransaction(100, TransactionType.DEPOSIT);
        kevinAccount.addTransaction(100, TransactionType.DEPOSIT);
        kevinAccount.addTransaction(100, TransactionType.DEPOSIT);

        kevinAccount.getAccountBalance();

        kevinAccount.addTransaction(20, TransactionType.WITHDRAW);
        kevinAccount.addTransaction(80, TransactionType.WITHDRAW);

        kevinAccount.getAccountBalance();

        kevinAccount.transferOut(100, snoopAccount);
        kevinAccount.transferOut(100, snoopAccount);
        kevinAccount.transferOut(100, snoopAccount);


        kevinAccount.getAccountBalance();
        snoopAccount.getAccountBalance();

        kevinAccount.addTransaction(1000, TransactionType.DEPOSIT);

        kevinAccount.getAccountBalance();

        Date startDate = Date.from(LocalDate.now().minusYears(1).atStartOfDay().toInstant(ZoneOffset.UTC));
        Date finalDate = Date.from(LocalDate.now().plusYears(1).atStartOfDay().toInstant(ZoneOffset.UTC));
        System.out.println(kevinAccount.extractByPeriod(startDate, finalDate));

        kevinAccount.cancelAccount("Spent too much with coffee!");
        System.out.println(kevinAccount.getAccountStatus().toString());
    }
}
