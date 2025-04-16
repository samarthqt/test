describe('User Data Deletion Request', () => {
  const userEmail = 'user@example.com';
  const userId = '12345';

  before(() => {
    cy.visit('/login');
    cy.login(userEmail, 'password');
  });

  it('should navigate to Account Settings', () => {
    cy.get('.account-settings-button').click();
    cy.url().should('include', '/account-settings');
  });

  it('should locate and select Data Deletion option', () => {
    cy.get('.data-deletion-button').should('be.visible').click();
    cy.get('.confirmation-dialog').should('be.visible');
  });

  it('should confirm data deletion request', () => {
    cy.get('.confirm-deletion-button').click();
    cy.get('.confirmation-message').should('contain', 'Data deletion process initiated');
  });

  it('should receive confirmation email', () => {
    cy.checkEmail(userEmail).should('contain', 'Data deletion request initiated');
  });

  it('should process deletion request', () => {
    cy.wait(5000); // Adjust based on expected processing time
    cy.checkDatabase(userId).should('not.exist');
  });

  it('should fail login with deleted account', () => {
    cy.visit('/login');
    cy.login(userEmail, 'password');
    cy.get('.error-message').should('contain', 'Account does not exist');
  });

  it('should verify system logs for data deletion', () => {
    cy.checkSystemLogs(userId).should('contain', 'Data deletion process completed');
  });
});