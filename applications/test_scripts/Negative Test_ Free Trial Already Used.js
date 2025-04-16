describe('Free Trial Already Used Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const subscriptionPage = new SubscriptionPage();

  before(() => {
    cy.visit('/login');
  });

  it('should not allow free trial if already used', () => {
    loginPage.login('user2@example.com', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToSubscriptionProducts();
    subscriptionPage.selectSubscriptionProduct(302);
    subscriptionPage.attemptFreeTrial();
    subscriptionPage.verifyFreeTrialErrorMessage();
  });
});