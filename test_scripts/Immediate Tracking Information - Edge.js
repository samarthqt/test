describe('Immediate Tracking Information - Edge Case', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackShipmentPage = new TrackShipmentPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should handle long shipment ID gracefully', () => {
    // Step 1: Log in to the customer account using valid credentials
    loginPage.login('CUST77889', 'validPassword');
    dashboardPage.verifySuccessfulLogin();

    // Step 2: Navigate to the 'Track Shipment' section
    dashboardPage.goToTrackShipment();
    trackShipmentPage.verifyTrackShipmentPage();

    // Step 3: Enter the Long Shipment ID in the search bar
    trackShipmentPage.enterShipmentID('SHIP12345678901234567890');

    // Step 4: Check if the system provides any feedback or error message for the long ID
    trackShipmentPage.verifySystemFeedback();

    // Step 5: Log out of the customer account
    dashboardPage.logout();
    loginPage.verifySuccessfulLogout();
  });
});