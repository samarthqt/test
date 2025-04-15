describe('Analytics Dashboard Access', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow admin users to access the analytics dashboard', () => {
    loginPage.login('admin@example.com', 'password123');
    dashboardPage.navigateToAnalyticsDashboard();
    dashboardPage.verifyKeyAnalyticsMetrics();
  });
});