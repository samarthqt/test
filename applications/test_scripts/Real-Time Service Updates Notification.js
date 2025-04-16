describe('Real-Time Service Updates Notification', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const notificationSettingsPage = new NotificationSettingsPage();
  const notificationsPanel = new NotificationsPanel();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the system', () => {
    loginPage.login('user123', 'password123');
    dashboardPage.verifyUserIsLoggedIn();
  });

  it('should navigate to Notification Settings and enable Service Status Change notifications', () => {
    dashboardPage.goToNotificationSettings();
    notificationSettingsPage.verifyPageDisplayed();
    notificationSettingsPage.enableServiceStatusChangeNotifications();
  });

  it('should simulate service status change and verify notification', () => {
    cy.simulateServiceStatusChange(67890);
    notificationsPanel.verifyNotificationDisplayed('Service Status Change');
    notificationsPanel.clickNotification('Service Status Change');
    notificationsPanel.verifyNotificationDetails('Service Status Updated');
    notificationsPanel.verifyNotificationTimestamp();
  });

  after(() => {
    dashboardPage.logout();
  });
});