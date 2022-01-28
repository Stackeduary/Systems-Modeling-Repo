/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 71 "model.ump"
// line 169 "model.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private Date date;
  private Time time;
  private String transactionID;
  private int amount;

  //Transaction Associations
  private ATM aTM;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(Date aDate, Time aTime, String aTransactionID, int aAmount, ATM aATM)
  {
    date = aDate;
    time = aTime;
    transactionID = aTransactionID;
    amount = aAmount;
    boolean didAddATM = setATM(aATM);
    if (!didAddATM)
    {
      throw new RuntimeException("Unable to create transaction due to aTM. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setTransactionID(String aTransactionID)
  {
    boolean wasSet = false;
    transactionID = aTransactionID;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmount(int aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getTime()
  {
    return time;
  }

  public String getTransactionID()
  {
    return transactionID;
  }

  public int getAmount()
  {
    return amount;
  }
  /* Code from template association_GetOne */
  public ATM getATM()
  {
    return aTM;
  }
  /* Code from template association_SetOneToMany */
  public boolean setATM(ATM aATM)
  {
    boolean wasSet = false;
    if (aATM == null)
    {
      return wasSet;
    }

    ATM existingATM = aTM;
    aTM = aATM;
    if (existingATM != null && !existingATM.equals(aATM))
    {
      existingATM.removeTransaction(this);
    }
    aTM.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ATM placeholderATM = aTM;
    this.aTM = null;
    if(placeholderATM != null)
    {
      placeholderATM.removeTransaction(this);
    }
  }

  // line 79 "model.ump"
   public void requestAccountClosure(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "transactionID" + ":" + getTransactionID()+ "," +
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "aTM = "+(getATM()!=null?Integer.toHexString(System.identityHashCode(getATM())):"null");
  }
}