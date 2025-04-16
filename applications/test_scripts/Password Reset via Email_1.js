describe('Password Reset via Email', () => {
  const loginPage = new LoginPage();
  const resetPage = new ResetPage();
  const email = 'user@example.com';
  const newPassword = 'NewPassword123';

  it('should navigate to the login page', () => {
    loginPage.visit();
    loginPage.verifyLoginPageDisplayed();
  });

  it('should display password reset page on clicking forgot password', () => {
    loginPage.clickForgotPassword();
    resetPage.verifyResetPageDisplayed();
  });

  it('should accept registered email and display confirmation message', () => {
    resetPage.enterEmail(email);
    resetPage.verifyEmailAccepted();
  });

  it('should receive password reset email with reset link', () => {
    // Simulate checking email inbox and finding the reset link
    cy.checkEmailInbox(email).then(link => {
      expect(link).to.contain('reset-link');
    });
  });

  it('should redirect to password reset page on clicking email link', () => {
    cy.clickEmailLink('reset-link');
    resetPage.verifyResetPageDisplayed();
  });

  it('should accept new password and confirm password reset', () => {
    resetPage.enterNewPassword(newPassword);
    resetPage.confirmNewPassword(newPassword);
    resetPage.verifyPasswordResetSuccess();
  });

  it('should log in successfully with new password', () => {
    loginPage.login(email, newPassword);
    loginPage.verifyLoginSuccess();
  });
});