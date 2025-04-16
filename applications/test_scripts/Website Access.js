describe('Banking Web Portal - Bill Payment', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const billPaymentPage = new BillPaymentPage();

  beforeEach(() => {
    cy.visit('https://banking-portal.com');
  });

  it('should allow the user to log in and make a bill payment', () => {
    loginPage.enterUserId('user456');
    loginPage.enterPassword('pass456');
    loginPage.clickLoginButton();

    dashboardPage.navigateToBillPayment();

    billPaymentPage.selectBiller('Electricity');
    billPaymentPage.enterAmount('$50');
    billPaymentPage.clickSubmitButton();

    billPaymentPage.verifyConfirmationMessage();
    billPaymentPage.verifyTransactionInHistory('Electricity', '$50');
  });
});