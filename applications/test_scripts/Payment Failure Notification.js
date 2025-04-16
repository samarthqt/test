describe('Payment Failure Notification Test', () => {
  beforeEach(() => {
    cy.visit('/checkout');
    cy.login('user@example.com', 'password123');
  });

  it('should notify the user upon payment failure', () => {
    const checkoutPage = new CheckoutPage();

    checkoutPage.proceedToCheckout();
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.enterCreditCardDetails('1234 5678 9012 3456', '12/23', '123');
    checkoutPage.clickPayNow();

    checkoutPage.getPaymentFailureNotification().should('be.visible').and('contain', 'Payment failed. Please retry.');
  });
});