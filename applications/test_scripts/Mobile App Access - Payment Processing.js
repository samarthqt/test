describe('Mobile App Payment Processing', () => {
  const paymentPage = new PaymentPage();

  beforeEach(() => {
    cy.login(); // Assume a custom command for logging in
  });

  it('should allow the user to make a payment', () => {
    paymentPage.navigateToPaymentSection();
    paymentPage.verifyPaymentSectionDisplayed();
    paymentPage.clickMakeAPayment();
    paymentPage.verifyPaymentFormDisplayed();
    paymentPage.enterPaymentAmount('50.00');
    paymentPage.selectPaymentMethod('Credit Card');
    paymentPage.submitPayment();
    paymentPage.verifyPaymentConfirmationDisplayed();
  });
});