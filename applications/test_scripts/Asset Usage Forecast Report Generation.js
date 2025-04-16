describe('Asset Usage Forecast Report Generation', () => {
  const reportingPage = new ReportingPage();

  beforeEach(() => {
    cy.visit('/reporting');
  });

  it('should generate asset usage forecast report based on historical data', () => {
    reportingPage.navigateToAssetUsageForecast();
    reportingPage.enterStartDate('01/01/2020');
    reportingPage.enterEndDate('12/31/2022');
    reportingPage.clickGenerateReport();
    reportingPage.verifyReportGenerated();
  });
});