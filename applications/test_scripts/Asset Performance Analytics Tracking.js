describe('Asset Performance Analytics Tracking', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const reportingModulePage = new ReportingModulePage();
  const performanceAnalyticsPage = new PerformanceAnalyticsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyUserIsOnDashboard();
  });

  it('should navigate to the Reporting module', () => {
    dashboardPage.navigateToReportingModule();
    reportingModulePage.verifyOnReportingModulePage();
  });

  it('should select the Performance Analytics sub-module', () => {
    reportingModulePage.selectPerformanceAnalytics();
    performanceAnalyticsPage.verifyOnPerformanceAnalyticsPage();
  });

  it('should search for the asset using Asset ID: A12345', () => {
    performanceAnalyticsPage.searchAsset('A12345');
    performanceAnalyticsPage.verifyAssetDetailsDisplayed();
  });

  it('should verify the asset's usage frequency is recorded as 10 times/month', () => {
    performanceAnalyticsPage.verifyUsageFrequency('10 times/month');
  });

  it('should verify the asset's downtime is recorded as 2 hours/month', () => {
    performanceAnalyticsPage.verifyDowntime('2 hours/month');
  });

  it('should generate a report for the asset's performance over the last 6 months', () => {
    performanceAnalyticsPage.generatePerformanceReport();
    performanceAnalyticsPage.verifyReportGenerated();
  });

  it('should export the performance report to a PDF file', () => {
    performanceAnalyticsPage.exportReportToPDF();
    performanceAnalyticsPage.verifyReportExported();
  });

  it('should log out of the Dynamics 365 system', () => {
    dashboardPage.logout();
    loginPage.verifyUserIsLoggedOut();
  });
});