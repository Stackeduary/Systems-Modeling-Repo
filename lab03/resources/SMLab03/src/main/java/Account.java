import org.fulib.classmodel.ClassModel;

import java.util.List;

public class Account {
    String accountID;
    String accountOpeningDate;
    double balance;
    double withdrawLimit;
    Bank bankAccount=new Bank();



    public Account(Bank b, String ID) {
        this.bankAccount=b;
        this.accountID=ID;
        
    }


    public void deposit(int i) {
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(String accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public Bank getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Bank bankAccount) {
        this.bankAccount = bankAccount;
    }
}
