describe('Instant Shipment Tracking Alert for In-Transit', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const orderDetailsPage = new OrderDetailsPage();
  const alertSystem = new AlertSystem();

  before(() => {
    cy.visit('/login');
    loginPage.login('validUsername', 'validPassword');
  });

  it('should display the dashboard after login', () => {
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to Orders module', () => {
    dashboardPage.navigateToOrders();
    ordersPage.verifyOrdersModuleDisplayed();
  });

  it('should select the order with ID 12345', () => {
    ordersPage.selectOrder('12345');
    orderDetailsPage.verifyOrderDetailsDisplayed('12345');
  });

  it('should update the shipment status to In Transit', () => {
    orderDetailsPage.updateShipmentStatus('In Transit');
    orderDetailsPage.verifyShipmentStatus('In Transit');
  });

  it('should check the alert system for outgoing alerts', () => {
    alertSystem.verifyAlertSent('customer@example.com', 'Your shipment is now in transit.');
  });

  it('should verify the alert received by the customer', () => {
    alertSystem.verifyCustomerReceivedAlert('customer@example.com', 'Your shipment is now in transit.');
  });
});