describe('Service Tier Upgrade with Invalid Credentials', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display an error message for invalid login credentials', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('incorrect');
    loginPage.submit();

    loginPage.getErrorMessage().should('contain', 'incorrect login details');
  });

  it('should not allow access to Subscription section due to login failure', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('incorrect');
    loginPage.submit();

    dashboardPage.navigateToSubscription();
    dashboardPage.getSubscriptionSection().should('not.exist');
  });
});