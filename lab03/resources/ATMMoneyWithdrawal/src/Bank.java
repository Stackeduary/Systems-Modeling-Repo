
import java.util.ArrayList;

public class Bank {
    String name;
    String customerCarePhoneNumber;
    String headQuartersAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ArrayList<ATM> atms;
    ArrayList<Client> clients;
    ArrayList<Representative> reps;

    public String getCustomerCarePhoneNumber() {
        return customerCarePhoneNumber;
    }

    public void setCustomerCarePhoneNumber(String customerCarePhoneNumber) {
        this.customerCarePhoneNumber = customerCarePhoneNumber;
    }

    public String getHeadQuartersAddress() {
        return headQuartersAddress;
    }

    public void setHeadQuartersAddress(String headQuartersAddress) {
        this.headQuartersAddress = headQuartersAddress;
    }

    public ArrayList<ATM> getAtms() {
        return atms;
    }

    public void setAtms(ArrayList<ATM> atms) {
        this.atms = atms;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Representative> getReps() {
        return reps;
    }

    public void setReps(ArrayList<Representative> reps) {
        this.reps = reps;
    }
}
