describe('Depreciation Report Generation', () => {
  const loginPage = new LoginPage();
  const reportingPage = new ReportingPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 portal', () => {
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/home');
  });

  it('should navigate to the Reporting module', () => {
    reportingPage.navigateToReportingModule();
    cy.url().should('include', '/reporting');
  });

  it('should select Depreciation Reports', () => {
    reportingPage.selectDepreciationReports();
  });

  it('should enter asset ID and select depreciation method', () => {
    reportingPage.enterAssetID('D456');
    reportingPage.selectDepreciationMethod('Straight-Line');
  });

  it('should generate the report and verify its accuracy', () => {
    reportingPage.generateReport();
    reportingPage.verifyReportContent('2020-01-01', '$10,000');
  });

  it('should export the report to Excel and verify', () => {
    reportingPage.exportReportToExcel();
    reportingPage.verifyExcelContent();
  });

  it('should prompt for missing depreciation method', () => {
    reportingPage.clearDepreciationMethod();
    reportingPage.generateReport();
    reportingPage.verifyMissingMethodPrompt();
  });

  it('should display error for invalid asset ID', () => {
    reportingPage.enterAssetID('InvalidID');
    reportingPage.generateReport();
    reportingPage.verifyInvalidIDError();
  });

  it('should check system response time for report generation', () => {
    reportingPage.checkResponseTime();
  });

  it('should verify report access permissions', () => {
    reportingPage.verifyAccessPermissions();
  });

  it('should schedule report generation for future date', () => {
    reportingPage.scheduleReport('2023-12-31');
    reportingPage.verifyScheduledTask();
  });
});