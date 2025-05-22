describe('Real-Time Shipment Monitoring - Negative Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackShipmentPage = new TrackShipmentPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should handle invalid shipment IDs gracefully', () => {
    // Step 1: Log in to the customer account using valid credentials
    loginPage.login('CUST98765', 'validPassword');
    dashboardPage.verifyLoginSuccess();

    // Step 2: Navigate to the 'Track Shipment' section
    dashboardPage.goToTrackShipment();
    trackShipmentPage.verifyTrackShipmentSectionDisplayed();

    // Step 3: Enter the Invalid Shipment ID in the search bar
    trackShipmentPage.enterShipmentId('SHIP00000');
    trackShipmentPage.verifyErrorMessageDisplayed('Invalid shipment ID');

    // Step 4: Attempt to refresh the page
    cy.reload();
    trackShipmentPage.verifyErrorMessageDisplayed('Invalid shipment ID');

    // Step 5: Log out of the customer account
    dashboardPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});