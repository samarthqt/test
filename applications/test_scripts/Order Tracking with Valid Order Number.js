describe('Order Tracking with Valid Order Number', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const orderTrackingPage = new OrderTrackingPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should track order status with valid order number', () => {
    // Step 1: Log in to the user account using valid credentials
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyUserLoggedIn();

    // Step 2: Navigate to the 'Order Tracking' section
    dashboardPage.goToOrderTracking();
    orderTrackingPage.verifyOrderTrackingPage();

    // Step 3: Enter a valid order number and submit the request
    orderTrackingPage.enterOrderNumber('45678');
    orderTrackingPage.submitOrderTracking();
    orderTrackingPage.verifyOrderStatusDisplayed();
  });
});