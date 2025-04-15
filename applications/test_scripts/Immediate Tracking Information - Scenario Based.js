describe('Immediate Tracking Information', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackShipmentPage = new TrackShipmentPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('Should verify immediate tracking information reflecting real-time status', () => {
    loginPage.login('CUST11223', 'validPassword');
    dashboardPage.navigateToTrackShipment();
    trackShipmentPage.enterShipmentID('SHIP44556');
    trackShipmentPage.verifyCurrentStatus('In Transit');
    trackShipmentPage.refreshAndVerifyRealTimeUpdate();
    dashboardPage.logout();
  });
});