describe('Instructor Dashboard Access', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in to the instructor account', () => {
    loginPage.login('instructor@example.com', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the dashboard section', () => {
    dashboardPage.navigateToDashboard();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should verify the ability to view course analytics', () => {
    dashboardPage.viewCourseAnalytics();
    dashboardPage.verifyCourseAnalyticsDisplayed();
  });

  it('should verify the ability to track student progress', () => {
    dashboardPage.trackStudentProgress();
    dashboardPage.verifyStudentProgressDisplayed();
  });

  it('should verify the ability to provide feedback to students', () => {
    dashboardPage.provideFeedback();
    dashboardPage.verifyFeedbackOptionsAvailable();
  });
});