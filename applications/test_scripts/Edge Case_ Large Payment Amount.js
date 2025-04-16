describe('Large Payment Amount Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const billingPage = new BillingPage();
  const paymentPage = new PaymentPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the patient portal', () => {
    loginPage.login('Alex Johnson', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Billing and Payments section', () => {
    dashboardPage.goToBillingAndPayments();
    billingPage.verifyBillingSection();
  });

  it('should select a large amount bill and view details', () => {
    billingPage.selectLargeAmountBill('789012');
    billingPage.verifyBillDetails();
  });

  it('should pay the bill using Bank Transfer', () => {
    billingPage.clickPayNow();
    paymentPage.selectPaymentMethod('Bank Transfer');
    paymentPage.enterBankDetails('789012', 'Bank Name', 'Routing Number');
    paymentPage.confirmPaymentAmount('10000');
    paymentPage.submitPayment();
    paymentPage.verifyPaymentSuccess();
  });

  it('should verify the payment history', () => {
    billingPage.navigateBackToBilling();
    billingPage.verifyBillMarkedAsPaid();
    billingPage.verifyPaymentHistory('Completed');
  });

  after(() => {
    dashboardPage.logout();
  });
});