describe('Password Recovery - Invalid Email', () => {
  beforeEach(() => {
    cy.visit('/password-recovery');
  });
  it('should display error message for unregistered email', () => {
    const passwordRecoveryPage = new PasswordRecoveryPage();
    passwordRecoveryPage.enterEmail('invaliduser@example.com');
    passwordRecoveryPage.submitRequest();
    passwordRecoveryPage.getErrorMessage().should('contain', 'The email is not registered');
  });
});