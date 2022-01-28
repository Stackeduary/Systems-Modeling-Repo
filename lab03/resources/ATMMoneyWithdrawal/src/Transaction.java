
import java.util.Date;

public abstract class Transaction {
    Date date;
    String time;
    String transactionID;
    int amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Transaction(int amount) {
        this.date = new Date();
        this.time = new Date().toString();
        this.amount = amount;
    }
}
