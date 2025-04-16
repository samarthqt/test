describe('Vehicle Health Score Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const vehicleHealthPage = new VehicleHealthPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display the correct health score for vehicle ID 123ABC', () => {
    // Step 1: Log in to the system
    loginPage.login('user@example.com', 'password');
    dashboardPage.verifyDashboardPage();

    // Step 2: Navigate to Vehicle Health Score section
    dashboardPage.navigateToVehicleHealthScore();
    vehicleHealthPage.verifyVehicleHealthPage();

    // Step 3: Select vehicle with ID 123ABC
    vehicleHealthPage.selectVehicle('123ABC');

    // Step 4: View health score
    vehicleHealthPage.verifyHealthScoreDisplay();

    // Step 5: Verify accuracy of health score
    vehicleHealthPage.verifyHealthScoreAccuracy(85, 90, 80);

    // Step 6: Log out
    dashboardPage.logout();
  });
});