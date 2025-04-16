describe('Lease Expiry Notifications', () => {
  const leaseManagementPage = new LeaseManagementPage();
  const expiryNotificationsPage = new ExpiryNotificationsPage();

  before(() => {
    cy.login('tenant@example.com', 'password');
  });

  it('should notify tenants and landlords about upcoming lease expirations', () => {
    leaseManagementPage.navigateToLeaseManagement();
    leaseManagementPage.verifyDashboardDisplayed();

    leaseManagementPage.selectExpiryNotifications();
    expiryNotificationsPage.verifyInterfaceDisplayed();

    expiryNotificationsPage.checkNotificationSettings();
    expiryNotificationsPage.simulateDate('2023-11-01');

    expiryNotificationsPage.runNotificationJob();
    expiryNotificationsPage.verifyTenantEmailReceived('Lease expiry notice for Property ID 12345');
    expiryNotificationsPage.verifyLandlordEmailReceived('Lease expiry notice for Property ID 12345');

    expiryNotificationsPage.checkNotificationLogs();
  });

  after(() => {
    cy.logout();
  });
});