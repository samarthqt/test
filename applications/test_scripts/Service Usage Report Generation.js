describe('Service Usage Report Generation', () => {
  const loginPage = new LoginPage();
  const usageAnalyticsPage = new UsageAnalyticsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the user account', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.clickLogin();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Usage Analytics module', () => {
    usageAnalyticsPage.navigateToUsageAnalytics();
    cy.get('.usage-analytics-dashboard').should('be.visible');
  });

  it('should select the service and report period', () => {
    usageAnalyticsPage.selectService('12345');
    usageAnalyticsPage.selectReportPeriod('Last 30 days');
    cy.get('.service-details').should('be.visible');
    cy.get('.report-period').should('contain', 'Last 30 days');
  });

  it('should generate and display the report', () => {
    usageAnalyticsPage.clickGenerateReport();
    cy.get('.report').should('be.visible');
  });

  it('should verify the data consumption details', () => {
    cy.get('.data-consumption-details').should('contain', 'expected data');
  });

  it('should verify the time spent details', () => {
    cy.get('.time-spent-details').should('contain', 'expected time');
  });

  it('should download the report', () => {
    usageAnalyticsPage.downloadReport();
    cy.verifyDownload('report.pdf');
  });
});