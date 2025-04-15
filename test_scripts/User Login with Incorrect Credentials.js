describe('User Login with Incorrect Credentials', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display error message for incorrect login', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('WrongPassword');
    loginPage.clickLoginButton();
    loginPage.getErrorMessage().should('contain', 'incorrect email or password');
  });

  it('should prevent account lockout and provide password recovery options', () => {
    for (let i = 0; i < 3; i++) {
      loginPage.enterEmail('user@example.com');
      loginPage.enterPassword('WrongPassword');
      loginPage.clickLoginButton();
    }
    loginPage.getRecoveryOptions().should('exist');
  });

  it('should allow login with correct credentials after incorrect attempts', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('CorrectPassword');
    loginPage.clickLoginButton();
    cy.url().should('include', '/dashboard');
  });
});