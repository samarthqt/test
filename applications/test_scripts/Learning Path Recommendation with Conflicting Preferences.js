describe('Learning Path Recommendation with Conflicting Preferences', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const learningPathsPage = new LearningPathsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in and navigate to the dashboard', () => {
    loginPage.enterCredentials('11223', 'password');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Learning Paths section', () => {
    dashboardPage.goToLearningPaths();
    learningPathsPage.verifyLearningPathsSection();
  });

  it('should check for recommendations based on conflicting preferences', () => {
    learningPathsPage.verifyRecommendations('Course X in Science', 'Interest in Arts');
  });

  it('should verify the option to prioritize preferences over completed courses', () => {
    learningPathsPage.verifyPreferencePrioritizationOption();
  });
});