describe('Terms of Service Update Notification', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const settingsPage = new SettingsPage();
  const adminPanelPage = new AdminPanelPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in successfully', () => {
    loginPage.login('33445', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Notifications section', () => {
    dashboardPage.goToSettings();
    settingsPage.navigateToNotifications();
    settingsPage.verifyUserOptedInForNotifications('termsupdateuser@example.com');
  });

  it('should update terms of service in admin panel', () => {
    adminPanelPage.loginAsAdmin('adminUser', 'adminPassword');
    adminPanelPage.updateTermsOfService();
    adminPanelPage.verifyTermsUpdated();
  });

  it('should verify email and app alert notifications', () => {
    settingsPage.verifyEmailNotification('termsupdateuser@example.com');
    settingsPage.verifyAppAlertNotification();
  });

  it('should log out and log back in', () => {
    dashboardPage.logout();
    loginPage.login('33445', 'validPassword');
    dashboardPage.verifyDashboardNotification();
  });

  it('should redirect to updated terms of service page', () => {
    dashboardPage.clickTermsUpdateNotification();
    dashboardPage.verifyUpdatedTermsOfService();
  });
});