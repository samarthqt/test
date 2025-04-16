describe('ATM Locator Error Handling', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const atmLocatorPage = new ATMLocatorPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUserId('54321');
    loginPage.enterPassword('your_password');
    loginPage.clickLogin();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to ATM Locator section', () => {
    dashboardPage.navigateToATMLocator();
    atmLocatorPage.verifyATMLocatorSection();
  });

  it('should fail to search for ATMs with location services disabled', () => {
    atmLocatorPage.searchATMs();
    atmLocatorPage.verifyLocationServicesDisabledError();
  });

  it('should enable location services and search for ATMs successfully', () => {
    atmLocatorPage.enableLocationServices();
    atmLocatorPage.searchATMs();
    atmLocatorPage.verifyATMsDisplayed();
  });
});