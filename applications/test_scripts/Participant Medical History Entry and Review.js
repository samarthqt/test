describe('Participant Medical History Entry and Review', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const participantManagementPage = new ParticipantManagementPage();
    const participantDetailsPage = new ParticipantDetailsPage();

    before(() => {
        // Setup: Ensure participant P001 is registered in the trial
    });

    it('should log into the system with clinician credentials', () => {
        loginPage.visit();
        loginPage.login('clinician_username', 'clinician_password');
        dashboardPage.verifyDashboardIsDisplayed();
    });

    it('should navigate to Participant Management module', () => {
        dashboardPage.navigateToParticipantManagement();
        participantManagementPage.verifyParticipantManagementScreenIsDisplayed();
    });

    it('should select the participant with ID P001', () => {
        participantManagementPage.selectParticipantById('P001');
        participantDetailsPage.verifyParticipantDetailsPageIsDisplayed();
    });

    it('should enter and save medical history details', () => {
        participantDetailsPage.clickMedicalRecordsTab();
        participantDetailsPage.enterMedicalHistory('Asthma, Allergies');
        participantDetailsPage.saveMedicalHistory();
        participantDetailsPage.verifyConfirmationMessage();
    });

    it('should navigate back to the participant list and review medical history', () => {
        participantDetailsPage.navigateBackToParticipantList();
        participantManagementPage.searchAndOpenParticipant('P001');
        participantDetailsPage.verifyParticipantDetailsPageIsDisplayed();
        participantDetailsPage.clickMedicalRecordsTab();
        participantDetailsPage.verifyMedicalHistory('Asthma, Allergies');
    });

    it('should log out of the system', () => {
        dashboardPage.logout();
        loginPage.verifyUserIsLoggedOut();
    });
});