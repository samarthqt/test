describe('TC-615 480 Real-Time Alerts for Critical Data', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const alertsPage = new AlertsPage();
  const participantPage = new ParticipantPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the system with data management access', () => {
    loginPage.login('dataManager', 'password');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Alerts module', () => {
    dashboardPage.navigateToAlerts();
    alertsPage.verifyAlertsScreenIsDisplayed();
  });

  it('should select the participant with ID P004', () => {
    alertsPage.selectParticipant('P004');
    participantPage.verifyParticipantAlertsPageIsDisplayed();
  });

  it('should enter event details and trigger the alert', () => {
    participantPage.enterEventDetails('Adverse Event', 'Severe headache', '2023-10-01 10:00');
    participantPage.triggerEventAlert();
    participantPage.verifyAlertSent();
  });

  it('should navigate back to the participant list', () => {
    participantPage.navigateBackToParticipantList();
    participantPage.verifyParticipantListIsDisplayed();
  });

  it('should search for participant ID P004 and review alert details', () => {
    participantPage.searchAndOpenParticipantProfile('P004');
    participantPage.verifyAlertDetailsAndConfirmation();
  });

  it('should log out of the system', () => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccessful();
  });
});