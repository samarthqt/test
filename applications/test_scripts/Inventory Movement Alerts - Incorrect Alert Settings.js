describe('Inventory Movement Alerts - Incorrect Alert Settings', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const movementAlertsPage = new MovementAlertsPage();
  const alertsSection = new AlertsSection();

  before(() => {
    cy.visit('/');
  });

  it('should log in and navigate to the Movement Alerts module', () => {
    loginPage.login('USR001', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToMovementAlerts();
    movementAlertsPage.verifyMovementAlertsPage();
  });

  it('should monitor inventory movement with incorrect alert settings', () => {
    movementAlertsPage.selectMonitorInventoryMovement();
    movementAlertsPage.moveProductWithAlertOff('PROD002');
    alertsSection.verifyNoAlertNotification();
  });

  it('should adjust alert settings to correct configuration', () => {
    movementAlertsPage.adjustAlertSettings();
    movementAlertsPage.verifyAlertSettingsCorrected();
  });

  after(() => {
    dashboardPage.logout();
  });
});