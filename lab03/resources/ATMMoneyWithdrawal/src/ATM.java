
import java.util.ArrayList;

public class ATM {
    String locationAddress;
    int currentCashAmount;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public int getCurrentCashAmount() {
        return currentCashAmount;
    }

    public void setCurrentCashAmount(int currentCashAmount) {
        this.currentCashAmount = currentCashAmount;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void validatePIN(){};
    public void swallowCard(){};
    public void createTransaction(){};
    public void printReceipt(){};

    public void addTransaction(Transaction transaction) {
        if (transaction instanceof Deposit)
            currentCashAmount += transaction.getAmount();
        else if (transaction instanceof Withdrawal)
            currentCashAmount -= transaction.getAmount();
        this.transactions.add(transaction);
    }
}
