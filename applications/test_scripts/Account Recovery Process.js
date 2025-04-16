describe('Account Recovery Process', () => {
  const loginPage = new LoginPage();
  const recoveryPage = new RecoveryPage();
  const email = 'user@example.com';
  const securityAnswer = 'Smith';
  const newPassword = 'newPassword123';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should recover account using email verification and security questions', () => {
    loginPage.clickForgotPassword();
    recoveryPage.enterEmail(email);
    recoveryPage.submitEmail();
    cy.checkEmailForVerificationLink(email);
    cy.clickVerificationLink();
    recoveryPage.answerSecurityQuestion(securityAnswer);
    recoveryPage.enterNewPassword(newPassword);
    recoveryPage.confirmNewPassword(newPassword);
    recoveryPage.submitNewPassword();
    loginPage.login(email, newPassword);
    loginPage.verifySuccessfulLogin();
    loginPage.logout();
    loginPage.verifySuccessfulLogout();
  });
});