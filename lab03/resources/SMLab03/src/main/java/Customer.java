import org.fulib.classmodel.ClassModel;

public class Customer  {
    int customerID;
    String cutomerName;
    String dateOfBirth;
    String address;
    Account customerAccount;

    public Customer(String cName) {
        this.cutomerName=cName;

    }

    public void setAccount(Account ab) {
        this.customerAccount=ab;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public void setCutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(Account customerAccount) {
        this.customerAccount = customerAccount;
    }

    public void transact(Account ab, int amount) {
    }
}
