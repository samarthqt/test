describe('Guest Checkout with Valid Data', () => {
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should complete a purchase as a guest with valid data', () => {
    productPage.navigateToProduct('Laptop');
    productPage.addToCart();
    cartPage.proceedToCheckout();
    checkoutPage.selectGuestCheckout();
    checkoutPage.enterShippingAddress('123 Main St, Anytown, USA');
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.enterCreditCardDetails('4111111111111111', '12/23', '123');
    checkoutPage.placeOrder();

    cy.url().should('include', '/confirmation');
    cy.contains('Order placed successfully').should('be.visible');
  });
});