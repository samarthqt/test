describe('Real-Time Shipment Monitoring', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const shipmentTrackingPage = new ShipmentTrackingPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUsername('CUST54321');
    loginPage.enterPassword('password123');
    loginPage.clickLogin();
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to Track Shipment section', () => {
    dashboardPage.navigateToTrackShipment();
    shipmentTrackingPage.verifyTrackShipmentPage();
  });

  it('should display shipment details for SHIP09876', () => {
    shipmentTrackingPage.enterShipmentID('SHIP09876');
    shipmentTrackingPage.verifyShipmentDetailsDisplayed();
    shipmentTrackingPage.verifyCurrentLocation('Distribution Center B');
    shipmentTrackingPage.verifyEstimatedDeliveryTime('3 hours');
  });

  it('should update shipment details in real-time', () => {
    cy.wait(300000); // Wait for 5 minutes
    cy.reload();
    shipmentTrackingPage.verifyRealTimeUpdates();
  });

  it('should log out of the customer account', () => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});