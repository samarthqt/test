describe('Multiple Shipping Addresses in One Order', () => {
  const loginPage = new LoginPage();
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('U12345');
  });

  it('should add multiple products to the cart and assign different shipping addresses', () => {
    productPage.addProductToCart('P12345');
    productPage.addProductToCart('P67890');

    cartPage.navigateToCart();
    cartPage.proceedToCheckout();

    checkoutPage.selectShipToMultipleAddresses();
    checkoutPage.assignAddressToProduct('P12345', 'Address1');
    checkoutPage.assignAddressToProduct('P67890', 'Address2');

    checkoutPage.verifyShippingCosts();
    checkoutPage.completePurchase();
  });

  it('should verify order confirmation email and order history', () => {
    cy.checkEmailConfirmation('U12345', ['P12345', 'Address1'], ['P67890', 'Address2']);

    orderHistoryPage.navigateToOrderHistory();
    orderHistoryPage.verifyOrderWithMultipleAddresses();
  });

  it('should allow modifications to shipping addresses post-order placement', () => {
    orderHistoryPage.modifyShippingAddressesIfPermitted();
  });

  it('should validate addresses during checkout', () => {
    checkoutPage.validateAddresses();
  });

  it('should display error messages for invalid addresses during checkout', () => {
    checkoutPage.testInvalidAddresses();
  });
});