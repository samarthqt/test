describe('Real-Time Notifications for Updates', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const notificationSettingsPage = new NotificationSettingsPage();
  const notificationsPage = new NotificationsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('validUser', 'validPassword');
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to notification settings', () => {
    dashboardPage.goToNotificationSettings();
    notificationSettingsPage.verifySettingsPageDisplayed();
  });

  it('should ensure all notification types are enabled', () => {
    notificationSettingsPage.enableAllNotifications();
    notificationSettingsPage.verifyAllNotificationsEnabled();
  });

  it('should simulate a price drop event', () => {
    notificationSettingsPage.simulatePriceDrop('XYZ');
    notificationsPage.verifyNotificationSent();
  });

  it('should open and verify the notification', () => {
    notificationsPage.openNotification();
    notificationsPage.verifyNotificationContent('Price drop for item XYZ');
    notificationsPage.verifyNotificationTimestamp();
    notificationsPage.verifyNotificationUnread();
  });

  it('should mark notification as read', () => {
    notificationsPage.markNotificationAsRead();
    notificationsPage.verifyNotificationRead();
  });

  it('should navigate back to dashboard', () => {
    notificationsPage.goToDashboard();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should verify no unread notifications', () => {
    dashboardPage.verifyNoUnreadNotifications();
  });

  it('should log out', () => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});