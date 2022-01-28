/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 135 "model.ump"
// line 205 "model.ump"
public class BalanceInquiry extends Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BalanceInquiry Attributes
  private String accountID;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BalanceInquiry(Date aDate, Time aTime, String aTransactionID, int aAmount, ATM aATM, String aAccountID)
  {
    super(aDate, aTime, aTransactionID, aAmount, aATM);
    accountID = aAccountID;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountID(String aAccountID)
  {
    boolean wasSet = false;
    accountID = aAccountID;
    wasSet = true;
    return wasSet;
  }

  public String getAccountID()
  {
    return accountID;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountID" + ":" + getAccountID()+ "]";
  }
}