describe('No Alert for Unsubscribed Customer', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to the Orders module', () => {
    dashboardPage.navigateToOrders();
    ordersPage.verifyOrdersModuleDisplayed();
  });

  it('should select the order with ID 67890', () => {
    ordersPage.selectOrderById('67890');
    ordersPage.verifyOrderDetailsDisplayed('67890');
  });

  it('should update the shipment status to Dispatched', () => {
    ordersPage.updateShipmentStatus('Dispatched');
    ordersPage.verifyShipmentStatusUpdated('Dispatched');
  });

  it('should check the alert system for outgoing alerts', () => {
    ordersPage.checkAlertSystem('nonsubscriber@example.com');
    ordersPage.verifyNoAlertSent('nonsubscriber@example.com');
  });

  it('should verify the customer email inbox', () => {
    ordersPage.verifyNoAlertReceived('nonsubscriber@example.com');
  });
});