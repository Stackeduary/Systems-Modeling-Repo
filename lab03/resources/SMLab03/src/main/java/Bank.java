import java.util.ArrayList;
import java.util.List;

public class Bank {
    String bankId;
    String name;
    String location;
    List<Customer> customerList;

    public Bank() {
        customerList=new ArrayList<Customer>();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
