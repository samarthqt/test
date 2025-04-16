describe('ATM Locator Functionality', () => {
  const servicesPage = new ServicesPage();
  const atmLocatorPage = new ATMLocatorPage();

  before(() => {
    cy.visit('/login');
    servicesPage.login('12345');
  });

  it('should navigate to ATM Locator section', () => {
    servicesPage.navigateToATMLocator();
    atmLocatorPage.verifyATMSectionDisplayed();
  });

  it('should enable location services', () => {
    atmLocatorPage.enableLocationServices();
    atmLocatorPage.verifyLocationServicesEnabled();
  });

  it('should search for ATMs using current location', () => {
    atmLocatorPage.searchATMs();
    atmLocatorPage.verifyATMsDisplayedOnMap();
  });

  it('should select an ATM and view details', () => {
    atmLocatorPage.selectATM();
    atmLocatorPage.verifyATMDetailsDisplayed();
  });

  it('should verify the accuracy of ATM location on the map', () => {
    atmLocatorPage.verifyATMLocationAccuracy();
  });
});