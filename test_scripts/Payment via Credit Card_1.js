describe('Payment via Credit Card', () => {
  it('should allow users to pay using a credit card', () => {
    const shoppingCartPage = new ShoppingCartPage();
    const checkoutPage = new CheckoutPage();

    shoppingCartPage.visit();
    shoppingCartPage.verifyItemsListed();
    shoppingCartPage.proceedToCheckout();

    checkoutPage.verifyPageDisplayed();
    checkoutPage.selectCreditCardPayment();
    checkoutPage.enterCreditCardDetails('4111 1111 1111 1111', '12/25', '123');
    checkoutPage.payNow();

    checkoutPage.verifyPaymentConfirmation();
  });
});