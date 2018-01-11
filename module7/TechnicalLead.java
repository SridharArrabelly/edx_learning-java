import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
  // Class State
  private int headCount;
  private Accountant actSupporting;
  private ArrayList<SoftwareEngineer> directReports = new ArrayList<SoftwareEngineer>();


  // Class Constructors
  public TechnicalLead(String name) {
    super(name);
    this.headCount = 4;
    this.baseSalary *= 1.3;
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


  public boolean addReport(SoftwareEngineer employee) {
    if (this.directReports.contains(employee)) {
      System.out.println("Employee is already a report.");
      return false;
    }
    if (this.hasHeadCount()) {
      this.directReports.add(employee);
      this.headCount -= 1;
      employee.manager = this;
      return true;
    }
    return false;
  }


  public void grantCodeAccess(SoftwareEngineer employee) {
    if (this.equals(employee.getManager())) {
      employee.setCodeAccess(true);
    }
  }


  public String getTeamStatus() {
    String teamStatus = this.employeeStatus();
    if (this.directReports.size() == 0) {
      teamStatus += " and no direct reports yet.";
      return teamStatus;
    }
    teamStatus += " and is managing:\n";
    for (SoftwareEngineer employee : directReports) {
      teamStatus += "  " + employee.employeeStatus() + "\n";
    }
    return teamStatus;
  }


  public boolean approveCheckIn(SoftwareEngineer employee) {
    if (this.equals(employee.getManager()) && employee.getCodeAccess()) {
      return true;
    }
    return false;
  }


  public void setActSupport(Accountant accountant) {
    this.actSupporting = accountant;
  }


  public String getActSupporting() {
    if (this.actSupporting != null) {
      return "Accountant supporting: " + this.actSupporting.getEmployeeID()
              + " " + this.actSupporting.getName();
    }
    else {
      return "Not supported by accountant yet.";
    }
  }


  public boolean requestBonus(Accountant accountant, double bonus) {
    if (accountant.getTeamSupported().equals(this)) {
      accountant.approveBonus(bonus);
      return true;
    }
    return false;
  }

  public boolean requestBonusBL(BusinessLead businessLead, double bonus) {
    businessLead.approveBonusRequest(this, bonus);
    return true;
  }

}
