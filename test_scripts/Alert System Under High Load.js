describe('Alert System Under High Load', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 system with valid credentials', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to the Orders module', () => {
    dashboardPage.navigateToOrdersModule();
    ordersPage.verifyOrdersModuleIsDisplayed();
  });

  it('should select orders with IDs ranging from 10001 to 10050', () => {
    ordersPage.selectOrdersByIdRange(10001, 10050);
    ordersPage.verifyOrderDetailsDisplayed();
  });

  it('should update the shipment status of all selected orders to Dispatched', () => {
    ordersPage.updateShipmentStatusToDispatched();
    ordersPage.verifyShipmentStatusUpdated();
  });

  it('should monitor the alert system for outgoing alerts', () => {
    ordersPage.monitorOutgoingAlerts('customer@example.com');
    ordersPage.verifyAlertsSent();
  });

  it('should verify the system's performance metrics', () => {
    ordersPage.verifySystemPerformanceMetrics();
  });
});