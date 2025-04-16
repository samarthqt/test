describe('Add Invalid Item to Cart', () => {
  const invalidProductId = '999';
  const userId = '202';
  let cartPage;

  before(() => {
    cy.login(userId);
    cartPage = new CartPage();
  });

  it('should display error for invalid product ID', () => {
    cartPage.addToCart(invalidProductId);
    cartPage.getErrorMessage().should('contain', 'Product does not exist');
  });

  it('should verify cart remains unchanged', () => {
    cartPage.getCartItems().should('not.contain', invalidProductId);
  });

  it('should check system error logs', () => {
    cy.checkSystemLogs().should('contain', 'Error adding invalid product');
  });

  it('should reject negative quantity', () => {
    cartPage.addToCartWithQuantity('validProductId', -1);
    cartPage.getErrorMessage().should('contain', 'Invalid quantity');
  });

  it('should display error for quantity exceeding stock', () => {
    cartPage.addToCartWithQuantity('validProductId', 1000);
    cartPage.getErrorMessage().should('contain', 'Insufficient stock');
  });

  after(() => {
    cy.logout();
  });
});