describe('Secure Payment Gateway Functionality', () => {
  const paymentPage = new PaymentPage();
  beforeEach(() => {
    cy.visit('/payment-module');
    paymentPage.verifyDashboardDisplayed();
  });

  it('should process credit card transaction for User A', () => {
    paymentPage.selectUser('User A');
    paymentPage.initiateTransaction();
    paymentPage.choosePaymentMethod('Credit Card');
    paymentPage.enterPaymentDetails('User A', 'Credit Card');
    paymentPage.submitPayment();
    paymentPage.verifyTransactionRecorded();
  });

  it('should process PayPal transaction for User A', () => {
    paymentPage.selectUser('User A');
    paymentPage.initiateTransaction();
    paymentPage.choosePaymentMethod('PayPal');
    paymentPage.enterPaymentDetails('User A', 'PayPal');
    paymentPage.submitPayment();
    paymentPage.verifyTransactionRecorded();
  });

  it('should process credit card transaction for User B', () => {
    paymentPage.selectUser('User B');
    paymentPage.initiateTransaction();
    paymentPage.choosePaymentMethod('Credit Card');
    paymentPage.enterPaymentDetails('User B', 'Credit Card');
    paymentPage.submitPayment();
    paymentPage.verifyTransactionRecorded();
  });

  it('should process Apple Pay transaction for User B', () => {
    paymentPage.selectUser('User B');
    paymentPage.initiateTransaction();
    paymentPage.choosePaymentMethod('Apple Pay');
    paymentPage.enterPaymentDetails('User B', 'Apple Pay');
    paymentPage.submitPayment();
    paymentPage.verifyTransactionRecorded();
  });

  it('should process PayPal transaction for User C', () => {
    paymentPage.selectUser('User C');
    paymentPage.initiateTransaction();
    paymentPage.choosePaymentMethod('PayPal');
    paymentPage.enterPaymentDetails('User C', 'PayPal');
    paymentPage.submitPayment();
    paymentPage.verifyTransactionRecorded();
  });

  it('should process Apple Pay transaction for User C', () => {
    paymentPage.selectUser('User C');
    paymentPage.initiateTransaction();
    paymentPage.choosePaymentMethod('Apple Pay');
    paymentPage.enterPaymentDetails('User C', 'Apple Pay');
    paymentPage.submitPayment();
    paymentPage.verifyTransactionRecorded();
  });

  it('should verify fraud detection and prevention mechanisms', () => {
    paymentPage.checkFraudDetection();
  });

  it('should ensure transaction data is encrypted and stored securely', () => {
    paymentPage.verifyDataEncryption();
  });

  it('should test payment gateway response to network interruptions', () => {
    paymentPage.testNetworkInterruptions();
  });

  it('should verify refund process through the payment gateway', () => {
    paymentPage.verifyRefundProcess();
  });
});