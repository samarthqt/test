describe('No Alert for Unsubscribed Customer', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const orderDetailsPage = new OrderDetailsPage();
  const alertSystem = new AlertSystem();
  const customerEmail = 'nonsubscriber@example.com';
  const orderId = '67890';

  before(() => {
    cy.visit('https://dynamics365.example.com');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.enterCredentials('validUser', 'validPassword');
    loginPage.submit();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to the Orders module', () => {
    dashboardPage.navigateToOrders();
    ordersPage.verifyOrdersModuleDisplayed();
  });

  it('should select the order with ID 67890', () => {
    ordersPage.selectOrderById(orderId);
    orderDetailsPage.verifyOrderDetailsDisplayed(orderId);
  });

  it('should update the shipment status to Dispatched', () => {
    orderDetailsPage.updateShipmentStatus('Dispatched');
    orderDetailsPage.verifyShipmentStatusUpdated('Dispatched');
  });

  it('should check the alert system for outgoing alerts', () => {
    alertSystem.verifyNoAlertSent(customerEmail);
  });

  it('should verify the customer's email inbox', () => {
    cy.task('checkEmail', customerEmail).then((emails) => {
      expect(emails).to.be.empty;
    });
  });
});