describe('In-App Notification for Unplanned Downtime', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const settingsPage = new SettingsPage();
  const adminPanel = new AdminPanel();

  before(() => {
    cy.visit('/');
  });

  it('logs in as a registered user', () => {
    loginPage.login('registeredUser', 'password');
    homePage.verifyHomeScreen();
  });

  it('ensures in-app notifications are enabled', () => {
    homePage.goToSettings();
    settingsPage.enableInAppNotifications();
    settingsPage.verifyInAppNotificationsEnabled();
  });

  it('triggers an unplanned downtime notification', () => {
    adminPanel.triggerUnplannedDowntimeNotification();
  });

  it('checks for the unplanned downtime notification', () => {
    homePage.verifyNotification('Unplanned downtime, expected resolution in 2 hours.');
  });
});