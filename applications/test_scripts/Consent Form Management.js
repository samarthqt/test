describe('Consent Form Management', () => {
  const loginPage = new LoginPage();
  const consentFormPage = new ConsentFormPage();
  const participantId = 'PT001';
  const consentFormName = 'CF_Template_01';

  before(() => {
    cy.visit('/login');
  });

  it('should log in as an administrator', () => {
    loginPage.login('admin', 'password');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Consent Forms module', () => {
    consentFormPage.navigateToConsentFormsModule();
    cy.get(consentFormPage.consentFormsModule).should('be.visible');
  });

  it('should upload a new consent form', () => {
    consentFormPage.selectUploadConsentForm();
    cy.get(consentFormPage.uploadInterface).should('be.visible');
    consentFormPage.enterParticipantId(participantId);
    consentFormPage.uploadConsentForm(consentFormName);
    cy.get(consentFormPage.consentFormDetails).should('contain', consentFormName);
  });

  it('should submit the consent form for storage', () => {
    consentFormPage.submitConsentForm();
    cy.get(consentFormPage.storageConfirmation).should('be.visible');
  });

  it('should verify the consent form in participant history', () => {
    consentFormPage.navigateToParticipantHistory(participantId);
    cy.get(consentFormPage.historyList).should('contain', consentFormName);
  });

  after(() => {
    loginPage.logout();
    cy.url().should('include', '/login');
  });
});