class CurrencyPage {
  navigateToCurrencyManagement() {
    cy.get('#currency-management-link').click();
  }

  addCurrency(currency) {
    cy.get('#add-currency-input').type(currency);
    cy.get('#add-currency-button').click();
  }

  getErrorMessage() {
    return cy.get('#error-message');
  }
}