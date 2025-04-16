describe('Invalid Tax Rate Handling', () => {
  const reportingPage = new ReportingPage();

  before(() => {
    cy.login(); // Assume a login function is available
  });

  it('should handle invalid tax rate inputs', () => {
    reportingPage.visit();
    reportingPage.selectTaxCalculation();
    reportingPage.enterAssetCost('10000');
    reportingPage.enterTaxRate('-5');
    reportingPage.clickCalculate();
    reportingPage.verifyErrorMessage('Invalid tax rate');
  });
});