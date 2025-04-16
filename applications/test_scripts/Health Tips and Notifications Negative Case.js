describe('Health Tips and Notifications Negative Case', () => {
  const loginPage = new LoginPage();
  const notificationsPage = new NotificationsPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.login('username', 'password');
  });

  it('should handle incomplete medical profile', () => {
    notificationsPage.navigateToNotifications();
    notificationsPage.verifyNotificationsInterfaceDisplayed();
    notificationsPage.checkMedicalProfileCompleteness();
    notificationsPage.verifyMedicalProfileIncomplete();
    notificationsPage.triggerHealthTipGeneration();
    notificationsPage.verifyIncompleteProfileMessage();
  });

  afterEach(() => {
    notificationsPage.logout();
  });
});