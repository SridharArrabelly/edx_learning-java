public class Accountant extends BusinessEmployee {
  // Class State
  private TechnicalLead techLeadSupported;


  // Class Constructors
  public Accountant(String name) {
    super(name);
  }

  // Class Behavior
  public TechnicalLead getTeamSupported() {
    return this.techLeadSupported;
  }


  private void createBudget() {
    if (this.getTeamSupported() != null) {
      int reportCount = this.getTeamSupported().getReportCount();
      double techBaseSalary = this.getTeamSupported().getBaseSalary() / 1.3;
      this.bonusBudget = reportCount * techBaseSalary * 1.1;
    }
  }


  public boolean supportTeam(TechnicalLead techLead) {
    if (this.getTeamSupported() != null && this.getTeamSupported().equals(techLead)) {
      System.out.println("Accountant already supporting this team.");
      return false;
    }
    this.techLeadSupported = techLead;
    this.createBudget();
    techLead.setActSupport(this);
    return true;
  }


  public boolean approveBonus(double bonus) {
    if (bonus <= this.bonusBudget) {
      this.bonusBudget -= bonus;
      return true;
    }
    else {
      System.out.println("Requested bonus exceed maximum allowed.");
      return false;
    }
  }


  public String employeeStatus() {
    if (this.getTeamSupported() != null) {
      return this.toString() + " with a budget of " + this.getBudget() + " is supporting "
              + this.getTeamSupported().getName();
    }
    else {
      return this.toString() + " with a budget of " + this.getBudget()
              + " and is not supporting any TechnicalLead yet.";
    }
  }

}
