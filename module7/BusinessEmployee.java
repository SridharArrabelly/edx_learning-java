
public abstract class BusinessEmployee extends Employee {
  // Class State
  double bonusBudget;

  // Class Constructors
  public BusinessEmployee(String name) {
    super(name, 50000);
  }

  // Class Behavior
  public double getBudget() {
    return this.bonusBudget;
  }

  public String employeeStatus() {
    return this.toString() + " with a budget of " + this.getBudget();
  }
}
