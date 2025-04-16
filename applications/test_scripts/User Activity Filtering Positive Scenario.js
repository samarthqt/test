describe('User Activity Filtering Positive Scenario', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const activityLogsPage = new ActivityLogsPage();

  before(() => {
    cy.visit('/');
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyUserIsOnDashboard();
  });

  it('should filter activity logs by date and activity type', () => {
    dashboardPage.navigateToActivityLogs();
    activityLogsPage.verifyActivityLogsPageIsDisplayed();
    activityLogsPage.setDateRangeFilter('Last 7 days');
    activityLogsPage.setActivityTypeFilter('Login');
    activityLogsPage.applyFilters();
    activityLogsPage.verifyFilteredResults('Login', 'Last 7 days');
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyUserIsLoggedOut();
  });
});