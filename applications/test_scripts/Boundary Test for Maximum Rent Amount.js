describe('TC-826 404 Boundary Test for Maximum Rent Amount', () => {
  const tenantId = '67890';
  const creditCardNumber = '4111111111111111';
  const expiryDate = '12/25';
  const cvv = '123';
  const rentAmount = '999999';

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the tenant portal', () => {
    const loginPage = new LoginPage();
    loginPage.login(tenantId);
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Payments section', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.goToPayments();
    cy.url().should('include', '/payments');
  });

  it('should select Credit Card as the payment method', () => {
    const paymentsPage = new PaymentsPage();
    paymentsPage.selectPaymentMethod('Credit Card');
    paymentsPage.verifyCreditCardFormDisplayed();
  });

  it('should enter credit card details', () => {
    const paymentsPage = new PaymentsPage();
    paymentsPage.enterCreditCardDetails(creditCardNumber, expiryDate, cvv);
    paymentsPage.verifyDetailsAccepted();
  });

  it('should enter maximum rent amount', () => {
    const paymentsPage = new PaymentsPage();
    paymentsPage.enterRentAmount(rentAmount);
    paymentsPage.verifyRentAmountAccepted();
  });

  it('should process the payment', () => {
    const paymentsPage = new PaymentsPage();
    paymentsPage.clickPayNow();
    paymentsPage.verifyPaymentProcessed();
  });

  it('should verify the transaction in the payment history', () => {
    const paymentsPage = new PaymentsPage();
    paymentsPage.verifyTransactionInHistory(rentAmount);
  });
});