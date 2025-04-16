describe('Invalid Activity Data Display', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const activityInsightsPage = new ActivityInsightsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the analytics module', () => {
    loginPage.enterUsername('U12345');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.verifyDashboardIsAccessible();
  });

  it('should navigate to the activity insights section', () => {
    dashboardPage.navigateToActivityInsights();
    activityInsightsPage.verifyActivityOptionsDisplayed();
  });

  it('should display an error message for corrupted activity data', () => {
    activityInsightsPage.selectGraphicalRepresentationOption();
    activityInsightsPage.verifyErrorMessageForCorruptedData();
  });

  it('should not display graphical representation and prompt user to resolve data issues', () => {
    activityInsightsPage.attemptToViewGraphicalRepresentation();
    activityInsightsPage.verifyGraphicalNotDisplayed();
    activityInsightsPage.verifyUserPromptedToResolveDataIssues();
  });
});