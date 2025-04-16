describe('IP Geolocation Restriction Negative Scenario', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should grant access from an unrestricted location', () => {
    // Attempt to log in from the IP address 203.0.113.5
    loginPage.login('203.0.113.5');
    
    // Verify access is granted
    cy.url().should('include', '/dashboard');

    // Verify the dashboard is accessible
    dashboardPage.verifyDashboardAccess();

    // Log out from the service
    dashboardPage.logout();
    cy.url().should('include', '/login');
  });
});