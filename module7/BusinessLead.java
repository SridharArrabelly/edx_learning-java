import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
  // Class State
  private int headCount;
  private ArrayList<Accountant> directReports = new ArrayList<Accountant>();


  // Class Constructors
  public BusinessLead(String name) {
    super(name);
    this.headCount = 10;
    this.baseSalary *= 2;
  }


  // Class Behavior
  public boolean hasHeadCount() {
    if (this.headCount > 0) {
      return true;
    }
    return false;
  }


  public int getReportCount() {
    return this.directReports.size();
  }


  public boolean addReport(Accountant employee, TechnicalLead team) {
    if (this.directReports.contains(employee)) {
      System.out.println("Employee is already a report.");
      return false;
    }
    if (this.hasHeadCount()) {
      this.directReports.add(employee);
      this.headCount -= 1;
      this.bonusBudget += employee.getBaseSalary() * 1.1;
      employee.manager = this;
      employee.supportTeam(team);
      return true;
    }
    return false;
  }


  public String getTeamStatus() {
    String teamStatus = this.employeeStatus();
    if (this.directReports.size() == 0) {
      teamStatus += " and no direct reports yet.";
      return teamStatus;
    }
    teamStatus += " and is managing:\n";
    for (Accountant employee : directReports) {
      teamStatus += "  " + employee.employeeStatus() + "\n";
    }
    return teamStatus;
  }
}
