describe('Service Availability Monitoring', () => {
  const dashboardPage = new DashboardPage();

  before(() => {
    cy.visit('/login');
    dashboardPage.login('validUsername', 'validPassword');
  });

  it('should display dashboard with real-time service status', () => {
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Service Availability section', () => {
    dashboardPage.navigateToServiceAvailability();
    dashboardPage.verifyServiceStatusIsDisplayed();
  });

  it('should select a specific service and view detailed availability information', () => {
    dashboardPage.selectService('S001');
    dashboardPage.verifyDetailedServiceStatus();
  });

  it('should verify the accuracy of the displayed service status', () => {
    dashboardPage.verifyServiceStatusAccuracy();
  });

  it('should simulate service downtime and check status update', () => {
    dashboardPage.simulateServiceDowntime();
    dashboardPage.verifyServiceStatusIsDown();
  });

  after(() => {
    dashboardPage.logout();
  });
});