describe('Customer Payment History - Incorrect Date Range', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const paymentHistoryPage = new PaymentHistoryPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display error for incorrect date range', () => {
    loginPage.login('ADM001', 'password');
    dashboardPage.navigateToPaymentHistory();
    paymentHistoryPage.enterCustomerId('CUST002');
    paymentHistoryPage.setDateRange('2023-11-02', '2023-11-01');
    paymentHistoryPage.clickViewPaymentHistory();
    paymentHistoryPage.verifyErrorMessage('Invalid date range');
    paymentHistoryPage.setDateRange('2023-11-01', '2023-11-02');
    paymentHistoryPage.clickViewPaymentHistory();
    paymentHistoryPage.verifyPaymentHistoryDisplayed();
    dashboardPage.logout();
  });
});