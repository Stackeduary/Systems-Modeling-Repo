/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 103 "model.ump"
// line 180 "model.ump"
public class CheckingAccount extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CheckingAccount Attributes
  private float remainingWithdrawalLimit;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CheckingAccount(String aOwnerName, String aAccountNumber, float aBalance, Client aClient, float aRemainingWithdrawalLimit)
  {
    super(aOwnerName, aAccountNumber, aBalance, aClient);
    remainingWithdrawalLimit = aRemainingWithdrawalLimit;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRemainingWithdrawalLimit(float aRemainingWithdrawalLimit)
  {
    boolean wasSet = false;
    remainingWithdrawalLimit = aRemainingWithdrawalLimit;
    wasSet = true;
    return wasSet;
  }

  public float getRemainingWithdrawalLimit()
  {
    return remainingWithdrawalLimit;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "remainingWithdrawalLimit" + ":" + getRemainingWithdrawalLimit()+ "]";
  }
}