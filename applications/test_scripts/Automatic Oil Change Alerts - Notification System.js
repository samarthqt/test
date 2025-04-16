describe('Automatic Oil Change Alerts - Notification System', () => {
  const maintenancePage = new MaintenancePage();

  beforeEach(() => {
    cy.visit('/');
    maintenancePage.login();
  });

  it('should verify users receive notifications for oil change based on time or mileage', () => {
    maintenancePage.navigateToOilChangeAlerts();
    maintenancePage.enterVehicleDetails('V123', '2023-01-01', '5000');
    maintenancePage.submitVehicleDetails();

    maintenancePage.simulateMileageThreshold();
    maintenancePage.verifyNotificationContent('mileage');

    maintenancePage.simulateTimeThreshold();
    maintenancePage.verifyNotificationContent('time');

    maintenancePage.acknowledgeNotification();
    maintenancePage.navigateToNotificationHistory();
    maintenancePage.verifyNotificationHistoryContent();
  });

  afterEach(() => {
    maintenancePage.logout();
  });

  it('should retain notification settings after logging out and back in', () => {
    maintenancePage.logout();
    maintenancePage.login();
    maintenancePage.verifyNotificationSettings();
  });
});