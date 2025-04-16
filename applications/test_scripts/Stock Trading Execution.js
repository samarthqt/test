describe('Stock Trading Execution', () => {
  const loginPage = new LoginPage();
  const tradingPage = new TradingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow users to execute stock trades in real-time', () => {
    // Step 1: Log into the investment account
    loginPage.login('12345', 'validPassword');

    // Step 2: Navigate to the Stock Trading section
    tradingPage.navigateToStockTrading();

    // Step 3: Select the stock symbol 'ABC'
    tradingPage.selectStock('ABC');

    // Step 4: Choose the trade type as 'Buy'
    tradingPage.selectTradeType('Buy');

    // Step 5: Enter the quantity of stocks to buy
    tradingPage.enterQuantity(100);

    // Step 6: Execute the trade
    tradingPage.executeTrade();

    // Step 7: Verify the trade details in the user's account
    tradingPage.verifyTradeDetails('ABC', 'Buy', 100);
  });
});