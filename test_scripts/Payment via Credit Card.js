describe('Payment via Credit Card', () => {
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/checkout');
  });

  it('should navigate to the checkout page', () => {
    checkoutPage.verifyCheckoutPageDisplayed();
  });

  it('should select Credit Card as the payment method', () => {
    checkoutPage.selectCreditCardPaymentMethod();
    checkoutPage.verifyCreditCardFormDisplayed();
  });

  it('should enter credit card details and make payment', () => {
    checkoutPage.enterCreditCardNumber('4111 1111 1111 1111');
    checkoutPage.enterExpiryDate('12/25');
    checkoutPage.enterCVV('123');
    checkoutPage.clickPayNow();
    checkoutPage.verifyPaymentConfirmation();
  });
});