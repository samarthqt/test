describe('Order Tracking with Invalid Order Number', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const orderTrackingPage = new OrderTrackingPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUsername('user89012');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Order Tracking section', () => {
    dashboardPage.goToOrderTracking();
    orderTrackingPage.verifyOrderTrackingPage();
  });

  it('should display error for invalid order number', () => {
    orderTrackingPage.enterOrderNumber('99999');
    orderTrackingPage.submitOrderNumber();
    orderTrackingPage.verifyInvalidOrderMessage();
  });
});