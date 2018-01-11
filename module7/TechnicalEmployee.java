public abstract class TechnicalEmployee extends Employee {
  // Class State (adds 1 field to Employee class)
  private int checkIns;


  // Class Constructors (has 1 constructor with default baseSalary field)
  public TechnicalEmployee(String name) {
    super(name, 75000);
    this.checkIns = 0;
  }


  // Class Behavior (adds 1 method and gives body to employeeStatus method)
  public int getSuccessfulCheckIns() {
    return this.checkIns;
  }


  public void increaseCheckIns() {
    this.checkIns += 1;
  }


  public String employeeStatus() {
    return this.toString() + " has " + this.getSuccessfulCheckIns()
           + " successful check ins";
  }
}
