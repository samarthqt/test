describe('Boundary Testing for Enrollment Status', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const participantManagementPage = new ParticipantManagementPage();

  before(() => {
    cy.visit('/');
    loginPage.login('username', 'password');
  });

  it('should navigate to Participant Management module', () => {
    dashboardPage.navigateToParticipantManagement();
    participantManagementPage.verifyModuleIsDisplayed();
  });

  it('should search for a patient using Patient ID', () => {
    participantManagementPage.searchPatientById('12345');
    participantManagementPage.verifyPatientRecordIsDisplayed();
  });

  it('should display error for exceeding character limit in enrollment status', () => {
    participantManagementPage.updateEnrollmentStatus('A'.repeat(256));
    participantManagementPage.verifyErrorMessage('Character limit exceeded');
  });

  it('should display error for empty enrollment status', () => {
    participantManagementPage.updateEnrollmentStatus('');
    participantManagementPage.verifyErrorMessage('Enrollment status cannot be empty');
  });

  after(() => {
    dashboardPage.logout();
  });
});