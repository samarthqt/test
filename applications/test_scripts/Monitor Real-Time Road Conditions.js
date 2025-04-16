describe('Monitor Real-Time Road Conditions', () => {
  const navigationPage = new NavigationPage();

  before(() => {
    // Ensure GPS is enabled on the device
    cy.enableGPS();
  });

  it('should navigate to Navigation module', () => {
    navigationPage.navigateToNavigationModule();
    navigationPage.verifyNavigationScreen();
  });

  it('should enter Start Location as Central Park', () => {
    navigationPage.enterStartLocation('Central Park');
    navigationPage.verifyStartLocation('Central Park');
  });

  it('should enter Destination as Times Square', () => {
    navigationPage.enterDestination('Times Square');
    navigationPage.verifyDestination('Times Square');
  });

  it('should get directions and display the route', () => {
    navigationPage.clickGetDirections();
    navigationPage.verifyRouteDisplayed();
  });

  it('should monitor road conditions in real-time', () => {
    navigationPage.verifyRealTimeAlerts();
  });

  it('should not display any error messages or warnings', () => {
    navigationPage.verifyNoErrorMessages();
  });

  after(() => {
    navigationPage.logout();
  });
});