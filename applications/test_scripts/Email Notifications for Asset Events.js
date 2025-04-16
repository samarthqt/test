describe('Email Notifications for Asset Events', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const notificationsPage = new NotificationsPage();
  const emailClient = new EmailClient();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the asset management system', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Notifications module', () => {
    dashboardPage.goToNotifications();
    notificationsPage.verifyNotificationsPage();
  });

  it('should select the Email Alerts sub-module', () => {
    notificationsPage.selectEmailAlerts();
    notificationsPage.verifyEmailAlertsOptions();
  });

  it('should verify email notifications are enabled for Maintenance Due events', () => {
    notificationsPage.verifyEmailNotificationEnabled('Maintenance Due');
  });

  it('should trigger a Maintenance Due event for an asset', () => {
    notificationsPage.triggerMaintenanceDueEvent();
  });

  it('should check the user email inbox for a notification', () => {
    emailClient.checkInbox('user@example.com', 'Maintenance Due');
  });

  it('should verify the content of the email notification', () => {
    emailClient.verifyEmailContent('user@example.com', 'Maintenance Due', {
      assetDetails: true,
      dueDate: true
    });
  });

  it('should attempt to disable email notifications for Maintenance Due events', () => {
    notificationsPage.disableEmailNotification('Maintenance Due');
    notificationsPage.verifyEmailNotificationDisabled('Maintenance Due');
  });

  after(() => {
    dashboardPage.logout();
  });
});