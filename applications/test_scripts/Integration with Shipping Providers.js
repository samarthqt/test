describe('Integration with Shipping Providers', () => {
  before(() => {
    cy.login('admin', 'admin_password');
  });

  it('should integrate with FedEx for label generation', () => {
    const orderId = '12345';

    cy.visit('/shipping-integration');
    cy.get('.add-new-integration').click();
    cy.get('.provider-list').select('FedEx');
    cy.get('.api-credentials').type('fedex_api_credentials');
    cy.get('.save-integration').click();
    cy.get('.integration-status').should('contain', 'Active');

    cy.visit('/order-fulfillment');
    cy.get(`.order-id-${orderId}`).click();
    cy.get('.generate-shipping-label').click();
    cy.get('.provider-list').select('FedEx');
    cy.get('.confirm-shipment').click();
    cy.get('.shipping-label').should('be.visible');

    cy.get('.download-label').click();
    cy.readFile('cypress/downloads/fedex-label.pdf').should('exist');

    cy.visit(`/order-details/${orderId}`);
    cy.get('.order-status').should('contain', 'Shipped');

    cy.logout();
  });

  after(() => {
    cy.logout();
  });
});