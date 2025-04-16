describe('Asset Tax Calculation Test', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('user', 'password');
  });

  it('should calculate taxes for asset purchases correctly', () => {
    const reportingPage = new ReportingPage();
    reportingPage.navigateToReportingModule();
    reportingPage.selectTaxCalculation();
    reportingPage.enterAssetCost('10000');
    reportingPage.enterTaxRate('10');
    reportingPage.clickCalculate();
    reportingPage.verifyCalculatedTaxAmount('1000');
  });
});