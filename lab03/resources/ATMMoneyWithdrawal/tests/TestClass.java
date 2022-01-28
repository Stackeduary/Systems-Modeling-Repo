import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class TestClass {
    @Test
    public void test1() {
        // Initial setup
        Bank chase = new Bank();
        ATM atm = new ATM();
        Client anna = new Client();
        Account account = new CheckingsAccount();

        atm.setCurrentCashAmount(112465);
        atm.setLocationAddress("Boston");
        ArrayList<ATM> atms = new ArrayList<>();
        atms.add(atm);

        chase.setAtms(atms);

        account.setBalance(1310);
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account);

        anna.setAccounts(accounts);
        anna.setName("Anna");
        // Anna withdraws all 1310 from her account

        anna.getAccounts().get(0).withdraw(1310, atm);

        Assert.assertEquals(111155, atm.getCurrentCashAmount());
        Assert.assertEquals(0, account.getBalance() , 0.001);
        Assert.assertEquals(1, atm.getTransactions().size());


    }
    @Test
    public void test2() {
        // Initial setup
        Bank siam = new Bank();
        ATM atm = new ATM();
        Client Busdarika = new Client();
        Account account = new CheckingsAccount();

        atm.setCurrentCashAmount(2453000);
        atm.setLocationAddress("Phuket");
        ArrayList<ATM> atms = new ArrayList<>();
        atms.add(atm);

        siam.setAtms(atms);

        account.setBalance(1388.80f);
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account);

        Busdarika.setAccounts(accounts);
        Busdarika.setName("Busdarika");
        // Busdarika deposits  2000 to his account

        Busdarika.getAccounts().get(0).deposit(2000, atm);

        Assert.assertEquals(2455000, atm.getCurrentCashAmount());
        Assert.assertEquals(3388.80, account.getBalance(),  0.001);
        Assert.assertEquals(1, atm.getTransactions().size());
    }
}
