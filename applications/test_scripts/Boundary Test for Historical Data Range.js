describe('Boundary Test for Historical Data Range', () => {
  const reportingPage = new ReportingPage();
  const assetUsageForecastPage = new AssetUsageForecastPage();

  before(() => {
    cy.login(); // Assuming a custom command for login
  });

  it('should generate asset usage forecast for historical data range', () => {
    reportingPage.navigateToReportingModule();
    reportingPage.selectAssetUsageForecast();
    assetUsageForecastPage.enterStartDate('01/01/1900');
    assetUsageForecastPage.enterEndDate(new Date().toLocaleDateString('en-GB'));
    assetUsageForecastPage.clickGenerateReport();

    // Add assertions to verify report generation
    cy.contains('Report generated successfully').should('be.visible');
  });
});