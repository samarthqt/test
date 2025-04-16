describe('Flash Sale Timing Test', () => {
  const productId = 101;
  const flashSaleDiscount = 0.20;
  const saleStartTime = '10:00 AM';
  const saleEndTime = '12:00 PM';

  before(() => {
    cy.visit('/');
  });

  it('should display discounted price at flash sale start time', () => {
    cy.clock(new Date().setHours(10, 0, 0));
    cy.visit(`/product/${productId}`);
    cy.get(ProductPage.flashSaleLabel).should('be.visible');
    cy.get(ProductPage.price).should('contain', 'Discounted Price');
  });

  it('should add product to cart and display discounted price in checkout', () => {
    cy.get(ProductPage.addToCartButton).click();
    cy.visit('/cart');
    cy.get(CartPage.price).should('contain', 'Discounted Price');
    cy.get(CartPage.checkoutButton).click();
    cy.get(CheckoutPage.price).should('contain', 'Discounted Price');
  });

  it('should display original price at flash sale end time', () => {
    cy.clock(new Date().setHours(12, 0, 0));
    cy.visit(`/product/${productId}`);
    cy.get(ProductPage.price).should('contain', 'Original Price');
  });

  it('should maintain performance levels during flash sale updates', () => {
    cy.visit(`/product/${productId}`);
    cy.window().its('performance').invoke('now').should('be.lt', 1000);
  });

  it('should handle simultaneous flash sale events correctly', () => {
    cy.visit('/flash-sales');
    cy.get(FlashSalePage.event).each(($el) => {
      cy.wrap($el).find(FlashSalePage.price).should('contain', 'Discounted Price');
    });
  });
});