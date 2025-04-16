describe('Investment with Maximum Allowable Amount', () => {
  const investmentPage = new InvestmentPage();
  before(() => {
    cy.login(); // Assuming a custom command for logging in
  });

  it('should handle maximum allowable investment amount', () => {
    investmentPage.navigateToInvestmentModule();
    investmentPage.selectInvestmentType('Mutual Funds');
    investmentPage.selectSpecificMutualFund();
    investmentPage.enterInvestmentAmount('50000');
    investmentPage.initiateInvestment();
    investmentPage.confirmInvestment();
    investmentPage.verifyAccountBalance('$50000');
  });
});