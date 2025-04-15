describe('TC-39 Verify Multiple Payment Methods', () => {
  const checkoutPage = new CheckoutPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.login('12345');
    cy.addItemsToCart('56789');
    cy.visit('/checkout');
  });

  it('should display checkout page with order summary and payment options', () => {
    checkoutPage.verifyOrderSummary();
    checkoutPage.verifyPaymentOptions(['Credit Card', 'Debit Card', 'PayPal']);
  });

  it('should select Credit Card as payment method', () => {
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.verifyCreditCardFields();
  });

  it('should enter valid credit card details and submit', () => {
    checkoutPage.enterCreditCardDetails('4111111111111111', '12/23', '123');
    checkoutPage.submitPayment();
    checkoutPage.verifyPaymentSuccess();
  });

  it('should return to payment method selection', () => {
    checkoutPage.returnToPaymentSelection();
    checkoutPage.verifyPaymentOptions(['Credit Card', 'Debit Card', 'PayPal']);
  });

  it('should select PayPal as payment method', () => {
    checkoutPage.selectPaymentMethod('PayPal');
    checkoutPage.verifyRedirectedToPayPal();
  });

  it('should log in to PayPal and authorize payment', () => {
    checkoutPage.loginToPayPal('user@example.com', 'password');
    checkoutPage.authorizePayPalPayment();
    checkoutPage.verifyPaymentSuccess();
  });

  it('should verify transaction details in the order history', () => {
    cy.visit('/order-history');
    orderHistoryPage.verifyTransactionDetails('PayPal');
  });
});