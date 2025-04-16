describe('TC-541 411 Access Property Owner Dashboard', () => {
  const dashboardPage = new DashboardPage();

  before(() => {
    cy.loginAsPropertyOwner('O12345');
  });

  it('should navigate to the dashboard', () => {
    dashboardPage.navigateToDashboard();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should display occupancy details when the occupancy filter is selected', () => {
    dashboardPage.selectFilter('Occupancy');
    dashboardPage.verifyOccupancyDetails();
  });

  it('should display rental income details when the rental income filter is selected', () => {
    dashboardPage.selectFilter('Rental Income');
    dashboardPage.verifyRentalIncomeDetails();
  });

  it('should display maintenance requests when the maintenance requests filter is selected', () => {
    dashboardPage.selectFilter('Maintenance Requests');
    dashboardPage.verifyMaintenanceRequests();
  });

  it('should accurately display occupancy statistics for each property', () => {
    dashboardPage.reviewOccupancyStatistics();
  });

  it('should accurately display rental income statistics for each property', () => {
    dashboardPage.reviewRentalIncomeStatistics();
  });

  it('should accurately display maintenance requests categorized by status', () => {
    dashboardPage.reviewMaintenanceRequests();
  });

  it('should access detailed view of a specific property', () => {
    dashboardPage.accessDetailedView('P1');
    dashboardPage.verifyDetailedView('P1');
  });

  after(() => {
    cy.logout();
  });
});