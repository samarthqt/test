describe('Invalid Date Range for Forecast', () => {
 it('should display an error message for invalid date range', () => {
 cy.login(); // Assume a custom command for login
 const reportingPage = new ReportingPage();
 reportingPage.navigateToReportingModule();
 reportingPage.selectAssetUsageForecast();
 reportingPage.enterStartDate('12/31/2023');
 reportingPage.enterEndDate('01/01/2020');
 reportingPage.clickGenerateReport();
 reportingPage.verifyErrorMessage('Invalid date range');
 });
});