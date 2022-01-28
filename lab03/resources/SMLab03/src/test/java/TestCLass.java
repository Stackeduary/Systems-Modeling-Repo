import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizCmdLineEngine;
import org.fulib.FulibTools;
import org.junit.Before;
import org.junit.Test;

public class TestCLass {

    Bank b ;
    Customer alice ;
    Customer bob ;
    Customer charlie;
    Account ab ;
    Account ac ;


    @Before
    public void initialization(){
        b = new Bank();
        alice = new Customer("Alice");
        bob = new Customer("Bob");
        charlie = new Customer("Charlie");
        ab = new Account(b, "32442545");
        ac = new Account(b, "44543214");
    }


    @Test
    public void test1() {
//        Bank b = new Bank();
//        Customer alice = new Customer("Alice");
//        Customer bob = new Customer("Bob");
//        Customer charlie = new Customer("Charlie");
//        Account ab = new Account(b, "32442545");
//        Account ac = new Account(b, "44543214");
        alice.setAccount(ab);
        bob.setAccount(ab);
        charlie.setAccount(ac);
        ab.deposit(20000);
        ac.deposit(10000);

    }

    @Test
    public void test2(){
        alice.transact(ab,1500);
        charlie.transact(ab,2000);
    }

}
