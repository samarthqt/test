describe('Immediate Tracking Information - Negative Test', () => {
  const loginPage = new LoginPage();
  const trackShipmentPage = new TrackShipmentPage();
  const accountPage = new AccountPage();

  it('should test the system response to invalid tracking requests', () => {
    cy.visit('/login');

    // Step 1: Log in to the customer account
    loginPage.login('CUST55667', 'validPassword');
    accountPage.verifyLoginSuccess();

    // Step 2: Navigate to the 'Track Shipment' section
    accountPage.navigateToTrackShipment();
    trackShipmentPage.verifyTrackShipmentSectionDisplayed();

    // Step 3: Enter the Invalid Shipment ID
    trackShipmentPage.enterShipmentID('SHIP99999');
    trackShipmentPage.verifyInvalidShipmentIDError();

    // Step 4: Attempt to refresh the page
    cy.reload();
    trackShipmentPage.verifyInvalidShipmentIDError();

    // Step 5: Log out of the customer account
    accountPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});