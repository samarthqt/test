describe('Password Reset via Email', () => {
  const registeredEmail = 'user@example.com';
  const newPassword = 'NewSecurePassword123';

  before(() => {
    cy.visit('/login');
  });

  it('should navigate to the password reset request page', () => {
    cy.get('#forgot-password-link').click();
    cy.url().should('include', '/password-reset-request');
  });

  it('should send a password reset link to the registered email', () => {
    cy.get('#email-input').type(registeredEmail);
    cy.get('#submit-button').click();
    cy.get('.notification').should('contain', 'A password reset link has been sent');
  });

  it('should receive the password reset email and click the reset link', () => {
    cy.task('checkEmail', registeredEmail).then(email => {
      expect(email).to.have.property('subject', 'Password Reset Request');
      const resetLink = email.body.match(/https:\/\/example.com\/reset\?token=\w+/)[0];
      cy.visit(resetLink);
    });
  });

  it('should allow setting a new password', () => {
    cy.get('#new-password-input').type(newPassword);
    cy.get('#confirm-password-input').type(newPassword);
    cy.get('#reset-button').click();
    cy.get('.notification').should('contain', 'Your password has been reset');
  });

  it('should log in with the new password', () => {
    cy.visit('/login');
    cy.get('#email-input').type(registeredEmail);
    cy.get('#password-input').type(newPassword);
    cy.get('#login-button').click();
    cy.url().should('include', '/dashboard');
  });
});