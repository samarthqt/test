describe('Real-Time Shipment Monitoring', () => {
  const customerId = 'CUST12345';
  const shipmentId = 'SHIP67890';
  const expectedLocation = 'Warehouse A';
  const expectedDeliveryTime = '2 hours';

  beforeEach(() => {
    cy.visit('/login');
    cy.login(customerId, 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should allow customers to monitor their shipments in real-time', () => {
    // Navigate to Track Shipment
    cy.get('nav').contains('Track Shipment').click();
    cy.url().should('include', '/track-shipment');

    // Enter Shipment ID
    cy.get('#shipment-search').type(shipmentId);
    cy.get('#search-button').click();

    // Verify Shipment Details
    cy.get('.shipment-details').within(() => {
      cy.contains('Current Location').next().should('have.text', expectedLocation);
      cy.contains('Estimated Delivery Time').next().should('have.text', expectedDeliveryTime);
    });

    // Refresh and verify real-time updates
    cy.reload();
    cy.get('.shipment-details').within(() => {
      cy.contains('Current Location').next().should('have.text', expectedLocation);
      cy.contains('Estimated Delivery Time').next().should('have.text', expectedDeliveryTime);
    });
  });

  afterEach(() => {
    cy.logout();
    cy.url().should('include', '/login');
  });
});