describe('Stock Trading Error Handling', () => {
  const loginPage = new LoginPage();
  const tradingPage = new TradingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should handle insufficient funds error when executing a trade', () => {
    loginPage.login('54321', 'validPassword');
    tradingPage.navigateToStockTrading();
    tradingPage.selectStock('XYZ');
    tradingPage.chooseTradeType('Buy');
    tradingPage.enterQuantity(1000);
    tradingPage.executeTrade();
    tradingPage.verifyInsufficientFundsError();
  });
});