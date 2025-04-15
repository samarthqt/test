describe('Alert System Under High Load', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to Dynamics 365 system', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.clickLogin();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to Orders module', () => {
    dashboardPage.navigateToOrders();
    ordersPage.verifyOrdersModuleDisplayed();
  });

  it('should select orders with IDs ranging from 10001 to 10050', () => {
    ordersPage.selectOrdersInRange(10001, 10050);
    ordersPage.verifyOrderDetailsDisplayed();
  });

  it('should update shipment status to Dispatched', () => {
    ordersPage.updateShipmentStatus('Dispatched');
    ordersPage.verifyShipmentStatusUpdated('Dispatched');
  });

  it('should monitor alert system for outgoing alerts', () => {
    ordersPage.monitorAlerts('customer@example.com');
    ordersPage.verifyAlertsSentWithoutDelay();
  });

  it('should verify system performance metrics', () => {
    ordersPage.verifySystemPerformanceUnderLoad();
  });
});