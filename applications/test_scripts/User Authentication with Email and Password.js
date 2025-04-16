describe('User Authentication with Email and Password', () => {
  it('should successfully log in with valid email and password', () => {
    const loginPage = new LoginPage();
    loginPage.navigate();
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('ValidPassword123');
    loginPage.clickLogin();
    cy.url().should('include', '/dashboard');
  });
});