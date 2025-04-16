describe('Maximum Payment Amount Test', () => {
  const paymentPage = new PaymentPage();

  beforeEach(() => {
    cy.login('validUser', 'validPassword');
    paymentPage.navigateToPaymentPage();
  });

  it('should handle maximum allowable payment amount via credit card', () => {
    paymentPage.selectCreditCardPayment();
    paymentPage.enterCreditCardNumber('4111 1111 1111 1111');
    paymentPage.enterExpiryDate('12/25');
    paymentPage.enterCVV('123');
    paymentPage.enterPaymentAmount('10000');
    paymentPage.clickPayNow();

    cy.get('.confirmation-message').should('be.visible');
    cy.verifyEmail('payment confirmation', 'Transaction Details');
    paymentPage.verifyTransactionHistory('10000');
  });
});