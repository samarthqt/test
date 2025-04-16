describe('Manual Billing Option Test Suite', () => {
  const billingPortal = new BillingPortal();

  beforeEach(() => {
    cy.visit('/login');
    billingPortal.login('user67890');
  });

  it('should navigate to Manual Payment section and select an invoice', () => {
    billingPortal.navigateToManualPayment();
    billingPortal.selectInvoice('$50.00');
  });

  it('should choose PayPal as payment method and initiate payment', () => {
    billingPortal.choosePaymentMethod('PayPal');
    billingPortal.initiatePayment();
    billingPortal.completePaymentThroughPayPal();
  });

  it('should verify transaction record and email notification', () => {
    billingPortal.verifyTransactionRecord('$50.00');
    billingPortal.checkEmailNotification();
  });

  it('should ensure invoice status is updated to Paid', () => {
    billingPortal.verifyInvoiceStatus('Paid');
  });

  it('should test system behavior with an invalid payment method', () => {
    billingPortal.testInvalidPaymentMethod();
  });

  it('should verify option to switch back to automatic billing', () => {
    billingPortal.switchToAutomaticBilling();
  });

  it('should check manual payment option for different invoice types', () => {
    billingPortal.checkManualPaymentOptionForAllInvoices();
  });

  it('should review system logs for errors during manual payment', () => {
    billingPortal.reviewSystemLogs();
  });

  it('should ensure compliance with manual payment processing regulations', () => {
    billingPortal.ensureCompliance();
  });

  it('should gather user feedback on manual payment process', () => {
    billingPortal.gatherUserFeedback();
  });
});