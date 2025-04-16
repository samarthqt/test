describe('Push Notification for Special Offers', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const adminPanel = new AdminPanel();
  const device = new Device();

  before(() => {
    cy.visit('/login');
  });

  it('logs in as a registered user', () => {
    loginPage.enterUsername('registeredUser');
    loginPage.enterPassword('password123');
    loginPage.submit();
    homePage.verifyHomePage();
  });

  it('ensures push notifications are enabled', () => {
    device.verifyPushNotificationsEnabled();
  });

  it('triggers a special offer notification from the admin panel', () => {
    adminPanel.triggerSpecialOfferNotification();
  });

  it('checks the user device for the notification', () => {
    device.verifyNotificationReceived('Get 20% off on your next purchase!');
  });
});