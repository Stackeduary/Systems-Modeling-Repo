/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 127 "model.ump"
// line 200 "model.ump"
public class BalanceTransfer extends Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BalanceTransfer Attributes
  private String madeBy;
  private String from;
  private String to;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BalanceTransfer(Date aDate, Time aTime, String aTransactionID, int aAmount, ATM aATM, String aMadeBy, String aFrom, String aTo)
  {
    super(aDate, aTime, aTransactionID, aAmount, aATM);
    madeBy = aMadeBy;
    from = aFrom;
    to = aTo;
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

  public boolean setFrom(String aFrom)
  {
    boolean wasSet = false;
    from = aFrom;
    wasSet = true;
    return wasSet;
  }

  public boolean setTo(String aTo)
  {
    boolean wasSet = false;
    to = aTo;
    wasSet = true;
    return wasSet;
  }

  public String getMadeBy()
  {
    return madeBy;
  }

  public String getFrom()
  {
    return from;
  }

  public String getTo()
  {
    return to;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "madeBy" + ":" + getMadeBy()+ "," +
            "from" + ":" + getFrom()+ "," +
            "to" + ":" + getTo()+ "]";
  }
}