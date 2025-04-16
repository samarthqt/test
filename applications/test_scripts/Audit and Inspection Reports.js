describe('Audit and Inspection Reports Test Suite', () => {
  const loginPage = new LoginPage();
  const auditReportsPage = new AuditReportsPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log into the Trial Management system', () => {
    loginPage.enterCredentials('validUser', 'validPassword');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Audit Reports module', () => {
    auditReportsPage.navigateToAuditReports();
    auditReportsPage.verifyAuditReportsModuleDisplayed();
  });

  it('should generate an audit report', () => {
    auditReportsPage.selectGenerateAuditReport();
    auditReportsPage.enterAuditReportParameters('Compliance', '2023-11-01');
    auditReportsPage.initiateReportGeneration();
    auditReportsPage.verifyReportGenerationStatus('successful');
  });

  it('should access and review the generated audit report', () => {
    auditReportsPage.accessGeneratedReport();
    auditReportsPage.verifyReportDetails();
  });

  it('should simulate a data discrepancy and acknowledge it', () => {
    auditReportsPage.simulateDataDiscrepancy();
    auditReportsPage.acknowledgeDiscrepancy();
  });

  it('should generate an inspection report for the same data', () => {
    auditReportsPage.generateInspectionReport();
    auditReportsPage.verifyInspectionReportDiscrepancy();
  });

  it('should log out and verify reports are accessible upon re-login', () => {
    auditReportsPage.logout();
    loginPage.enterCredentials('validUser', 'validPassword');
    loginPage.submit();
    auditReportsPage.verifyReportsAccessible();
  });
});