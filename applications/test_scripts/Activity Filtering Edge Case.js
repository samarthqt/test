describe('Activity Filtering Edge Case - TC-238 191', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const activityLogsPage = new ActivityLogsPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('validUsername', 'validPassword');
  });

  it('should log in and redirect to the dashboard', () => {
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to the Activity Logs page', () => {
    dashboardPage.goToActivityLogsPage();
    activityLogsPage.verifyActivityLogsPage();
  });

  it('should set date range to Today and activity type to All', () => {
    activityLogsPage.setDateRangeToToday();
    activityLogsPage.setActivityTypeToAll();
  });

  it('should apply filters and verify results', () => {
    activityLogsPage.applyFilters();
    activityLogsPage.verifyFilteredResultsForToday();
  });

  after(() => {
    dashboardPage.logout();
  });
});