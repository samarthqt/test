describe('Immediate Tracking Information - Positive', () => {
  const customerId = 'CUST33445';
  const shipmentId = 'SHIP66778';
  const expectedStatus = 'Out for Delivery';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type(customerId);
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
  });

  it('should navigate to Track Shipment section', () => {
    cy.get('#trackShipmentLink').click();
    cy.url().should('include', '/track-shipment');
  });

  it('should display shipment details for SHIP66778', () => {
    cy.get('#shipmentSearchBar').type(shipmentId);
    cy.get('#searchButton').click();
    cy.get('#shipmentDetails').should('contain', shipmentId);
  });

  it('should verify current status is Out for Delivery', () => {
    cy.get('#currentStatus').should('contain', expectedStatus);
  });

  it('should refresh and check for immediate updates', () => {
    cy.reload();
    cy.get('#currentStatus').should('contain', expectedStatus);
  });

  after(() => {
    cy.get('#logoutButton').click();
  });
});