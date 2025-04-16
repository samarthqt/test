describe('Currency Conversion for Unsupported Currency', () => {
  const unsupportedCurrency = 'XYZ';
  const errorMessage = 'Currency is not supported';
  let currencyPage;

  before(() => {
    cy.visit('/login');
    cy.login('user', 'password');
    currencyPage = new CurrencyPage();
  });

  it('should display error message for unsupported currency', () => {
    currencyPage.navigateToCurrencyManagement();
    currencyPage.addCurrency(unsupportedCurrency);
    currencyPage.getErrorMessage().should('contain', errorMessage);
  });

  after(() => {
    cy.logout();
  });
});