describe('Feedback Submission with Missing Details', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const feedbackPage = new FeedbackPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as a tenant', () => {
    loginPage.enterUsername('tenant_username');
    loginPage.enterPassword('tenant_password');
    loginPage.submit();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to the Feedback section', () => {
    dashboardPage.navigateToFeedback();
    feedbackPage.verifyFeedbackInterfaceDisplayed();
  });

  it('should attempt to submit feedback with empty details', () => {
    feedbackPage.submitFeedback('');
    feedbackPage.verifyErrorMessageDisplayed('Feedback details are required.');
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});