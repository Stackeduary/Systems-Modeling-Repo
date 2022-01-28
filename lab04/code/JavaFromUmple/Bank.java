/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 145 "model.ump"
public class Bank
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bank Attributes
  private String name;
  private String customerServicePhoneNumber;
  private String headquartersAddress;

  //Bank Associations
  private List<Client> clients;
  private List<Representative> representatives;
  private List<ATM> aTMs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bank(String aName, String aCustomerServicePhoneNumber, String aHeadquartersAddress)
  {
    name = aName;
    customerServicePhoneNumber = aCustomerServicePhoneNumber;
    headquartersAddress = aHeadquartersAddress;
    clients = new ArrayList<Client>();
    representatives = new ArrayList<Representative>();
    aTMs = new ArrayList<ATM>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCustomerServicePhoneNumber(String aCustomerServicePhoneNumber)
  {
    boolean wasSet = false;
    customerServicePhoneNumber = aCustomerServicePhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeadquartersAddress(String aHeadquartersAddress)
  {
    boolean wasSet = false;
    headquartersAddress = aHeadquartersAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getCustomerServicePhoneNumber()
  {
    return customerServicePhoneNumber;
  }

  public String getHeadquartersAddress()
  {
    return headquartersAddress;
  }
  /* Code from template association_GetMany */
  public Client getClient(int index)
  {
    Client aClient = clients.get(index);
    return aClient;
  }

  public List<Client> getClients()
  {
    List<Client> newClients = Collections.unmodifiableList(clients);
    return newClients;
  }

  public int numberOfClients()
  {
    int number = clients.size();
    return number;
  }

  public boolean hasClients()
  {
    boolean has = clients.size() > 0;
    return has;
  }

  public int indexOfClient(Client aClient)
  {
    int index = clients.indexOf(aClient);
    return index;
  }
  /* Code from template association_GetMany */
  public Representative getRepresentative(int index)
  {
    Representative aRepresentative = representatives.get(index);
    return aRepresentative;
  }

  public List<Representative> getRepresentatives()
  {
    List<Representative> newRepresentatives = Collections.unmodifiableList(representatives);
    return newRepresentatives;
  }

  public int numberOfRepresentatives()
  {
    int number = representatives.size();
    return number;
  }

  public boolean hasRepresentatives()
  {
    boolean has = representatives.size() > 0;
    return has;
  }

  public int indexOfRepresentative(Representative aRepresentative)
  {
    int index = representatives.indexOf(aRepresentative);
    return index;
  }
  /* Code from template association_GetMany */
  public ATM getATM(int index)
  {
    ATM aATM = aTMs.get(index);
    return aATM;
  }

  public List<ATM> getATMs()
  {
    List<ATM> newATMs = Collections.unmodifiableList(aTMs);
    return newATMs;
  }

  public int numberOfATMs()
  {
    int number = aTMs.size();
    return number;
  }

  public boolean hasATMs()
  {
    boolean has = aTMs.size() > 0;
    return has;
  }

  public int indexOfATM(ATM aATM)
  {
    int index = aTMs.indexOf(aATM);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfClients()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Client addClient(String aName, String aAccountNumber, String aTelephoneNumber, String aEmail, integer aPIN, integer aCardNumber)
  {
    return new Client(aName, aAccountNumber, aTelephoneNumber, aEmail, aPIN, aCardNumber, this);
  }

  public boolean addClient(Client aClient)
  {
    boolean wasAdded = false;
    if (clients.contains(aClient)) { return false; }
    Bank existingBank = aClient.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);
    if (isNewBank)
    {
      aClient.setBank(this);
    }
    else
    {
      clients.add(aClient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeClient(Client aClient)
  {
    boolean wasRemoved = false;
    //Unable to remove aClient, as it must always have a bank
    if (!this.equals(aClient.getBank()))
    {
      clients.remove(aClient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addClientAt(Client aClient, int index)
  {  
    boolean wasAdded = false;
    if(addClient(aClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClients()) { index = numberOfClients() - 1; }
      clients.remove(aClient);
      clients.add(index, aClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClientAt(Client aClient, int index)
  {
    boolean wasAdded = false;
    if(clients.contains(aClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClients()) { index = numberOfClients() - 1; }
      clients.remove(aClient);
      clients.add(index, aClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClientAt(aClient, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRepresentatives()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Representative addRepresentative(String aName, String aEmployeeID)
  {
    return new Representative(aName, aEmployeeID, this);
  }

  public boolean addRepresentative(Representative aRepresentative)
  {
    boolean wasAdded = false;
    if (representatives.contains(aRepresentative)) { return false; }
    Bank existingBank = aRepresentative.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);
    if (isNewBank)
    {
      aRepresentative.setBank(this);
    }
    else
    {
      representatives.add(aRepresentative);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRepresentative(Representative aRepresentative)
  {
    boolean wasRemoved = false;
    //Unable to remove aRepresentative, as it must always have a bank
    if (!this.equals(aRepresentative.getBank()))
    {
      representatives.remove(aRepresentative);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRepresentativeAt(Representative aRepresentative, int index)
  {  
    boolean wasAdded = false;
    if(addRepresentative(aRepresentative))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRepresentatives()) { index = numberOfRepresentatives() - 1; }
      representatives.remove(aRepresentative);
      representatives.add(index, aRepresentative);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRepresentativeAt(Representative aRepresentative, int index)
  {
    boolean wasAdded = false;
    if(representatives.contains(aRepresentative))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRepresentatives()) { index = numberOfRepresentatives() - 1; }
      representatives.remove(aRepresentative);
      representatives.add(index, aRepresentative);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRepresentativeAt(aRepresentative, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfATMs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ATM addATM(String aLocationAddress, integer aCurrentCashAmount)
  {
    return new ATM(aLocationAddress, aCurrentCashAmount, this);
  }

  public boolean addATM(ATM aATM)
  {
    boolean wasAdded = false;
    if (aTMs.contains(aATM)) { return false; }
    Bank existingBank = aATM.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);
    if (isNewBank)
    {
      aATM.setBank(this);
    }
    else
    {
      aTMs.add(aATM);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeATM(ATM aATM)
  {
    boolean wasRemoved = false;
    //Unable to remove aATM, as it must always have a bank
    if (!this.equals(aATM.getBank()))
    {
      aTMs.remove(aATM);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addATMAt(ATM aATM, int index)
  {  
    boolean wasAdded = false;
    if(addATM(aATM))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfATMs()) { index = numberOfATMs() - 1; }
      aTMs.remove(aATM);
      aTMs.add(index, aATM);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveATMAt(ATM aATM, int index)
  {
    boolean wasAdded = false;
    if(aTMs.contains(aATM))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfATMs()) { index = numberOfATMs() - 1; }
      aTMs.remove(aATM);
      aTMs.add(index, aATM);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addATMAt(aATM, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=clients.size(); i > 0; i--)
    {
      Client aClient = clients.get(i - 1);
      aClient.delete();
    }
    for(int i=representatives.size(); i > 0; i--)
    {
      Representative aRepresentative = representatives.get(i - 1);
      aRepresentative.delete();
    }
    for(int i=aTMs.size(); i > 0; i--)
    {
      ATM aATM = aTMs.get(i - 1);
      aATM.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "customerServicePhoneNumber" + ":" + getCustomerServicePhoneNumber()+ "," +
            "headquartersAddress" + ":" + getHeadquartersAddress()+ "]";
  }
}