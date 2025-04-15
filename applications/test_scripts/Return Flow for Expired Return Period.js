describe('Return Flow for Expired Return Period', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const orderDetailsPage = new OrderDetailsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should not allow return initiation for expired return period', () => {
    // Step 1: Log in to the BFW store
    loginPage.login('customer@example.com', 'password123');
    dashboardPage.verifyDashboardIsDisplayed();

    // Step 2: Navigate to the 'Order Details' section
    dashboardPage.navigateToOrderDetails();
    orderDetailsPage.verifyOrderDetailsSectionIsDisplayed();

    // Step 3: Select the order with ID 87654
    orderDetailsPage.selectOrderById('87654');
    orderDetailsPage.verifyOrderDetailsForOrderIdIsDisplayed('87654');

    // Step 4: Attempt to click on the 'Initiate Return' button
    orderDetailsPage.verifyInitiateReturnButtonIsDisabledOrNotPresent();

    // Step 5: Verify that the system does not allow return initiation
    orderDetailsPage.verifyReturnPeriodExpiredNotification();
  });
});