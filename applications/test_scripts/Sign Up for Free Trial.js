describe('Sign Up for Free Trial', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const subscriptionPage = new SubscriptionPage();
  
  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow user to sign up for a 7-day free trial', () => {
    loginPage.login('user@example.com', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.goToSubscriptionProducts();
    subscriptionPage.selectProductById(301);
    subscriptionPage.activateFreeTrial();
    subscriptionPage.verifyTrialStatus('Trial Active');
  });
});