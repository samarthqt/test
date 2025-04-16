describe('TC-757 282 System Behavior on Zero Quantity during Shipment', () => {
  const inventoryManagementPage = new InventoryManagementPage();

  before(() => {
    cy.visit('/login');
    inventoryManagementPage.login('username', 'password');
  });

  it('should navigate to Goods Shipment section', () => {
    inventoryManagementPage.navigateToGoodsShipment();
    cy.url().should('include', '/goods-shipment');
  });

  it('should fetch and display product details', () => {
    inventoryManagementPage.enterProductId('12345');
    cy.get('.product-details').should('be.visible');
  });

  it('should display warning on zero quantity', () => {
    inventoryManagementPage.enterShippedQuantity('0');
    cy.get('.warning-message').should('contain.text', 'Quantity cannot be zero');
  });

  it('should prevent submission with zero quantity', () => {
    inventoryManagementPage.submitShipment();
    cy.get('.error-message').should('contain.text', 'Correct the quantity');
  });
});