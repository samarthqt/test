describe('Real-Time Shipment Monitoring', () => {
  const loginPage = new LoginPage();
  const shipmentPage = new ShipmentPage();

  before(() => {
    cy.visit('/login');
  });

  it('should allow user to log in', () => {
    loginPage.enterUsername('CUST12345');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Track Shipment section', () => {
    shipmentPage.navigateToTrackShipment();
    shipmentPage.getTrackShipmentSection().should('be.visible');
  });

  it('should display shipment details for SHIP67890', () => {
    shipmentPage.enterShipmentID('SHIP67890');
    shipmentPage.getShipmentDetails().should('be.visible');
  });

  it('should display the current location as Warehouse A', () => {
    shipmentPage.getCurrentLocation().should('contain', 'Warehouse A');
  });

  it('should display the estimated delivery time as 2 hours', () => {
    shipmentPage.getEstimatedDeliveryTime().should('contain', '2 hours');
  });

  it('should update shipment details in real-time upon refresh', () => {
    cy.reload();
    shipmentPage.getShipmentDetails().should('be.visible');
  });

  it('should allow user to log out', () => {
    shipmentPage.logout();
    cy.url().should('include', '/login');
  });
});