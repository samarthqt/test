import LoginPage from '../pageObjects/LoginPage';

describe('User Login with Invalid Credentials', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display an error message when invalid credentials are used', () => {
    loginPage.enterUsername('testuser@example.com');
    loginPage.enterPassword('InvalidPassword');
    loginPage.clickLoginButton();
    loginPage.verifyErrorMessage('Invalid credentials');
  });
});