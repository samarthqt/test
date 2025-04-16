describe('Trip Tracking - Summary Report Verification', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const analyticsPage = new AnalyticsPage();
  const tripLogsPage = new TripLogsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the application', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Analytics module', () => {
    dashboardPage.goToAnalyticsModule();
    analyticsPage.verifyAnalyticsInterface();
  });

  it('should select the Trip Logs sub-module', () => {
    analyticsPage.selectTripLogsSubModule();
    tripLogsPage.verifyTripLogsInterface();
  });

  it('should enter User ID and Trip ID', () => {
    tripLogsPage.enterUserID('12345');
    tripLogsPage.enterTripID('67890');
  });

  it('should select the date range for the report', () => {
    tripLogsPage.selectDateRange('Last Month');
  });

  it('should generate the report', () => {
    tripLogsPage.clickGenerateReport();
    tripLogsPage.verifyReportGenerated();
  });

  it('should verify the report displays trip details', () => {
    tripLogsPage.verifyTripDetails();
  });

  it('should check the export options', () => {
    tripLogsPage.verifyExportOptions();
  });

  it('should export the report as PDF', () => {
    tripLogsPage.exportReportAsPDF();
    tripLogsPage.verifyPDFExported();
  });

  it('should open the exported PDF and verify content', () => {
    tripLogsPage.openAndVerifyPDFContent();
  });

  it('should navigate back to the Trip Logs interface', () => {
    tripLogsPage.navigateBackToTripLogs();
    tripLogsPage.verifyTripLogsInterface();
  });

  it('should log out of the application', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});