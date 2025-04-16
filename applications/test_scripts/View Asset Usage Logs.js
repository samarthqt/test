describe('Asset Usage Logs Test', () => {
  const loginPage = new LoginPage();
  const assetPage = new AssetPage();
  const usageLogsPage = new UsageLogsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in as John Doe', () => {
    loginPage.login('John Doe', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Asset Management module', () => {
    assetPage.navigateToAssetManagement();
    cy.url().should('include', '/asset-management');
  });

  it('should select Usage Logs from sub-module menu', () => {
    assetPage.selectUsageLogs();
    cy.url().should('include', '/usage-logs');
  });

  it('should search for Laptop XYZ', () => {
    usageLogsPage.searchAsset('Laptop XYZ');
    cy.contains('Laptop XYZ').should('be.visible');
  });

  it('should select the asset Laptop XYZ', () => {
    usageLogsPage.selectAsset('Laptop XYZ');
    cy.contains('Asset Details').should('be.visible');
  });

  it('should set date range filter to Last 30 days', () => {
    usageLogsPage.setDateRange('Last 30 days');
    cy.contains('Date Range: Last 30 days').should('be.visible');
  });

  it('should view logs for Laptop XYZ', () => {
    usageLogsPage.viewLogs();
    cy.contains('Usage Logs').should('be.visible');
  });

  it('should verify logs display correct details', () => {
    usageLogsPage.verifyLogDetails();
    cy.contains('Date').should('be.visible');
    cy.contains('Time').should('be.visible');
    cy.contains('User Details').should('be.visible');
  });

  it('should export logs to CSV', () => {
    usageLogsPage.exportLogsToCSV();
    cy.readFile('cypress/downloads/logs.csv').should('exist');
  });

  it('should verify CSV contents', () => {
    cy.readFile('cypress/downloads/logs.csv').then((csv) => {
      expect(csv).to.include('Laptop XYZ');
    });
  });
});