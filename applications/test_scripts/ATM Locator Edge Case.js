describe('ATM Locator Edge Case', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const atmLocatorPage = new ATMLocatorPage();

  before(() => {
    cy.visit('/login');
  });

  it('should login successfully with valid credentials', () => {
    loginPage.enterUserId('67890');
    loginPage.enterPassword('password123');
    loginPage.submit();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to ATM Locator section', () => {
    dashboardPage.navigateToATMLocator();
    atmLocatorPage.verifyATMLocatorDisplayed();
  });

  it('should enable location services if not enabled', () => {
    atmLocatorPage.enableLocationServices();
    atmLocatorPage.verifyLocationServicesEnabled();
  });

  it('should search for ATMs in a remote area', () => {
    atmLocatorPage.searchRemoteATMs();
    atmLocatorPage.verifyATMsDisplayed();
  });

  it('should verify ATM location accuracy on map', () => {
    atmLocatorPage.verifyATMAccuracy();
  });
});