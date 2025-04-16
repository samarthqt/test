describe('TC-837 164 Push Notification for System Updates', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const adminPanel = new AdminPanel();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the application as a registered user', () => {
    loginPage.enterUsername('registeredUser');
    loginPage.enterPassword('password123');
    loginPage.submit();
    homePage.verifyHomePage();
  });

  it('should ensure push notifications are enabled on the device', () => {
    homePage.verifyPushNotificationsEnabled();
  });

  it('should trigger a system update notification from the admin panel', () => {
    adminPanel.triggerSystemUpdateNotification();
  });

  it('should check the user's device for the notification', () => {
    homePage.verifyNotificationReceived('System will be updated at 10 PM.');
  });
});