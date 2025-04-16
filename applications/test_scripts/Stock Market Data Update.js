describe('Stock Market Data Update', () => {
  const loginPage = new LoginPage();
  const stockTradingPage = new StockTradingPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the investment account', () => {
    loginPage.enterUserId('67890');
    loginPage.enterPassword('password123');
    loginPage.submit();
    cy.url().should('include', '/trading-platform');
  });

  it('should navigate to the Stock Trading section', () => {
    stockTradingPage.navigateToStockTrading();
    stockTradingPage.verifyRealTimeMarketData();
  });

  it("should select the stock symbol 'DEF' to view market data", () => {
    stockTradingPage.selectStockSymbol('DEF');
    stockTradingPage.verifyStockDetails('DEF');
  });

  it('should monitor the stock price for real-time updates', () => {
    stockTradingPage.monitorRealTimeUpdates();
  });

  it('should verify that no error messages are shown during data update', () => {
    stockTradingPage.verifyNoErrorMessages();
  });
});