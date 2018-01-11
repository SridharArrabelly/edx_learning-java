public class SoftwareEngineer extends TechnicalEmployee {
  // Class State
  private boolean codeAccess;


  // Class Constructors
  public SoftwareEngineer(String name) {
    super(name);
    this.codeAccess = false;
  }


  // Class Behavior
  public boolean getCodeAccess() {
    return this.codeAccess;
  }


  public void setCodeAccess(boolean access) {
    this.codeAccess = access;
  }


  public boolean checkInCode(TechnicalLead techLead) {
    if (techLead.approveCheckIn(this)) {
      this.increaseCheckIns();
      return true;
    }
    else {
      this.setCodeAccess(false);
    }
    return false;
  }

}
