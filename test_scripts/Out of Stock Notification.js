describe('Out of Stock Notification', () => {
  const productId = '987655';
  const productPage = new ProductPage();

  before(() => {
    cy.visit(`/product/${productId}`);
  });

  it('should display Out of Stock when the product is unavailable', () => {
    productPage.getStockAvailability().should('contain', 'Out of Stock');
  });
});