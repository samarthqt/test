describe('Product Page Discount Display', () => {
  before(() => {
    cy.loginAsUser(); // Custom command to log in as a user
  });

  it('should display the original and discounted prices correctly', () => {
    cy.visit('/product/P123');
    const productPage = new ProductPage();
    productPage.verifyOriginalPrice('$100');
    productPage.verifyDiscountedPrice('$80');
    productPage.verifyDiscountPercentage('20%');
  });

  it('should be responsive on different devices', () => {
    const productPage = new ProductPage();
    cy.viewport('iphone-6');
    productPage.verifyPriceDisplayResponsive();
    cy.viewport('ipad-2');
    productPage.verifyPriceDisplayResponsive();
    cy.viewport('macbook-15');
    productPage.verifyPriceDisplayResponsive();
  });

  it('should reflect discounted price in the shopping cart', () => {
    const productPage = new ProductPage();
    productPage.addToCart();
    const cartPage = new CartPage();
    cartPage.verifyDiscountedPrice('$80');
  });

  it('should display promotional messages correctly', () => {
    const productPage = new ProductPage();
    productPage.verifyPromotionalMessages();
  });

  it('should display discounted price in order summary during checkout', () => {
    const checkoutPage = new CheckoutPage();
    checkoutPage.verifyDiscountedPriceInOrderSummary('$80');
  });

  it('should be visible to all user roles', () => {
    cy.loginAsDifferentRoles(['admin', 'guest', 'member']);
    const productPage = new ProductPage();
    productPage.verifyDiscountVisibility();
  });

  it('should apply discount for multiple quantities', () => {
    const productPage = new ProductPage();
    productPage.addMultipleQuantitiesToCart(3);
    const cartPage = new CartPage();
    cartPage.verifyTotalPriceWithDiscount('$240');
  });

  it('should display prices in wishlist', () => {
    const wishlistPage = new WishlistPage();
    wishlistPage.verifyPricesInWishlist('$100', '$80');
  });

  it('should allow additional coupons', () => {
    const cartPage = new CartPage();
    cartPage.applyCoupon('EXTRA10');
    cartPage.verifyTotalPriceWithAdditionalDiscount('$72');
  });

  it('should display discounted price in email notifications', () => {
    const emailPage = new EmailPage();
    emailPage.verifyDiscountedPriceInEmail('$80');
  });

  it('should convert and display price in different currencies', () => {
    const productPage = new ProductPage();
    productPage.selectCurrency('EUR');
    productPage.verifyConvertedPrice('€68');
  });
});