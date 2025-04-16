describe('Customer Payment History - Large Dataset Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const paymentHistoryPage = new PaymentHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in as admin and navigate to payment history module', () => {
    loginPage.login('ADM001', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToPaymentHistory();
  });

  it('should enter customer ID and set payment history date range', () => {
    paymentHistoryPage.enterCustomerId('CUST003');
    paymentHistoryPage.setDateRange('2020-01-01', '2023-11-01');
  });

  it('should display payment history and verify system performance', () => {
    paymentHistoryPage.viewPaymentHistory();
    paymentHistoryPage.verifyPerformance();
  });

  after(() => {
    dashboardPage.logout();
  });
});