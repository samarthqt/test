describe('System Load Monitoring Negative Scenario', () => {
  const dashboardPage = new DashboardPage();

  before(() => {
    cy.visit('/login');
    cy.loginAsAdmin();
  });

  it('should not trigger alerts when system load is below the threshold', () => {
    dashboardPage.verifyAdminDashboardDisplayed();
    dashboardPage.setLoadThreshold(80);
    dashboardPage.simulateSystemLoad(75);
    dashboardPage.checkForAlerts();
    dashboardPage.verifyNoAlertsTriggered();
  });

  after(() => {
    dashboardPage.logout();
  });
});