describe('Immediate Tracking Information - Edge Case', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackShipmentPage = new TrackShipmentPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should handle boundary conditions with tracking information', () => {
    // Log in to the customer account
    loginPage.login('CUST77889', 'validPassword');
    dashboardPage.verifyUserIsLoggedIn();

    // Navigate to the 'Track Shipment' section
    dashboardPage.navigateToTrackShipment();
    trackShipmentPage.verifyTrackShipmentSectionIsDisplayed();

    // Enter the Long Shipment ID
    const longShipmentID = 'SHIP12345678901234567890';
    trackShipmentPage.enterShipmentID(longShipmentID);
    trackShipmentPage.verifySystemProcessesInputWithoutErrors();

    // Check for feedback or error message
    trackShipmentPage.verifyFeedbackOrErrorMessageForLongID();

    // Log out of the customer account
    dashboardPage.logout();
    loginPage.verifyUserIsLoggedOut();
  });
});