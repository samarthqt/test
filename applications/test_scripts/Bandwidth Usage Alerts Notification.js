describe('TC-220 180 Bandwidth Usage Alerts Notification', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const usagePage = new UsagePage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the application with valid user credentials', () => {
    loginPage.enterUsername('validUser');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to the Usage section in the user dashboard', () => {
    dashboardPage.goToUsageSection();
    usagePage.verifyUsageSectionLoaded();
  });

  it('should simulate data usage to reach 90GB and receive a notification', () => {
    usagePage.simulateDataUsage(90);
    usagePage.verifyNotificationReceived();
  });
});