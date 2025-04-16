describe('Vehicle Theft Detection and Alerts', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const vehiclePage = new VehiclePage();
  const notificationPage = new NotificationPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in to the system with user credentials', () => {
    loginPage.login('user@example.com', 'password');
    dashboardPage.verifyDashboardPage();
  });

  it('should simulate unauthorized movement of the vehicle and detect it', () => {
    dashboardPage.navigateToVehiclePage();
    vehiclePage.simulateUnauthorizedMovement('123ABC');
    vehiclePage.verifyUnauthorizedMovementDetected();
  });

  it('should trigger a theft alert for unauthorized vehicle movement', () => {
    vehiclePage.verifyTheftAlertTriggered();
  });

  it('should receive a notification alerting of suspicious vehicle activity', () => {
    notificationPage.verifyNotificationReceived('Unauthorized Movement');
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
    loginPage.verifyLoginPage();
  });
});