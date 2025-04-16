describe('TC-671 58 Negative Test: Insufficient Funds', () => {
  before(() => {
    cy.visit('/login');
    cy.login('username', 'password');
  });

  it('should prevent transfer when there are insufficient funds', () => {
    cy.get('nav').contains('Funds Transfer').click();
    cy.url().should('include', '/funds-transfer');

    cy.get('#fromAccount').select('403');
    cy.get('#toAccount').select('404');
    cy.get('#transferAmount').type('500');
    cy.get('#transferButton').click();

    cy.get('.error-message').should('contain', 'Insufficient funds in the source account.');
  });
});