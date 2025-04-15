describe('Invalid Email Address for Alerts', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();

  beforeEach(() => {
    cy.visit('https://dynamics365.example.com');
  });

  it('should not send alerts if the customer email address is invalid', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardIsDisplayed();

    dashboardPage.navigateToOrdersModule();
    ordersPage.verifyOrdersModuleIsDisplayed();

    ordersPage.selectOrderById('54321');
    ordersPage.verifyOrderDetailsAreDisplayed('54321');

    ordersPage.updateShipmentStatusToDelivered();
    ordersPage.verifyShipmentStatusIsDelivered();

    ordersPage.checkAlertSystemForOutgoingAlerts();
    ordersPage.verifyNoAlertIsSent();

    ordersPage.verifyErrorLogsForAlertSendingFailures('invalidemail@.com');
  });
});