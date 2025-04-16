describe('User Login Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow a user to log in with valid credentials', () => {
    loginPage.enterEmail('testuser@example.com');
    loginPage.enterPassword('Test@1234');
    loginPage.clickLogin();
    dashboardPage.verifyDashboardIsDisplayed();
  });
});