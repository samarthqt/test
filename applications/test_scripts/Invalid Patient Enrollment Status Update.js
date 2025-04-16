describe('Invalid Patient Enrollment Status Update', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const participantManagementPage = new ParticipantManagementPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the Dynamics 365 system', () => {
    loginPage.login('username', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Participant Management module', () => {
    dashboardPage.navigateToParticipantManagement();
    participantManagementPage.verifyParticipantManagementPage();
  });

  it('should search for a patient using Patient ID: 12345', () => {
    participantManagementPage.searchPatientById('12345');
    participantManagementPage.verifyPatientRecord('Active');
  });

  it('should attempt to change enrollment status to Invalid', () => {
    participantManagementPage.changeEnrollmentStatusTo('Invalid');
    participantManagementPage.verifyErrorMessage('Invalid status');
  });

  it('should ensure participation status remains unchanged', () => {
    participantManagementPage.verifyParticipationStatus('Active');
  });

  after(() => {
    dashboardPage.logout();
  });
});