describe('Password Recovery via Email', () => {
  const email = 'user@example.com';
  const newPassword = 'newpassword123';

  before(() => {
    cy.visit('/password-recovery');
  });

  it('should display the password recovery page with an email input field', () => {
    cy.get('input[type="email"]').should('be.visible');
  });

  it('should submit the email and receive a password reset link', () => {
    cy.get('input[type="email"]').type(email);
    cy.get('button[type="submit"]').click();
    cy.wait(5000); // Wait for email delivery
    cy.checkEmailInbox(email).then((link) => {
      expect(link).to.contain('/reset-password');
    });
  });

  it('should navigate to the password reset page and reset the password', () => {
    cy.checkEmailInbox(email).then((link) => {
      cy.visit(link);
    });
    cy.get('input[name="new-password"]').type(newPassword);
    cy.get('input[name="confirm-password"]').type(newPassword);
    cy.get('button[type="submit"]').click();
    cy.get('.confirmation-message').should('contain', 'Password successfully changed');
  });
});