describe('Real-Time Stock Availability Display', () => {
  const productId = '987654';
  const initialStock = '20 items';
  const updatedStock = '5 items';

  before(() => {
    // Setup code to ensure product is available in the inventory system
    // This could involve API calls or direct database manipulation
    cy.updateInventory(productId, 20);
  });

  it('should display real-time stock availability on product page', () => {
    const productPage = new ProductPage();
    productPage.visit(productId);
    productPage.getStockAvailability().should('contain', initialStock);

    // Simulate reducing stock in the inventory system
    cy.updateInventory(productId, 5);

    // Refresh the page to check for updated stock
    productPage.refresh();
    productPage.getStockAvailability().should('contain', updatedStock);
  });

  after(() => {
    // Teardown code to reset inventory if necessary
    cy.updateInventory(productId, 20);
  });
});