describe('Service Updates Notification Edge Case', () => {
  const notificationSettingsPage = new NotificationSettingsPage();
  const dashboardPage = new DashboardPage();
  const loginPage = new LoginPage();
  const notificationsPanel = new NotificationsPanel();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the system', () => {
    loginPage.login('user12345', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Notification Settings page', () => {
    notificationSettingsPage.navigateTo();
    notificationSettingsPage.verifyPage();
  });

  it('should ensure Service Status Change notifications are enabled', () => {
    notificationSettingsPage.enableServiceStatusChangeNotifications();
    notificationSettingsPage.verifyServiceStatusChangeEnabled();
  });

  it('should simulate simultaneous changes in service status', () => {
    cy.simulateServiceStatusChanges([67890, 67891, 67892]);
  });

  it('should check the notifications panel for new alerts', () => {
    notificationsPanel.open();
    notificationsPanel.verifyNotifications([67890, 67891, 67892]);
  });

  it('should verify the order and timestamp of the notifications', () => {
    notificationsPanel.verifyOrderAndTimestamps();
  });

  after(() => {
    dashboardPage.logout();
  });
});