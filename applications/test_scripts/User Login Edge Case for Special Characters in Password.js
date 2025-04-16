describe('User Login Edge Case for Special Characters in Password', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in successfully with special characters in password', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('Special!@#123');
    loginPage.clickLoginButton();

    dashboardPage.verifyDashboardIsDisplayed();
    dashboardPage.checkSystemPerformance();
  });
});