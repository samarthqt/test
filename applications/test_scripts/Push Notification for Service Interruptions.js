describe('Push Notification for Service Interruptions', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const adminPanel = new AdminPanel();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as a registered user', () => {
    loginPage.enterUsername('registeredUser');
    loginPage.enterPassword('password123');
    loginPage.submit();
    homePage.verifyHomePage();
  });

  it('should ensure push notifications are enabled', () => {
    cy.checkPushNotificationSettings().should('be.enabled');
  });

  it('should trigger a service interruption notification', () => {
    adminPanel.triggerServiceInterruption();
  });

  it('should receive a push notification', () => {
    cy.waitForPushNotification('Service is temporarily unavailable.');
  });
});