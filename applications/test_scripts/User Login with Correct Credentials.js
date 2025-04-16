describe('User Login with Correct Credentials', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in successfully with correct credentials', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('CorrectPassword123');
    loginPage.clickLoginButton();

    dashboardPage.verifyDashboardIsDisplayed();
    dashboardPage.verifyProfileDetails('testuser');
  });
});