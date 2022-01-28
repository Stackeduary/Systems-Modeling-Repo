/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 109 "model.ump"
// line 185 "model.ump"
public class SavingsAccount extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SavingsAccount Attributes
  private float dailyInterestRate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SavingsAccount(String aOwnerName, String aAccountNumber, float aBalance, Client aClient, float aDailyInterestRate)
  {
    super(aOwnerName, aAccountNumber, aBalance, aClient);
    dailyInterestRate = aDailyInterestRate;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDailyInterestRate(float aDailyInterestRate)
  {
    boolean wasSet = false;
    dailyInterestRate = aDailyInterestRate;
    wasSet = true;
    return wasSet;
  }

  public float getDailyInterestRate()
  {
    return dailyInterestRate;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "dailyInterestRate" + ":" + getDailyInterestRate()+ "]";
  }
}