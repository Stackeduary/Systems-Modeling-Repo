public abstract class Account {
    String ownerName;
    String accountNumber;
    float balance;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void deposit(int amount, ATM atm){
        this.balance = this.balance + amount;
        atm.addTransaction(new Deposit(amount));
    };
    public void withdraw(int amount, ATM atm){
        this.balance = this.balance - amount;
        atm.addTransaction( new Withdrawal(amount));
    };
}
