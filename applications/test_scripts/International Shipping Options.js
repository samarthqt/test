describe('International Shipping Options', () => {
  const loginPage = new LoginPage();
  const cartPage = new CartPage();
  const shippingPage = new ShippingPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    loginPage.visit();
    loginPage.login('validUser', 'validPassword');
  });

  it('should allow users to add products to the cart', () => {
    cartPage.addProductsToCart();
    cartPage.verifyProductsAdded();
  });

  it('should update shipping address to international', () => {
    shippingPage.enterInternationalAddress('123 International St', 'International City', 'Country');
    shippingPage.verifyAddressUpdated();
  });

  it('should display international shipping options and fees at checkout', () => {
    checkoutPage.proceedToCheckout();
    checkoutPage.verifyInternationalShippingOptions();
  });
});