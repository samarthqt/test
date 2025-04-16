describe('Invalid Adverse Event Reporting', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const safetyMonitoringPage = new SafetyMonitoringPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should validate the handling of incorrect adverse event inputs', () => {
    loginPage.login('username', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToSafetyMonitoring();

    safetyMonitoringPage.searchParticipant('67890');
    safetyMonitoringPage.logAdverseEvent('Invalid', 'Participant experienced an unknown event.');
    safetyMonitoringPage.verifyErrorMessage('Invalid event type');
    safetyMonitoringPage.verifyNoAlertsSent();

    dashboardPage.logout();
  });
});