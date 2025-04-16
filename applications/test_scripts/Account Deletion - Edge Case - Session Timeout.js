describe('Account Deletion - Edge Case - Session Timeout', () => {
  const username = 'test_user';
  const password = 'test_pass';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  });

  it('should not complete account deletion if session times out', () => {
    cy.visit('/account-settings');
    cy.get('#deleteAccountButton').should('be.visible');
    cy.get('#deleteAccountButton').click();
    cy.get('#confirmationDialog').should('be.visible');

    cy.wait(60000); // Simulate session timeout

    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();

    cy.visit('/account-settings');
    cy.get('#accountStatus').should('contain', 'Active');
  });
});