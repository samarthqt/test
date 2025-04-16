describe('Advanced Reporting Test Suite', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const reportingPage = new ReportingPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.login('validUser', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should generate and verify inventory trends report', () => {
    dashboardPage.navigateToReportingModule();
    reportingPage.selectAdvancedReporting();
    reportingPage.chooseReportType('Inventory Trends');
    reportingPage.selectDateRange('01/01/2023', '01/31/2023');
    reportingPage.generateReport();
    reportingPage.verifyReportData('Inventory Trends');
  });

  it('should generate and verify order volume report', () => {
    dashboardPage.navigateToReportingModule();
    reportingPage.selectAdvancedReporting();
    reportingPage.chooseReportType('Order Volume');
    reportingPage.selectProductCategoryFilter('Electronics');
    reportingPage.generateReport();
    reportingPage.verifyReportData('Order Volume');
  });

  it('should generate and verify supplier performance report', () => {
    dashboardPage.navigateToReportingModule();
    reportingPage.selectAdvancedReporting();
    reportingPage.chooseReportType('Supplier Performance');
    reportingPage.selectSupplierAndMetrics('Supplier A', 'Delivery Time');
    reportingPage.generateReport();
    reportingPage.verifyReportData('Supplier Performance');
  });
});