describe('Multi-Currency Account Management', () => {
  const accountId = '12345';

  before(() => {
    cy.visit('/login');
    cy.login(accountId);
  });

  it('should navigate to the currency management section', () => {
    cy.get('.currency-management-link').click();
    cy.url().should('include', '/currency-management');
    cy.get('.currency-options').should('contain', 'USD').and('contain', 'EUR').and('contain', 'GBP');
  });

  it('should add a new currency to the account', () => {
    cy.get('.add-currency-button').click();
    cy.get('.currency-select').select('EUR');
    cy.get('.confirm-add-currency').click();
    cy.get('.managed-currencies').should('contain', 'EUR');
  });

  it('should display account balance in each managed currency', () => {
    cy.get('.balance-display').within(() => {
      cy.get('.currency-usd').should('exist');
      cy.get('.currency-eur').should('exist');
      cy.get('.currency-gbp').should('exist');
    });
  });
});