describe('Customer Payment History', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const paymentHistoryPage = new PaymentHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in as admin and view payment history', () => {
    loginPage.login('ADM001', 'adminPassword');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToPaymentHistory();
    paymentHistoryPage.enterCustomerId('CUST001');
    paymentHistoryPage.setDateRange('2023-01-01', '2023-11-01');
    paymentHistoryPage.viewPaymentHistory();
    paymentHistoryPage.verifyPaymentRecordsIncludeRefundsAndCancellations();
    dashboardPage.logout();
  });
});