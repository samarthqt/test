describe('Adverse Event Description Boundary Testing', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const safetyMonitoringPage = new SafetyMonitoringPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in and navigate to the dashboard', () => {
    loginPage.login('username', 'password');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to the Safety Monitoring module', () => {
    dashboardPage.navigateToSafetyMonitoring();
    safetyMonitoringPage.verifySafetyMonitoringPageIsDisplayed();
  });

  it('should search for a participant using Participant ID: 67890', () => {
    safetyMonitoringPage.searchParticipantById('67890');
    safetyMonitoringPage.verifyParticipantRecordIsDisplayed();
  });

  it('should display an error for description exceeding maximum character limit', () => {
    safetyMonitoringPage.logAdverseEvent('Severe Headache', 'A'.repeat(1001));
    safetyMonitoringPage.verifyErrorMessage('Character limit exceeded');
  });

  it('should display an error for empty description', () => {
    safetyMonitoringPage.logAdverseEvent('Severe Headache', '');
    safetyMonitoringPage.verifyErrorMessage('Description cannot be empty');
  });

  after(() => {
    dashboardPage.logout();
  });
});