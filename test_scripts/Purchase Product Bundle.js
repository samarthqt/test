describe('Purchase Product Bundle', () => {
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.login(); // Assuming a custom command for logging in
  });

  it('should allow user to purchase a product bundle at a discounted price', () => {
    productPage.navigateToProductBundles();
    productPage.selectProductBundle('Winter Essentials Bundle');
    productPage.verifyBundleDetailsDisplayed();
    productPage.addToCart();

    cartPage.navigateToCart();
    cartPage.verifyBundleInCart('Winter Essentials Bundle');
    cartPage.proceedToCheckout();

    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.placeOrder();
    checkoutPage.verifyOrderConfirmation();

    cy.verifyOrderConfirmationEmail(); // Custom command to verify email
  });
});