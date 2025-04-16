describe('Health Tips and Notifications Functionality', () => {
  const loginPage = new LoginPage();
  const notificationsPage = new NotificationsPage();
  const medicalProfilePage = new MedicalProfilePage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the system and navigate to the Notifications module', () => {
    loginPage.login('patient_username', 'patient_password');
    notificationsPage.navigate();
    notificationsPage.verifyNotificationsInterface();
  });

  it('should ensure the medical profile is complete with Diabetes listed', () => {
    medicalProfilePage.navigate();
    medicalProfilePage.verifyMedicalProfile('Diabetes');
  });

  it('should set notification preference to Email', () => {
    notificationsPage.setNotificationPreference('Email');
    notificationsPage.verifyNotificationPreference('Email');
  });

  it('should trigger a health tip generation event and verify email receipt', () => {
    notificationsPage.triggerHealthTipEvent();
    notificationsPage.verifyHealthTipEmail('Diabetes');
  });

  after(() => {
    loginPage.logout();
  });
});