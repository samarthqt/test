describe('Order Shipment Tracking', () => {
  const orderID = 'ORD123456';
  const expectedDeliveryDate = '2023-11-15';

  beforeEach(() => {
    cy.login(); // Custom command to log the user in
    cy.visit('/order-tracking');
  });

  it('should display the order tracking page', () => {
    cy.url().should('include', '/order-tracking');
    cy.get(OrderTrackingPage.orderIDField).should('be.visible');
  });

  it('should display order details for the given order ID', () => {
    cy.get(OrderTrackingPage.orderIDField).type(orderID);
    cy.get(OrderTrackingPage.submitButton).click();
    cy.get(OrderTrackingPage.orderDetails).should('contain', orderID);
  });

  it('should display the current status of the order', () => {
    cy.get(OrderTrackingPage.orderIDField).type(orderID);
    cy.get(OrderTrackingPage.submitButton).click();
    cy.get(OrderTrackingPage.orderStatus).should('be.visible');
  });

  it('should verify the expected delivery date', () => {
    cy.get(OrderTrackingPage.orderIDField).type(orderID);
    cy.get(OrderTrackingPage.submitButton).click();
    cy.get(OrderTrackingPage.expectedDeliveryDate).should('contain', expectedDeliveryDate);
  });
});