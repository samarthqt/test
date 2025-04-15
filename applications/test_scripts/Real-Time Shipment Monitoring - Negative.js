describe('Real-Time Shipment Monitoring - Negative Test', () => {
  const customerID = 'CUST98765';
  const invalidShipmentID = 'SHIP00000';

  before(() => {
    cy.visit('/login');
    cy.login(customerID, 'validPassword'); // Assuming login method is defined in commands
  });

  it('should display error for invalid shipment ID', () => {
    cy.visit('/track-shipment');
    cy.get('#shipmentSearchBar').type(invalidShipmentID);
    cy.get('#searchButton').click();
    cy.get('.error-message').should('contain', 'Invalid shipment ID');
    cy.reload();
    cy.get('.error-message').should('contain', 'Invalid shipment ID');
    cy.get('.shipment-details').should('not.exist');
  });

  after(() => {
    cy.logout();
  });
});