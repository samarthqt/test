describe('User Login with Empty Credentials', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should not allow login with empty username and password', () => {
    loginPage.clickLoginButton();
    loginPage.verifyErrorMessage('Fields cannot be empty.');
  });
});