describe('Real-Time Shipment Monitoring - Edge Test', () => {
  const customerId = 'CUST24680';
  const longShipmentId = 'SHIP12345678901234567890';

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the customer account', () => {
    cy.get('#username').type(customerId);
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Track Shipment section', () => {
    cy.get('#trackShipment').click();
    cy.url().should('include', '/track-shipment');
  });

  it('should enter the long shipment ID and check system response', () => {
    cy.get('#shipmentIdInput').type(longShipmentId);
    cy.get('#searchButton').click();
    cy.get('#feedbackMessage').should('exist');
  });

  it('should log out of the customer account', () => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});