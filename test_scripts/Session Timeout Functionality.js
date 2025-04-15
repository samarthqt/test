describe('Session Timeout Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should automatically log user out after inactivity', () => {
    // Step 1: Log in to the user account
    loginPage.enterEmail('testuser@example.com');
    loginPage.enterPassword('yourPassword');
    loginPage.submit();

    // Verify login success
    dashboardPage.verifyDashboardVisible();

    // Step 2: Navigate to the user dashboard
    cy.url().should('include', '/dashboard');

    // Step 3: Leave session inactive for 15 minutes
    cy.wait(900000); // This waits for 15 minutes (15 * 60 * 1000 ms)

    // Step 4: Attempt to perform an action
    dashboardPage.performAction();

    // Verify user is logged out and redirected to login page
    cy.url().should('include', '/login');

    // Step 5: Log in again to verify session reset
    loginPage.enterEmail('testuser@example.com');
    loginPage.enterPassword('yourPassword');
    loginPage.submit();
    dashboardPage.verifyDashboardVisible();

    // Step 6: Log out from the user account
    dashboardPage.logout();
    cy.url().should('include', '/login');
  });
});