describe('Inventory Movement Alerts', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const movementAlertsPage = new MovementAlertsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the inventory management system', () => {
    loginPage.login('USR001');
    dashboardPage.verifyUserLoggedIn();
  });

  it('should navigate to the Movement Alerts module', () => {
    dashboardPage.navigateToMovementAlerts();
    movementAlertsPage.verifyMovementAlertsModuleDisplayed();
  });

  it('should select Monitor Inventory Movement option', () => {
    movementAlertsPage.selectMonitorInventoryMovement();
    movementAlertsPage.verifyMonitoringScreenDisplayed();
  });

  it('should move product to incorrect location and verify alert', () => {
    movementAlertsPage.moveProductToIncorrectLocation('PROD001', 'LOC_INVALID');
    movementAlertsPage.verifyAlertNotification();
  });

  it('should take corrective action and resolve alert', () => {
    movementAlertsPage.moveProductToCorrectLocation('PROD001');
    movementAlertsPage.verifyAlertResolved();
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
    loginPage.verifyUserLoggedOut();
  });
});