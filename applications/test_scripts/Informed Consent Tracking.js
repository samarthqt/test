describe('Informed Consent Tracking', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const informedConsentPage = new InformedConsentPage();
  const participantPage = new ParticipantPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the system', () => {
    loginPage.login('trialUser', 'password');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Informed Consent module', () => {
    dashboardPage.navigateToInformedConsent();
    informedConsentPage.verifyInformedConsentScreenIsDisplayed();
  });

  it('should select participant P002', () => {
    informedConsentPage.selectParticipant('P002');
    participantPage.verifyParticipantDetailsPageIsDisplayed();
  });

  it('should upload consent form CF001', () => {
    participantPage.uploadConsentForm('CF001');
    participantPage.verifyConsentFormUploadSuccess();
  });

  it('should enter consent details', () => {
    participantPage.enterConsentDetails('Dr. Smith', '2023-10-01');
    participantPage.verifyConsentDetailsEnteredSuccess();
  });

  it('should save the consent record', () => {
    participantPage.saveConsentRecord();
    participantPage.verifyConsentRecordSaved();
  });

  it('should navigate back to participant list', () => {
    participantPage.navigateBackToParticipantList();
    informedConsentPage.verifyParticipantListIsDisplayed();
  });

  it('should search and open participant profile', () => {
    informedConsentPage.searchAndOpenParticipantProfile('P002');
    participantPage.verifyParticipantDetailsPageIsDisplayed();
  });

  it('should review uploaded consent form and details', () => {
    participantPage.reviewConsentFormAndDetails();
    participantPage.verifyConsentFormAndDetailsDisplayedCorrectly();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});