/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 121 "model.ump"
// line 195 "model.ump"
public class Deposit extends Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Deposit Attributes
  private String madeBy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Deposit(Date aDate, Time aTime, String aTransactionID, int aAmount, ATM aATM, String aMadeBy)
  {
    super(aDate, aTime, aTransactionID, aAmount, aATM);
    madeBy = aMadeBy;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMadeBy(String aMadeBy)
  {
    boolean wasSet = false;
    madeBy = aMadeBy;
    wasSet = true;
    return wasSet;
  }

  public String getMadeBy()
  {
    return madeBy;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "madeBy" + ":" + getMadeBy()+ "]";
  }
}