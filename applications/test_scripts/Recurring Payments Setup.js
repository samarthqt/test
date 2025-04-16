describe('Recurring Payments Setup', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const paymentsPage = new PaymentsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the banking app', () => {
    loginPage.login('234567');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Payments section', () => {
    dashboardPage.goToPayments();
    paymentsPage.verifyPaymentsScreen();
  });

  it('should set up a recurring payment', () => {
    paymentsPage.selectRecurringPayments();
    paymentsPage.enterPaymentDetails('$100', 'Monthly', '01/01/2024', '12/31/2024');
    paymentsPage.enterPayeeDetails('4567890');
    paymentsPage.submitRecurringPayment();
    paymentsPage.verifyConfirmationMessage();
  });

  it('should verify the scheduled payments list', () => {
    paymentsPage.verifyScheduledPayments('$100', 'Monthly', '01/01/2024', '12/31/2024');
  });

  it('should verify the transaction after the first payment date', () => {
    paymentsPage.verifyTransactionInHistory('$100', '4567890');
  });
});