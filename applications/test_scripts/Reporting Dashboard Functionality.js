describe('Reporting Dashboard Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const reportingPage = new ReportingPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the system', () => {
    loginPage.login('12345', 'password');
    dashboardPage.verifyHomePage();
  });

  it('should navigate to the Reporting module', () => {
    dashboardPage.goToReportingModule();
    reportingPage.verifyReportingDashboard();
  });

  it('should select Progress Report from the report options', () => {
    reportingPage.selectProgressReport();
    reportingPage.verifyProgressReportDisplayed();
  });

  it('should apply filters for date range and status', () => {
    reportingPage.applyFilters('2023-01-01', '2023-12-31', 'Completed');
    reportingPage.verifyFiltersApplied();
  });

  it('should generate the report', () => {
    reportingPage.generateReport();
    reportingPage.verifyReportGenerated();
  });

  it('should check report metrics and data visualization', () => {
    reportingPage.verifyMetricsAndVisualization();
  });

  it('should export the report to PDF', () => {
    reportingPage.exportReportToPDF();
    reportingPage.verifyReportExported();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});