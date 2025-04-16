describe('Real-Time Inventory Update on Goods Shipment', () => {
  const productID = '12345';
  const shippedQuantity = 20;

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('testUser');
    cy.get('#password').type('testPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Goods Shipment and submit shipment', () => {
    cy.get('#goodsShipmentNav').click();
    cy.url().should('include', '/goods-shipment');

    cy.get('#productIdInput').type(productID);
    cy.get('#productDetails').should('contain', productID);

    cy.get('#shippedQuantityInput').type(shippedQuantity);
    cy.get('#submitShipmentButton').click();

    cy.get('#confirmationMessage').should('contain', 'successful shipment');
  });

  it('should verify inventory levels after shipment', () => {
    cy.get('#inventoryLevelsNav').click();
    cy.url().should('include', '/inventory-levels');

    cy.get('#productSearchInput').type(productID);
    cy.get('#searchButton').click();

    cy.get('#inventoryDetails').should('contain', productID);
    cy.get('#inventoryLevel').should('contain', `Updated inventory level reflects deduction of ${shippedQuantity} units`);
  });
});