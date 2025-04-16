describe('Invalid Product ID for Price History', () => {
  const productID = '99999';
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.visit('/product-module');
  });

  it('should display a message indicating the product does not exist', () => {
    productPage.searchProductByID(productID);
    productPage.getProductNotExistMessage().should('be.visible').and('contain', 'Product does not exist');
  });

  it('should prevent access to the price history section and display an error message', () => {
    productPage.searchProductByID(productID);
    productPage.attemptAccessPriceHistory();
    productPage.getPriceHistoryErrorMessage().should('be.visible').and('contain', 'Cannot access price history for non-existent product');
  });
});