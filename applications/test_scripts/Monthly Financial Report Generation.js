describe('Monthly Financial Report Generation', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const financialToolsPage = new FinancialToolsPage();
  const reportPage = new ReportPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUsername('user12345');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Financial Tools module', () => {
    dashboardPage.goToFinancialTools();
    financialToolsPage.verifyFinancialToolsSection();
  });

  it('should select Reports from sub-module options', () => {
    financialToolsPage.selectReports();
    reportPage.verifyReportOptions();
  });

  it('should choose Monthly Financial Report', () => {
    reportPage.selectMonthlyFinancialReport();
    reportPage.verifyReportParametersPrompt();
  });

  it('should enter report parameters and generate report', () => {
    reportPage.enterReportMonth('September 2023');
    reportPage.enterIncomeData('5000');
    reportPage.enterExpensesData('3000');
    reportPage.verifyAccountBalance('2000');
    reportPage.generateReport();
    reportPage.verifyGeneratedReport();
  });

  it('should download the report as PDF and verify', () => {
    reportPage.downloadReportAsPDF();
    reportPage.verifyDownloadedReport();
  });

  it('should log out and attempt unauthorized access', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
    reportPage.attemptAccessWithoutLogin();
    loginPage.verifyAccessDenied();
  });

  it('should log back in and view report history', () => {
    loginPage.enterUsername('user12345');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.goToReportHistory();
    reportPage.verifyReportHistory();
  });
});