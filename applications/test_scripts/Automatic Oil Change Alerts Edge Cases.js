describe('Automatic Oil Change Alerts Edge Cases', () => {
  const maintenancePage = new MaintenancePage();
  const oilChangeAlertsPage = new OilChangeAlertsPage();
  const notificationHistoryPage = new NotificationHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('should launch the maintenance management application', () => {
    maintenancePage.verifyMainScreen();
  });

  it('should navigate to Oil Change Alerts section', () => {
    maintenancePage.navigateToOilChangeAlerts();
    oilChangeAlertsPage.verifyDashboard();
  });

  it('should enter vehicle ID and set details', () => {
    oilChangeAlertsPage.enterVehicleID('V123');
    oilChangeAlertsPage.setLastOilChangeDate('2023-01-01');
    oilChangeAlertsPage.setCurrentMileage('5000');
  });

  it('should submit vehicle details and verify confirmation', () => {
    oilChangeAlertsPage.submitDetails();
    oilChangeAlertsPage.verifyConfirmation();
  });

  it('should simulate mileage threshold and verify notification', () => {
    oilChangeAlertsPage.simulateMileageThreshold();
    oilChangeAlertsPage.verifyNotificationContent();
  });

  it('should simulate time threshold and verify notification', () => {
    oilChangeAlertsPage.simulateTimeThreshold();
    oilChangeAlertsPage.verifyNotificationContent();
  });

  it('should acknowledge notification', () => {
    oilChangeAlertsPage.acknowledgeNotification();
  });

  it('should verify notification in history', () => {
    maintenancePage.navigateToNotificationHistory();
    notificationHistoryPage.verifyNotificationInHistory();
  });

  it('should log out and verify notification settings after relogin', () => {
    maintenancePage.logout();
    maintenancePage.login();
    maintenancePage.verifyNotificationSettings();
  });
});