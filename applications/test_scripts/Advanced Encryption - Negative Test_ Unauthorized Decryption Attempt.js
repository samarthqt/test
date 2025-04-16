describe('Advanced Encryption - Negative Test: Unauthorized Decryption Attempt', () => {
  beforeEach(() => {
    cy.visit('/login');
  });

  it('should deny access to encryption keys with unauthorized user credentials', () => {
    const loginPage = new LoginPage();
    loginPage.login('hacker_user', 'wrong_password');

    cy.url().should('include', '/access-denied');
    cy.get('.alert').should('contain', 'Access is denied');
  });

  it('should log unauthorized decryption attempt', () => {
    cy.visit('/decrypt');
    cy.get('#decrypt-button').click();

    cy.get('.alert').should('contain', 'Decryption failed');
    cy.get('.log-entry').should('contain', 'Unauthorized decryption attempt logged');
  });
});