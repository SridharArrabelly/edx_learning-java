class CompanyStructure {
  public static void main(String[] args) {
    /*** Technical Employees Test ***/
    System.out.println("Creating fisrt software engineers and CTO, Kasey, Breana and Satya Nadella");
    TechnicalLead CTO = new TechnicalLead("Satya Nadella");
    SoftwareEngineer seA = new SoftwareEngineer("Kasey");
    SoftwareEngineer seB = new SoftwareEngineer("Breana");
    CTO.addReport(seA);
    CTO.addReport(seB);
    System.out.println(CTO.getTeamStatus());

    System.out.println("Creating more technical staff.");
    TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
    SoftwareEngineer seD = new SoftwareEngineer("Winter");
    VPofENG.addReport(seD);
    System.out.println(VPofENG.getTeamStatus());

    System.out.println("Satya gives codeAccess to Kasey.");
    CTO.grantCodeAccess(seA);
    System.out.println("Kasey Checks In her first piece of code. ");
    seA.checkInCode(CTO);
    System.out.println(CTO.getTeamStatus());

    System.out.println("Kasey tries to check in code with Bill Gates and loose her codeAccess...");
    seA.checkInCode(VPofENG);
    System.out.println("Kasey codeAccess = " + seA.getCodeAccess() + "\n");

    System.out.println(CTO.getTeamStatus());
    System.out.println("----------------------------------------------\n");

    /*** Business Employees Test ***/
    System.out.println("Creating fisrt accountants and CFO, Niky, Andrew and Amy Hood");
    BusinessLead CFO = new BusinessLead("Amy Hood");
    Accountant actA = new Accountant("Niky");
    Accountant actB = new Accountant("Andrew");

    CFO.addReport(actA, CTO);
    CFO.addReport(actB, VPofENG);

    System.out.println(CFO.getTeamStatus());

    System.out.println("\nSatya request 5000 of bonus.");
    CTO.requestBonusBL(CFO, 5000);
    System.out.println(CFO.getTeamStatus());

    System.out.println("\nBill request 83000 of bonus.");
    VPofENG.requestBonusBL(CFO, 83000);
    System.out.println(CFO.getTeamStatus());
  }
}
