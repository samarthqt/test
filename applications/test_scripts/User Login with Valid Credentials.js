describe('User Login with Valid Credentials', () => {
  it('should allow a user to log in with valid credentials', () => {
    const loginPage = new LoginPage();
    loginPage.navigate();
    loginPage.enterUsername('testuser@example.com');
    loginPage.enterPassword('ValidPassword123');
    loginPage.clickLogin();
    cy.url().should('include', '/dashboard');
  });
});