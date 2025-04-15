describe('Instant Shipment Tracking Alert for Delivery Confirmation', () => {
  const loginPage = new LoginPage();
  const ordersPage = new OrdersPage();
  const orderDetailsPage = new OrderDetailsPage();

  before(() => {
    cy.visit('https://dynamics365.example.com');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Orders module', () => {
    ordersPage.goToOrdersModule();
    ordersPage.verifyOrdersModuleDisplayed();
  });

  it('should select the order with ID 12345', () => {
    ordersPage.selectOrderById('12345');
    orderDetailsPage.verifyOrderDetailsDisplayed('12345');
  });

  it('should update the shipment status to Delivered', () => {
    orderDetailsPage.updateShipmentStatus('Delivered');
    orderDetailsPage.verifyShipmentStatus('Delivered');
  });

  it('should check the alert system for outgoing alerts', () => {
    orderDetailsPage.checkAlertSystem();
    orderDetailsPage.verifyAlertSent('customer@example.com');
  });

  it('should verify the alert received by the customer', () => {
    cy.verifyEmailReceived('customer@example.com', 'Your shipment has been delivered.');
  });
});