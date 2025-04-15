describe('Guest Checkout with Invalid Payment Details', () => {
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  it('should fail checkout with invalid payment details', () => {
    productPage.visit();
    productPage.addToCart();
    cartPage.proceedToCheckout();
    checkoutPage.selectGuestCheckout();
    checkoutPage.enterShippingAddress('123 Main St, Anytown, USA');
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.enterCardNumber('1234 5678 9012 3456');
    checkoutPage.placeOrder();
    checkoutPage.verifyInvalidPaymentError();
  });
});