describe('Investment Module Tests', () => {
  const investmentPage = new InvestmentPage();

  before(() => {
    cy.login(); // Custom command to log into the application
  });

  it('should browse and initiate investment in stocks', () => {
    investmentPage.navigateToInvestmentModule();
    investmentPage.selectInvestmentType('Stocks');
    investmentPage.selectStockOption('Specific Stock Name');
    investmentPage.enterInvestmentAmount('1000');
    investmentPage.initiateInvestment();
    investmentPage.confirmInvestment();
    investmentPage.verifyAccountBalance('$9,000');
    investmentPage.navigateToInvestmentHistory();
  });

  after(() => {
    cy.logout(); // Custom command to log out of the application
  });
});