/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 52 "model.ump"
// line 164 "model.ump"
public class Representative
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Representative Attributes
  private String name;
  private String employeeID;

  //Representative Associations
  private Bank bank;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Representative(String aName, String aEmployeeID, Bank aBank)
  {
    name = aName;
    employeeID = aEmployeeID;
    boolean didAddBank = setBank(aBank);
    if (!didAddBank)
    {
      throw new RuntimeException("Unable to create representative due to bank. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public boolean setEmployeeID(String aEmployeeID)
  {
    boolean wasSet = false;
    employeeID = aEmployeeID;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getEmployeeID()
  {
    return employeeID;
  }
  /* Code from template association_GetOne */
  public Bank getBank()
  {
    return bank;
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
      existingBank.removeRepresentative(this);
    }
    bank.addRepresentative(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Bank placeholderBank = bank;
    this.bank = null;
    if(placeholderBank != null)
    {
      placeholderBank.removeRepresentative(this);
    }
  }

  // line 59 "model.ump"
   public void closeAccount(){
    
  }

  // line 62 "model.ump"
   public void blockCard(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "employeeID" + ":" + getEmployeeID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bank = "+(getBank()!=null?Integer.toHexString(System.identityHashCode(getBank())):"null");
  }
}