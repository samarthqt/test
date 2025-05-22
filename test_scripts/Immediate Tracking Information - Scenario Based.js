describe('Immediate Tracking Information - Scenario Based', () => {
  const customerId = 'CUST11223';
  const shipmentId = 'SHIP44556';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type(customerId);
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Track Shipment section', () => {
    cy.get('#trackShipment').click();
    cy.url().should('include', '/track-shipment');
  });

  it('should enter Shipment ID and display shipment details', () => {
    cy.get('#shipmentSearchBar').type(shipmentId);
    cy.get('#searchButton').click();
    cy.get('#shipmentDetails').should('contain', shipmentId);
  });

  it('should verify the current status of the shipment is In Transit', () => {
    cy.get('#currentStatus').should('contain', 'In Transit');
  });

  it('should check if tracking information updates immediately upon refresh', () => {
    cy.reload();
    cy.get('#currentStatus').should('contain', 'In Transit');
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});