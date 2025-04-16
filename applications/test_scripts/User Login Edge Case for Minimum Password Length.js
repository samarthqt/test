describe('User Login Edge Case for Minimum Password Length', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should login successfully with minimum password length', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('Short1');
    loginPage.clickLoginButton();

    dashboardPage.verifyDashboardIsDisplayed();
    dashboardPage.checkSystemPerformance();
  });
});