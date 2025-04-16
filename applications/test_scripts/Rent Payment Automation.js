describe('Rent Payment Automation', () => {
  const tenant = new TenantPage();
  const payment = new PaymentPage();

  beforeEach(() => {
    cy.visit('/login');
    tenant.login('validUsername', 'validPassword');
  });

  it('should navigate to rent payment section', () => {
    payment.navigateToRentPaymentSection();
    payment.verifyRentPaymentSectionDisplayed();
  });

  it('should set up automatic recurring payments', () => {
    payment.selectRecurringPaymentsOption();
    payment.enterPaymentMethodDetails('creditCard');
    payment.scheduleRecurringPayment('1000', '15');
    payment.confirmRecurringPaymentSetup();
  });

  it('should process recurring payment on due date', () => {
    payment.verifyRecurringPaymentProcessed('15');
  });

  it('should receive payment confirmation notifications', () => {
    payment.verifyPaymentConfirmationNotification();
  });

  it('should prevent setup with invalid payment method', () => {
    payment.attemptSetupWithInvalidPaymentMethod();
    payment.verifyErrorMessageDisplayed();
  });

  it('should allow modification or cancellation of recurring payments', () => {
    payment.modifyOrCancelRecurringPayments();
  });

  it('should handle payment failures and retries', () => {
    payment.simulatePaymentFailure();
    payment.verifyRetryMechanism();
  });

  it('should display payment history for recurring payments', () => {
    payment.viewPaymentHistory();
    payment.verifyPaymentHistoryDisplayed();
  });

  it('should persist recurring payments after account updates', () => {
    tenant.updateAccountDetails();
    payment.verifyRecurringPaymentsPersist();
  });

  it('should prevent setup with insufficient funds', () => {
    payment.attemptSetupWithInsufficientFunds();
    payment.verifyErrorMessageDisplayed();
  });

  it('should synchronize recurring payments across devices', () => {
    payment.verifyRecurringPaymentsSynchronized();
  });
});