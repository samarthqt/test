describe('User Login with Correct Credentials', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow a user to log in and display the dashboard correctly', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('SecurePassword123');
    loginPage.clickLoginButton();

    dashboardPage.verifyWelcomeMessage();
    dashboardPage.verifyUserDetails();
  });

  afterEach(() => {
    dashboardPage.logout();
    cy.url().should('include', '/home');
  });
});