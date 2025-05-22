describe('Immediate Tracking Information - Negative Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackShipmentPage = new TrackShipmentPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the customer account', () => {
    loginPage.login('CUST55667', 'validPassword');
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to the Track Shipment section', () => {
    dashboardPage.goToTrackShipment();
    trackShipmentPage.verifyTrackShipmentSection();
  });

  it('should display error message for invalid shipment ID', () => {
    trackShipmentPage.enterShipmentId('SHIP99999');
    trackShipmentPage.verifyErrorMessage('Invalid shipment ID');
  });

  it('should persist error message after page refresh', () => {
    cy.reload();
    trackShipmentPage.verifyErrorMessage('Invalid shipment ID');
  });

  it('should log out of the customer account', () => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});