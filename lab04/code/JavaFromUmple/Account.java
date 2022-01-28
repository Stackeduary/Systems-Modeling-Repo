/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 85 "model.ump"
// line 174 "model.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String ownerName;
  private String accountNumber;
  private float balance;

  //Account Associations
  private Client client;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aOwnerName, String aAccountNumber, float aBalance, Client aClient)
  {
    ownerName = aOwnerName;
    accountNumber = aAccountNumber;
    balance = aBalance;
    boolean didAddClient = setClient(aClient);
    if (!didAddClient)
    {
      throw new RuntimeException("Unable to create account due to client. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOwnerName(String aOwnerName)
  {
    boolean wasSet = false;
    ownerName = aOwnerName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccountNumber(String aAccountNumber)
  {
    boolean wasSet = false;
    accountNumber = aAccountNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setBalance(float aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public String getOwnerName()
  {
    return ownerName;
  }

  public String getAccountNumber()
  {
    return accountNumber;
  }

  public float getBalance()
  {
    return balance;
  }
  /* Code from template association_GetOne */
  public Client getClient()
  {
    return client;
  }
  /* Code from template association_SetOneToMany */
  public boolean setClient(Client aClient)
  {
    boolean wasSet = false;
    if (aClient == null)
    {
      return wasSet;
    }

    Client existingClient = client;
    client = aClient;
    if (existingClient != null && !existingClient.equals(aClient))
    {
      existingClient.removeAccount(this);
    }
    client.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Client placeholderClient = client;
    this.client = null;
    if(placeholderClient != null)
    {
      placeholderClient.removeAccount(this);
    }
  }

  // line 93 "model.ump"
   public void deposit(){
    
  }

  // line 96 "model.ump"
   public void withdraw(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "ownerName" + ":" + getOwnerName()+ "," +
            "accountNumber" + ":" + getAccountNumber()+ "," +
            "balance" + ":" + getBalance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null");
  }
}
