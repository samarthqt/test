describe('Email Notification for Scheduled Maintenance', () => {
  const adminPage = new AdminPage();
  const userPage = new UserPage();

  before(() => {
    // Setup necessary preconditions
    cy.loginAsAdmin();
  });

  it('should ensure the user email is registered', () => {
    userPage.navigateToUserProfile();
    userPage.verifyEmailIsRegistered();
  });

  it('should ensure email notifications are enabled', () => {
    userPage.verifyEmailNotificationsEnabled();
  });

  it('should trigger scheduled maintenance notification', () => {
    adminPage.triggerScheduledMaintenanceNotification();
  });

  it('should check user email inbox for the notification', () => {
    cy.checkEmailInbox('Scheduled maintenance on 12th Oct from 2 AM to 4 AM.');
  });

  after(() => {
    // Teardown steps if necessary
    cy.logout();
  });
});