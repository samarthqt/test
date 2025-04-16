describe('Push Notification Failure Due to Disabled Notifications', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const adminPanelPage = new AdminPanelPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('registeredUser', 'password');
    homePage.verifyHomeScreen();
  });

  it('should not receive push notifications if they are disabled', () => {
    // Assume push notifications are disabled on the device
    cy.log('Ensure push notifications are disabled in the device settings');

    // Trigger a system update notification from the admin panel
    cy.visit('/admin');
    adminPanelPage.triggerSystemUpdateNotification();

    // Check the user's device for the notification
    cy.log('Check the user's device for the notification');
    cy.get('body').should('not.contain', 'System will be updated at 10 PM.');
  });
});