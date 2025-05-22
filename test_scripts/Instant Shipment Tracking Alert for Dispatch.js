describe('Instant Shipment Tracking Alert for Dispatch', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const orderDetailsPage = new OrderDetailsPage();
  const alertSystem = new AlertSystem();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to the Orders module', () => {
    dashboardPage.goToOrdersModule();
    ordersPage.verifyOrdersModuleIsDisplayed();
  });

  it('should select the order with ID 12345', () => {
    ordersPage.selectOrderById('12345');
    orderDetailsPage.verifyOrderDetailsAreDisplayed('12345');
  });

  it('should update the shipment status to Dispatched', () => {
    orderDetailsPage.updateShipmentStatus('Dispatched');
    orderDetailsPage.verifyShipmentStatusIsUpdated('Dispatched');
  });

  it('should check the alert system for outgoing alerts', () => {
    alertSystem.verifyAlertIsSent('customer@example.com', 'Your shipment has been dispatched.');
  });

  it('should verify the alert received by the customer', () => {
    alertSystem.verifyCustomerReceivedAlert('customer@example.com', 'Your shipment has been dispatched.');
  });
});