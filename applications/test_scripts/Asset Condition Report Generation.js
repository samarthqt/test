describe('Asset Condition Report Generation', () => {
  const loginPage = new LoginPage();
  const reportingPage = new ReportingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in and generate asset condition report', () => {
    loginPage.login('validUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.selectConditionReports();
    reportingPage.enterAssetID('A123');
    reportingPage.generateReport();
    reportingPage.verifyReportContent('A123', 'Good', '2023-11-15');
    reportingPage.verifyMaintenanceRecommendations();
    reportingPage.exportReportToPDF();
    reportingPage.verifyPDFContent('A123', 'Good', '2023-11-15');
  });

  it('should prompt for missing asset ID', () => {
    loginPage.login('validUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.selectConditionReports();
    reportingPage.generateReportWithoutAssetID();
    reportingPage.verifyMissingAssetIDPrompt();
  });

  it('should show error for invalid asset ID', () => {
    loginPage.login('validUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.selectConditionReports();
    reportingPage.enterAssetID('invalidID');
    reportingPage.generateReport();
    reportingPage.verifyInvalidAssetIDError();
  });

  it('should verify report generation time', () => {
    loginPage.login('validUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.selectConditionReports();
    reportingPage.enterAssetID('A123');
    reportingPage.measureReportGenerationTime();
  });

  it('should restrict report access for unauthorized users', () => {
    loginPage.login('unauthorizedUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.verifyAccessRestriction();
  });

  it('should schedule an automatic report generation', () => {
    loginPage.login('validUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.scheduleAutomaticReport('2023-12-01');
    reportingPage.verifyScheduledTask();
  });

  it('should verify notification settings for report completion', () => {
    loginPage.login('validUser', 'validPassword');
    reportingPage.navigateToReportingModule();
    reportingPage.selectConditionReports();
    reportingPage.enterAssetID('A123');
    reportingPage.generateReport();
    reportingPage.verifyNotificationUponCompletion();
  });
});