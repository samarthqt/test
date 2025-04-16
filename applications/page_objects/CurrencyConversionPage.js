class CurrencyConversionPage {
  enterAmount(amount) {
    cy.get('#amount').type(amount);
  }

  selectFromCurrency(currency) {
    cy.get('#fromCurrency').select(currency);
  }

  selectToCurrency(currency) {
    cy.get('#toCurrency').select(currency);
  }

  clickConvert() {
    cy.get('#convertButton').click();
  }

  getConversionResult() {
    return cy.get('#conversionResult');
  }
}

export default CurrencyConversionPage;