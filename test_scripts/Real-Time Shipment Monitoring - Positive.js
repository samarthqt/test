describe('Real-Time Shipment Monitoring', () => {
  const customerID = 'CUST54321';
  const shipmentID = 'SHIP09876';
  const expectedLocation = 'Distribution Center B';
  const expectedDeliveryTime = '3 hours';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Track Shipment section', () => {
    cy.get('#trackShipmentLink').click();
    cy.url().should('include', '/track-shipment');
  });

  it('should display shipment details for SHIP09876', () => {
    cy.get('#shipmentSearchBar').type(shipmentID);
    cy.get('#searchButton').click();
    cy.get('#shipmentDetails').should('be.visible');
  });

  it('should verify current location is Distribution Center B', () => {
    cy.get('#currentLocation').should('have.text', expectedLocation);
  });

  it('should check estimated delivery time is 3 hours', () => {
    cy.get('#estimatedDeliveryTime').should('have.text', expectedDeliveryTime);
  });

  it('should update shipment details in real-time', () => {
    cy.wait(300000); // wait for 5 minutes
    cy.reload();
    cy.get('#currentLocation').should('have.text', expectedLocation);
    cy.get('#estimatedDeliveryTime').should('have.text', expectedDeliveryTime);
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});