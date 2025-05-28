describe('TC-7: Invalid Email Address for Alerts', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const orderDetailsPage = new OrderDetailsPage();

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

  it('should select the order with ID 54321', () => {
    ordersPage.selectOrderById('54321');
    orderDetailsPage.verifyOrderDetailsDisplayed('54321');
  });

  it('should update the shipment status to Delivered and check alerts', () => {
    orderDetailsPage.updateShipmentStatus('Delivered');
    orderDetailsPage.verifyShipmentStatus('Delivered');
    orderDetailsPage.checkAlertSystemForOutgoingAlerts();
    orderDetailsPage.verifyNoAlertSent();
  });

  it('should verify error logs for alert sending failures', () => {
    orderDetailsPage.verifyErrorLogForAlertFailure('invalidemail@.com');
  });
});