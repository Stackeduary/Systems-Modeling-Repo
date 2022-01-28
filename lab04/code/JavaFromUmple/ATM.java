/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 25 "model.ump"
// line 157 "model.ump"
public class ATM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ATM Attributes
  private String locationAddress;
  private integer currentCashAmount;

  //ATM Associations
  private List<Transaction> transactions;
  private Bank bank;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ATM(String aLocationAddress, integer aCurrentCashAmount, Bank aBank)
  {
    locationAddress = aLocationAddress;
    currentCashAmount = aCurrentCashAmount;
    transactions = new ArrayList<Transaction>();
    boolean didAddBank = setBank(aBank);
    if (!didAddBank)
    {
      throw new RuntimeException("Unable to create aTM due to bank. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocationAddress(String aLocationAddress)
  {
    boolean wasSet = false;
    locationAddress = aLocationAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentCashAmount(integer aCurrentCashAmount)
  {
    boolean wasSet = false;
    currentCashAmount = aCurrentCashAmount;
    wasSet = true;
    return wasSet;
  }

  public String getLocationAddress()
  {
    return locationAddress;
  }

  public integer getCurrentCashAmount()
  {
    return currentCashAmount;
  }
  /* Code from template association_GetMany */
  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }
  /* Code from template association_GetOne */
  public Bank getBank()
  {
    return bank;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(Date aDate, Time aTime, String aTransactionID, int aAmount)
  {
    return new Transaction(aDate, aTime, aTransactionID, aAmount, this);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    ATM existingATM = aTransaction.getATM();
    boolean isNewATM = existingATM != null && !this.equals(existingATM);
    if (isNewATM)
    {
      aTransaction.setATM(this);
    }
    else
    {
      transactions.add(aTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransaction, as it must always have a aTM
    if (!this.equals(aTransaction.getATM()))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
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
      existingBank.removeATM(this);
    }
    bank.addATM(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    Bank placeholderBank = bank;
    this.bank = null;
    if(placeholderBank != null)
    {
      placeholderBank.removeATM(this);
    }
  }

  // line 32 "model.ump"
   public void validatePIN(){
    
  }

  // line 35 "model.ump"
   public void createTransaction(){
    
  }

  // line 41 "model.ump"
   public void swallowCard(){
    
  }

  // line 44 "model.ump"
   public void printReceipt(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "locationAddress" + ":" + getLocationAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "currentCashAmount" + "=" + (getCurrentCashAmount() != null ? !getCurrentCashAmount().equals(this)  ? getCurrentCashAmount().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bank = "+(getBank()!=null?Integer.toHexString(System.identityHashCode(getBank())):"null");
  }
}
