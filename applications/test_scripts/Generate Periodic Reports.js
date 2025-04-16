describe('TC-631 498 Generate Periodic Reports', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const reportingPage = new ReportingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in, generate a report, and verify it', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToReportingModule();

    reportingPage.selectPeriodicReports();
    reportingPage.clickGenerateNewReport();
    reportingPage.selectReportType('Trial Progress');
    reportingPage.enterDateRange('2023-01-01', '2023-10-31');
    reportingPage.selectOutputFormat('PDF');
    reportingPage.clickGenerate();
    reportingPage.verifyReportGenerationNotification();
    reportingPage.downloadReport();

    reportingPage.openAndVerifyReportContents();
    reportingPage.checkReportAccuracy();

    dashboardPage.logout();
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToReportingModule();
    reportingPage.verifyReportRecordPersistence();
  });
});