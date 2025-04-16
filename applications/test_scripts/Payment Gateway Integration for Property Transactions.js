describe('Payment Gateway Integration for Property Transactions', () => {
  beforeEach(() => {
    cy.login(); // Assume a custom command to log in
    cy.visit('/property/12345/transaction');
  });

  it('should allow a user to make a payment with a valid credit card', () => {
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('4111111111111111', '12/23', '123');
    PaymentPage.enterAmount('2500');
    PaymentPage.submitPayment();
    PaymentPage.verifyPaymentConfirmation();
    cy.checkEmailConfirmation(); // Assume a custom command to check email
    cy.verifyPaymentStatusInAccount(); // Assume a custom command to verify payment status
  });

  it('should display error for invalid card number', () => {
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('1234567890123456', '12/23', '123');
    PaymentPage.enterAmount('2500');
    PaymentPage.submitPayment();
    PaymentPage.verifyErrorMessage('Invalid card number');
  });

  it('should display error for expired card', () => {
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('4111111111111111', '01/20', '123');
    PaymentPage.enterAmount('2500');
    PaymentPage.submitPayment();
    PaymentPage.verifyErrorMessage('Expired card');
  });

  it('should display error for incorrect CVV', () => {
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('4111111111111111', '12/23', '000');
    PaymentPage.enterAmount('2500');
    PaymentPage.submitPayment();
    PaymentPage.verifyErrorMessage('Incorrect CVV');
  });

  it('should display error for insufficient funds', () => {
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('4111111111111111', '12/23', '123');
    PaymentPage.enterAmount('100000');
    PaymentPage.submitPayment();
    PaymentPage.verifyErrorMessage('Insufficient funds');
  });

  it('should prompt login for unauthenticated user', () => {
    cy.logout(); // Assume a custom command to log out
    cy.visit('/property/12345/transaction');
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('4111111111111111', '12/23', '123');
    PaymentPage.enterAmount('2500');
    PaymentPage.submitPayment();
    PaymentPage.verifyLoginPrompt();
  });

  it('should verify correct transaction confirmation email', () => {
    PaymentPage.selectPaymentMethod('Credit Card');
    PaymentPage.enterCardDetails('4111111111111111', '12/23', '123');
    PaymentPage.enterAmount('2500');
    PaymentPage.submitPayment();
    cy.checkEmailConfirmation();
    cy.verifyEmailContent('Transaction confirmed for property ID 12345');
  });
});