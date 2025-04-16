describe('Payment Integration - Service Payment Execution', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const paymentsPage = new PaymentsPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log into the application', () => {
    loginPage.login('user11223', 'validPassword');
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to the Payments module', () => {
    dashboardPage.navigateToPaymentsModule();
    paymentsPage.verifyPaymentsPage();
  });

  it('should select service type and make a payment', () => {
    paymentsPage.selectServiceType('Parking');
    paymentsPage.enterPaymentAmount('100');
    paymentsPage.selectPaymentMethod('Credit Card');
    paymentsPage.proceedToPay();
    paymentsPage.verifyPaymentConfirmation();
  });

  it('should check transaction history for payment entry', () => {
    paymentsPage.verifyTransactionHistory('Parking', '100', 'Credit Card');
  });

  it('should reject payment with invalid payment method', () => {
    paymentsPage.selectPaymentMethod('Invalid Method');
    paymentsPage.proceedToPay();
    paymentsPage.verifyErrorMessage('Invalid payment method');
  });

  it('should prevent payment exceeding available balance', () => {
    paymentsPage.enterPaymentAmount('10000');
    paymentsPage.proceedToPay();
    paymentsPage.verifyErrorMessage('Insufficient funds');
  });

  it('should verify security protocols during payment', () => {
    paymentsPage.verifySecurityProtocols();
  });

  it('should navigate back to Payments module interface', () => {
    paymentsPage.navigateBackToPayments();
    paymentsPage.verifyPaymentsPage();
  });

  it('should log out of the application', () => {
    dashboardPage.logout();
    loginPage.verifyLoginPage();
  });
});