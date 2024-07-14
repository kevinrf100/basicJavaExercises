import java.util.Date;

public class Transaction {
    private int value;
    private TransactionType type;
    private Date date;
    private CurrentAccount fromAccount;

    public Transaction() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CurrentAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(CurrentAccount fromAccount) {
        this.fromAccount = fromAccount;
    }
}
