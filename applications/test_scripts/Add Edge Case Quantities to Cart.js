describe('TC-645: Add Edge Case Quantities to Cart', () => {
  const productId = 101;
  const userId = 202;
  const largeQuantity = 10000;
  const decimalQuantity = 10.5;
  let cartPage;

  before(() => {
    cy.login(userId);
    cartPage = new CartPage();
  });

  it('should reject adding a product with quantity 0', () => {
    cartPage.addProductToCart(productId, 0);
    cartPage.getValidationMessage().should('contain', 'Invalid quantity');
  });

  it('should add a product with a very large quantity to the cart', () => {
    cartPage.addProductToCart(productId, largeQuantity);
    cartPage.verifyCartSummary(largeQuantity);
  });

  it('should display correct total price and quantity in the cart summary', () => {
    cartPage.verifyCartSummary(largeQuantity);
  });

  it('should reject adding a product with a decimal quantity', () => {
    cartPage.addProductToCart(productId, decimalQuantity);
    cartPage.getValidationMessage().should('contain', 'Invalid quantity format');
  });

  it('should maintain acceptable performance levels for large quantity additions', () => {
    const startTime = new Date().getTime();
    cartPage.addProductToCart(productId, largeQuantity);
    const endTime = new Date().getTime();
    const responseTime = endTime - startTime;
    expect(responseTime).to.be.lessThan(2000);
  });
});