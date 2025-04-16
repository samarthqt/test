describe('System Load Monitoring Positive Scenario', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should monitor system load and trigger alerts for high load conditions', () => {
    // Step 1: Log in to the system monitoring dashboard
    loginPage.login('admin', 'adminPassword');
    dashboardPage.verifyAdminDashboard();

    // Step 2: Set the load threshold to 80%
    dashboardPage.setLoadThreshold(80);
    dashboardPage.verifyThresholdSet(80);

    // Step 3: Simulate an increase in system load to 85%
    dashboardPage.simulateLoadIncrease(85);
    dashboardPage.verifyCurrentLoad(85);

    // Step 4: Check for alerts in the monitoring dashboard
    dashboardPage.checkForAlerts();
    dashboardPage.verifyAlertTriggered();

    // Step 5: Review the alert details
    dashboardPage.reviewAlertDetails();
    dashboardPage.verifyAlertDetails(85, 80);

    // Step 6: Acknowledge the alert
    dashboardPage.acknowledgeAlert();
    dashboardPage.verifyAlertAcknowledged();

    // Step 7: Log out from the monitoring dashboard
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});