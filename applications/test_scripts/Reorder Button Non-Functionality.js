describe('Reorder Button Non-Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const orderHistoryPage = new OrderHistoryPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should not display the reorder button if there are no previous orders', () => {
    // Step 1: Log in to the user account using valid credentials
    loginPage.enterUsername('user54321');
    loginPage.enterPassword('password123');
    loginPage.clickLoginButton();

    // Assert user is redirected to the account dashboard
    dashboardPage.verifyDashboardPage();

    // Step 2: Navigate to the 'Order History' section
    dashboardPage.goToOrderHistory();

    // Assert the 'Order History' page is displayed showing no past orders
    orderHistoryPage.verifyNoPastOrders();

    // Step 3: Attempt to locate the 'Reorder' button
    orderHistoryPage.verifyReorderButtonNotPresent();
  });
});