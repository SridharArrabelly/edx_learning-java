public abstract class Employee {
  // Class State
  private String name;
  private static int idCounter = 0;
  private int employeeID;

  public double baseSalary;
  public Employee manager;


  // Class Constructors
  public Employee(String name, double baseSalary) {
    this.name = name;
    this.baseSalary = baseSalary;
    this.employeeID = this.idCounter + 1;
    this.idCounter += 1;
  }


  // Class Behavior
  public String getName() {
    return this.name;
  }


  public double getBaseSalary() {
    return this.baseSalary;
  }


  public int getEmployeeID() {
    return this.employeeID;
  }


  public Employee getManager() {
    return this.manager;
  }


  public boolean equals(Employee other) {
    if (this.getEmployeeID() == other.getEmployeeID()) {
      return true;
    }
    else {
      return false;
    }
  }


  public String toString() {
    return this.employeeID + " " + this.name;
  }


  public abstract String employeeStatus();
}
