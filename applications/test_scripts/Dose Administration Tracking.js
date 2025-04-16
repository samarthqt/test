describe('Dose Administration Tracking', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const doseTrackingPage = new DoseTrackingPage();
  const participantPage = new ParticipantPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the system with medication management access', () => {
    loginPage.login('medication_manager', 'password');
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to Dose Tracking module', () => {
    dashboardPage.navigateToDoseTracking();
    doseTrackingPage.verifyDoseTrackingScreenDisplayed();
  });

  it('should select the participant with ID P003', () => {
    doseTrackingPage.selectParticipant('P003');
    participantPage.verifyParticipantPageDisplayed();
  });

  it('should enter medication details', () => {
    participantPage.enterMedicationDetails('Drug A', '50mg', '2023-10-01 09:00');
    participantPage.verifyMedicationDetailsEntered();
  });

  it('should save the dose administration record', () => {
    participantPage.saveDoseAdministrationRecord();
    participantPage.verifyConfirmationMessageDisplayed();
  });

  it('should navigate back to the participant list', () => {
    participantPage.navigateToParticipantList();
    doseTrackingPage.verifyParticipantListDisplayed();
  });

  it('should search for participant ID P003 and open the profile', () => {
    doseTrackingPage.searchAndOpenParticipant('P003');
    participantPage.verifyParticipantPageDisplayed();
  });

  it('should review the medication details and administration record', () => {
    participantPage.reviewMedicationDetails();
    participantPage.verifyMedicationDetailsCorrect();
  });

  it('should log out of the system', () => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});