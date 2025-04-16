describe('Online Payment Failure Handling', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const billingPage = new BillingPage();
  const paymentPage = new PaymentPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should handle payment failure and retry successfully', () => {
    loginPage.login('Jane Smith', 'valid_password');
    dashboardPage.navigateToBillingAndPayments();

    billingPage.selectBill('654321');
    billingPage.clickPayNow();

    paymentPage.selectPaymentMethod('Credit Card');
    paymentPage.enterCardDetails('invalid_card_number', 'invalid_expiry', 'invalid_cvv');
    paymentPage.submitPayment();

    paymentPage.verifyErrorMessage('Invalid credit card details');

    paymentPage.enterCardDetails('valid_card_number', 'valid_expiry', 'valid_cvv');
    paymentPage.submitPayment();

    paymentPage.verifySuccessMessage('Payment processed successfully');

    billingPage.verifyPaymentHistory('654321', 'Completed');

    dashboardPage.logout();
  });
});