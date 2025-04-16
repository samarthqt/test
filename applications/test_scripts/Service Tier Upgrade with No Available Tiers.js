describe('Service Tier Upgrade with No Available Tiers', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const subscriptionPage = new SubscriptionPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the application with valid user credentials', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to the Subscription section', () => {
    dashboardPage.goToSubscriptionSection();
    subscriptionPage.verifyCurrentTier('Enterprise');
  });

  it('should display message when no higher service tiers are available', () => {
    subscriptionPage.clickUpgradeButton();
    subscriptionPage.verifyNoHigherTierMessage();
  });
});