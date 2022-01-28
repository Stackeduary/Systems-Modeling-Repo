/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 11 "model.ump"
// line 152 "model.ump"
public class Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private String name;
  private String accountNumber;
  private String telephoneNumber;
  private String email;
  private integer PIN;
  private integer cardNumber;

  //Client Associations
  private Bank bank;
  private List<Account> accounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(String aName, String aAccountNumber, String aTelephoneNumber, String aEmail, integer aPIN, integer aCardNumber, Bank aBank)
  {
    name = aName;
    accountNumber = aAccountNumber;
    telephoneNumber = aTelephoneNumber;
    email = aEmail;
    PIN = aPIN;
    cardNumber = aCardNumber;
    boolean didAddBank = setBank(aBank);
    if (!didAddBank)
    {
      throw new RuntimeException("Unable to create client due to bank. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    accounts = new ArrayList<Account>();
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

  public boolean setAccountNumber(String aAccountNumber)
  {
    boolean wasSet = false;
    accountNumber = aAccountNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelephoneNumber(String aTelephoneNumber)
  {
    boolean wasSet = false;
    telephoneNumber = aTelephoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPIN(integer aPIN)
  {
    boolean wasSet = false;
    PIN = aPIN;
    wasSet = true;
    return wasSet;
  }

  public boolean setCardNumber(integer aCardNumber)
  {
    boolean wasSet = false;
    cardNumber = aCardNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAccountNumber()
  {
    return accountNumber;
  }

  public String getTelephoneNumber()
  {
    return telephoneNumber;
  }

  public String getEmail()
  {
    return email;
  }

  public integer getPIN()
  {
    return PIN;
  }

  public integer getCardNumber()
  {
    return cardNumber;
  }
  /* Code from template association_GetOne */
  public Bank getBank()
  {
    return bank;
  }
  /* Code from template association_GetMany */
  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBank(Bank aBank)
  {
    boolean wasSet = false;
    if (aBank == null)
    {
      return wasSet;
    }

    Bank existingBank = bank;
    bank = aBank;
    if (existingBank != null && !existingBank.equals(aBank))
    {
      existingBank.removeClient(this);
    }
    bank.addClient(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Account addAccount(String aOwnerName, String aAccountNumber, float aBalance)
  {
    return new Account(aOwnerName, aAccountNumber, aBalance, this);
  }

  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    Client existingClient = aAccount.getClient();
    boolean isNewClient = existingClient != null && !this.equals(existingClient);
    if (isNewClient)
    {
      aAccount.setClient(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a client
    if (!this.equals(aAccount.getClient()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Bank placeholderBank = bank;
    this.bank = null;
    if(placeholderBank != null)
    {
      placeholderBank.removeClient(this);
    }
    for(int i=accounts.size(); i > 0; i--)
    {
      Account aAccount = accounts.get(i - 1);
      aAccount.delete();
    }
  }

  // line 22 "model.ump"
   public void requestAccountClosure(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "accountNumber" + ":" + getAccountNumber()+ "," +
            "telephoneNumber" + ":" + getTelephoneNumber()+ "," +
            "email" + ":" + getEmail()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "PIN" + "=" + (getPIN() != null ? !getPIN().equals(this)  ? getPIN().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cardNumber" + "=" + (getCardNumber() != null ? !getCardNumber().equals(this)  ? getCardNumber().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bank = "+(getBank()!=null?Integer.toHexString(System.identityHashCode(getBank())):"null");
  }
}