describe('TC-333 253 Payment Failure due to Insufficient Funds', () => {
  const purchasePage = new PurchasePage();

  beforeEach(() => {
    cy.visit('/course-purchase');
  });

  it('should handle payment failure due to insufficient funds gracefully', () => {
    purchasePage.selectCourse('High Course');
    purchasePage.selectPaymentMethod('Credit Card');
    purchasePage.enterCreditCardDetails('4111111111111111', '12/25', '123');
    purchasePage.clickPayNow();
    purchasePage.verifyPaymentFailureMessage('Payment failed due to insufficient funds');
  });
});