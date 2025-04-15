describe('Real-Time Shipment Monitoring - Edge Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackShipmentPage = new TrackShipmentPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('CUST24680', 'validPassword');
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to Track Shipment section', () => {
    dashboardPage.navigateToTrackShipment();
    trackShipmentPage.verifyTrackShipmentPage();
  });

  it('should handle long Shipment ID gracefully', () => {
    trackShipmentPage.enterShipmentId('SHIP12345678901234567890');
    trackShipmentPage.verifyLongIdHandling();
  });

  it('should log out successfully', () => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});