describe('Instant Shipment Tracking Alert for In-Transit', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const orderDetailsPage = new OrderDetailsPage();
  const alertSystemPage = new AlertSystemPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
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

  it('should update the shipment status to In Transit', () => {
    orderDetailsPage.updateShipmentStatus('In Transit');
    orderDetailsPage.verifyShipmentStatusIsUpdated('In Transit');
  });

  it('should check the alert system for outgoing alerts', () => {
    alertSystemPage.verifyAlertIsSent('customer@example.com', 'In Transit');
  });

  it('should verify the alert received by the customer', () => {
    alertSystemPage.verifyCustomerReceivedAlert('Your shipment is now in transit.');
  });
});