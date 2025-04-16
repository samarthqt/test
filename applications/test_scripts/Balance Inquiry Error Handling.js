describe('Balance Inquiry Error Handling', () => {
  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display error on login attempt with incorrect credentials', () => {
    const loginPage = new LoginPage();
    loginPage.enterUserId('54321');
    loginPage.enterPassword('incorrectPassword');
    loginPage.submitLogin();
    loginPage.verifyErrorMessage('Incorrect credentials');
  });

  it('should persist error message on retry with incorrect credentials', () => {
    const loginPage = new LoginPage();
    loginPage.enterUserId('54321');
    loginPage.enterPassword('incorrectPassword');
    loginPage.submitLogin();
    loginPage.verifyErrorMessage('Incorrect credentials');
    loginPage.submitLogin();
    loginPage.verifyErrorMessage('Incorrect credentials');
  });

  it('should not display account balance information', () => {
    const accountPage = new AccountPage();
    accountPage.verifyNoBalanceInfoDisplayed();
  });

  it('should deny access to Account Management section without login', () => {
    cy.visit('/account-management');
    cy.url().should('include', '/login');
  });

  it('should deny access to balance inquiry via URL manipulation', () => {
    cy.visit('/balance-inquiry');
    cy.url().should('include', '/login');
  });
});