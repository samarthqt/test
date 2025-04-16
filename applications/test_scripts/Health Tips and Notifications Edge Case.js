describe('Health Tips and Notifications Edge Case Test', () => {
  const loginPage = new LoginPage();
  const notificationsPage = new NotificationsPage();

  before(() => {
    cy.visit('/');
    loginPage.login('patientUser', 'patientPassword');
  });

  it('should navigate to Notifications module and verify interface', () => {
    notificationsPage.navigateToNotifications();
    notificationsPage.verifyNotificationsInterface();
  });

  it('should verify medical profile contains Hypertension', () => {
    notificationsPage.verifyMedicalProfile('Hypertension');
  });

  it('should set notification preferences to Email, SMS, and App Notification', () => {
    notificationsPage.setNotificationPreferences(['Email', 'SMS', 'App Notification']);
  });

  it('should trigger a health tip generation event', () => {
    notificationsPage.triggerHealthTipEvent();
  });

  it('should verify health tip is sent via all selected notification methods', () => {
    notificationsPage.verifyHealthTipSent(['Email', 'SMS', 'App Notification']);
  });

  after(() => {
    loginPage.logout();
  });
});