describe('Push Notifications for Key Events', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const notificationsPage = new NotificationsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('password');
    loginPage.clickLogin();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Notifications module', () => {
    dashboardPage.navigateToNotifications();
    notificationsPage.verifyNotificationsSection();
  });

  it('should ensure push notifications are enabled', () => {
    notificationsPage.ensurePushNotificationsEnabled();
  });

  it('should perform a payment transaction and receive notification', () => {
    notificationsPage.performPaymentTransaction();
    notificationsPage.verifyNotificationReceived('Payment');
  });

  it('should perform a transfer transaction and receive notification', () => {
    notificationsPage.performTransferTransaction();
    notificationsPage.verifyNotificationReceived('Transfer');
  });

  it('should log in from a different device and receive notification', () => {
    notificationsPage.loginFromDifferentDevice();
    notificationsPage.verifyNotificationReceived('Login');
  });

  it('should update account balance and receive notification', () => {
    notificationsPage.updateAccountBalance();
    notificationsPage.verifyNotificationReceived('Balance Update');
  });

  it('should review received notifications for accuracy', () => {
    notificationsPage.reviewNotifications();
  });

  it('should log out and verify no notifications received when logged out', () => {
    dashboardPage.logout();
    notificationsPage.attemptReceiveNotifications();
  });

  it('should log back in and review notification history', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('password');
    loginPage.clickLogin();
    notificationsPage.reviewNotificationHistory();
  });

  it('should disable push notifications and verify no notifications received', () => {
    notificationsPage.disablePushNotifications();
    notificationsPage.performTransaction();
    notificationsPage.verifyNoNotificationReceived();
  });

  it('should enable push notifications and verify notifications received', () => {
    notificationsPage.enablePushNotifications();
    notificationsPage.performTransaction();
    notificationsPage.verifyNotificationReceived();
  });

  it('should perform multiple transactions and verify notifications', () => {
    notificationsPage.performMultipleTransactions();
    notificationsPage.verifyMultipleNotificationsReceived();
  });

  it('should check notification delivery during peak hours', () => {
    notificationsPage.checkNotificationDeliveryPeakHours();
  });
});