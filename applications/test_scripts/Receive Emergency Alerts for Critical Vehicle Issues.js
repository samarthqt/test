describe('Receive Emergency Alerts for Critical Vehicle Issues', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const vehicleMonitoringPage = new VehicleMonitoringPage();

  before(() => {
    cy.visit('/login');
  });

  it('Logs in to the system with user credentials', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('Simulates a critical vehicle issue', () => {
    vehicleMonitoringPage.simulateCriticalIssue('123ABC', 'Engine Failure');
    vehicleMonitoringPage.verifyCriticalIssueDetected('Engine Failure');
  });

  it('Verifies that an emergency alert is triggered', () => {
    vehicleMonitoringPage.verifyEmergencyAlert('Engine Failure');
  });

  it('Checks for a push notification on the user's device', () => {
    vehicleMonitoringPage.verifyPushNotification('Engine Failure');
  });

  after(() => {
    dashboardPage.logout();
  });
});