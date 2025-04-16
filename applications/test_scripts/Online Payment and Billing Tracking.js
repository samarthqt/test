describe('Online Payment and Billing Tracking', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const billingPage = new BillingPage();
  const paymentPage = new PaymentPage();

  before(() => {
    cy.visit('/');
  });

  it('should allow patient to login and navigate to dashboard', () => {
    loginPage.login('JohnDoe', 'password123');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Billing and Payments section', () => {
    dashboardPage.goToBillingAndPayments();
    billingPage.verifyBillingSection();
  });

  it('should view bill details and initiate payment', () => {
    billingPage.selectBill('123456');
    billingPage.verifyBillDetails();
    billingPage.clickPayNow();
    paymentPage.verifyPaymentOptions();
  });

  it('should complete payment using credit card', () => {
    paymentPage.selectPaymentMethod('Credit Card');
    paymentPage.enterCardDetails('4111111111111111', '12/25', '123');
    paymentPage.confirmAmount('$200');
    paymentPage.submitPayment();
    paymentPage.verifyPaymentSuccess();
  });

  it('should verify updated billing section and payment history', () => {
    billingPage.goBackToBillingSection();
    billingPage.verifyBillPaid('123456');
    billingPage.verifyPaymentHistory('Completed');
  });

  after(() => {
    dashboardPage.logout();
  });
});