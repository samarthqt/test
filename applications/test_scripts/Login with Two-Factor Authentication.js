describe('Login with Two-Factor Authentication', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in with two-factor authentication', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('ValidPassword123');
    loginPage.clickLoginButton();

    loginPage.enterVerificationCode('123456');
    loginPage.clickVerifyButton();

    cy.url().should('include', '/dashboard');
  });
});