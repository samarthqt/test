describe('User Authentication with Invalid Password', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should prevent login with an incorrect password', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('InvalidPassword');
    loginPage.clickLogin();
    loginPage.verifyErrorMessage('Incorrect password');
  });
});