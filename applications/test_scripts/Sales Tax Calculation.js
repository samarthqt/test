describe('Sales Tax Calculation', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const paymentProcessingPage = new PaymentProcessingPage();
  const orderDetailsPage = new OrderDetailsPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should calculate sales tax correctly', () => {
    loginPage.login('username', 'password');
    dashboardPage.verifyUserDashboard();

    dashboardPage.navigateToPaymentProcessing();
    paymentProcessingPage.verifyPageLoaded();

    paymentProcessingPage.confirmTaxRatesForLocation('456 Elm St, City, State, ZIP', 8);

    dashboardPage.locateOrderById('67890');
    orderDetailsPage.verifyOrderDetailsDisplayed('67890');

    orderDetailsPage.verifySalesTaxFieldIsEmpty();

    orderDetailsPage.initiateSalesTaxCalculation();
    orderDetailsPage.verifySalesTaxCalculated(8);

    orderDetailsPage.confirmTotalAmountIncludingTax(108);

    orderDetailsPage.completeOrderCheckout();

    dashboardPage.logout();
  });
});