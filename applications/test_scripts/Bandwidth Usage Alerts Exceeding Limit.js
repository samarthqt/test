describe('TC-221 180 Bandwidth Usage Alerts Exceeding Limit', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const usagePage = new UsagePage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the application with valid user credentials', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyUserLoggedIn();
  });

  it('should navigate to the Usage section in the user dashboard', () => {
    dashboardPage.navigateToUsageSection();
    usagePage.verifyUsageSectionDisplayed();
  });

  it('should simulate data usage to reach 110GB and receive notification alert', () => {
    usagePage.simulateDataUsage(110);
    usagePage.verifyNotificationAlert();
  });
});