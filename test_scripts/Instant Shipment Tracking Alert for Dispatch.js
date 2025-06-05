describe('Instant Shipment Tracking Alert for Dispatch', () => {
  const loginPage = new LoginPage();
  const ordersPage = new OrdersPage();
  const alertSystem = new AlertSystem();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the Dynamics 365 system with valid credentials', () => {
    loginPage.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Orders module', () => {
    ordersPage.navigateToOrdersModule();
    ordersPage.verifyOrdersModuleDisplayed();
  });

  it('should select the order with ID 12345', () => {
    ordersPage.selectOrderById('12345');
    ordersPage.verifyOrderDetailsDisplayed('12345');
  });

  it('should update the shipment status to Dispatched', () => {
    ordersPage.updateShipmentStatus('12345', 'Dispatched');
    ordersPage.verifyShipmentStatusUpdated('12345', 'Dispatched');
  });

  it('should check the alert system for outgoing alerts', () => {
    alertSystem.checkOutgoingAlerts('customer@example.com');
    alertSystem.verifyAlertSent('customer@example.com', 'Your shipment has been dispatched.');
  });

  it('should verify the alert received by the customer', () => {
    alertSystem.verifyCustomerAlertReceived('customer@example.com');
  });
});