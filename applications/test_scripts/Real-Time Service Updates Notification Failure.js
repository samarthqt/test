describe('Real-Time Service Updates Notification Failure', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const notificationSettingsPage = new NotificationSettingsPage();
  const notificationsPanel = new NotificationsPanel();

  before(() => {
    cy.visit('/login');
  });

  it('should log in successfully and redirect to dashboard', () => {
    loginPage.login('user123', 'password123');
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to Notification Settings page', () => {
    dashboardPage.goToNotificationSettings();
    notificationSettingsPage.verifyNotificationSettingsPage();
  });

  it('should ensure Service Status Change notifications are disabled', () => {
    notificationSettingsPage.verifyServiceStatusChangeDisabled();
  });

  it('should simulate a change in service status and verify no notifications', () => {
    cy.simulateServiceStatusChange('67890');
    notificationsPanel.verifyNoNewNotifications();
  });

  it('should log out successfully', () => {
    dashboardPage.logout();
  });
});