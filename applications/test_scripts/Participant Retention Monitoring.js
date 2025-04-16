describe('Participant Retention Monitoring', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const participantManagementPage = new ParticipantManagementPage();
  const viewParticipantsPage = new ViewParticipantsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the system', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Participant Management module', () => {
    dashboardPage.goToParticipantManagement();
    participantManagementPage.verifyParticipantManagementPage();
  });

  it('should add a new participant with retention tracking', () => {
    participantManagementPage.selectRetentionTracking();
    participantManagementPage.clickAddNewParticipant();
    participantManagementPage.enterParticipantID('P456');
    participantManagementPage.setRetentionStatus('Active');
    participantManagementPage.submitParticipantData();
  });

  it('should verify participant in View Participants section', () => {
    participantManagementPage.navigateToViewParticipants();
    viewParticipantsPage.searchParticipant('P456');
    viewParticipantsPage.verifyParticipantRetentionStatus('Active');
  });

  it('should update dropout reason and verify retention status', () => {
    viewParticipantsPage.updateDropoutReason('Personal reasons');
    viewParticipantsPage.verifyRetentionStatus('Dropped');
  });

  it('should delete the participant and verify deletion', () => {
    viewParticipantsPage.deleteParticipant('P456');
    viewParticipantsPage.verifyParticipantNotExist('P456');
  });

  it('should log out of the system', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });

  after(() => {
    cy.verifyDatabaseIntegrity('P456');
  });
});