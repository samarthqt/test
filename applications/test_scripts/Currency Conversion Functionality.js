describe('Currency Conversion Functionality', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/currency-conversion');
  });

  it('should convert 100 USD to EUR', () => {
    const currencyConversionPage = new CurrencyConversionPage();

    currencyConversionPage.enterAmount('100');
    currencyConversionPage.selectFromCurrency('USD');
    currencyConversionPage.selectToCurrency('EUR');
    currencyConversionPage.clickConvert();

    // Assert the conversion result is displayed
    currencyConversionPage.getConversionResult().should('be.visible');
  });
});