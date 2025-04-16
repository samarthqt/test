describe('Password Reset with Invalid Email', () => {
  const loginPage = new LoginPage();
  const passwordResetPage = new PasswordResetPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display error for unregistered email during password reset', () => {
    loginPage.clickForgotPassword();
    passwordResetPage.enterEmail('invalid@example.com');
    passwordResetPage.submitRequest();
    passwordResetPage.verifyErrorMessage('The email is not registered.');
  });
});