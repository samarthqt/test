describe('Credit Card Payment Processing', () => {
  const paymentPage = new PaymentPage();

  before(() => {
    cy.login('validUser', 'validPassword');
  });

  it('should navigate to the payment page', () => {
    paymentPage.visit();
    paymentPage.verifyPageDisplayed();
  });

  it('should select Credit Card as payment method', () => {
    paymentPage.selectPaymentMethod('Credit Card');
    paymentPage.verifyCreditCardFieldsEnabled();
  });

  it('should enter credit card details', () => {
    paymentPage.enterCreditCardNumber('4111 1111 1111 1111');
    paymentPage.enterExpiryDate('12/25');
    paymentPage.enterCVV('123');
  });

  it('should process payment and display confirmation', () => {
    paymentPage.clickPayNow();
    paymentPage.verifyPaymentConfirmation();
  });

  it('should verify payment confirmation email', () => {
    cy.verifyEmailReceived('Payment Confirmation');
  });

  it('should check transaction history', () => {
    cy.visit('/user/account');
    cy.verifyTransactionInHistory('4111 1111 1111 1111');
  });
});