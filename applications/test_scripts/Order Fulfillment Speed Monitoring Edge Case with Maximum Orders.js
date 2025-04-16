describe('Order Fulfillment Speed Monitoring Edge Case with Maximum Orders', () => {
  const orderFulfillmentPage = new OrderFulfillmentPage();

  before(() => {
    cy.visit('/order-fulfillment');
  });

  it('should place maximum allowable orders and initiate fulfillment process', () => {
    orderFulfillmentPage.placeMaximumOrders();
    orderFulfillmentPage.initiateFulfillment();
    orderFulfillmentPage.verifyOrdersAreTracked();
  });

  it('should complete the fulfillment process for all orders', () => {
    orderFulfillmentPage.completeFulfillment();
    orderFulfillmentPage.verifyEndTimesRecorded();
  });

  it('should generate a report on order fulfillment speed for all orders', () => {
    orderFulfillmentPage.generateFulfillmentReport();
    orderFulfillmentPage.verifyReportGenerated();
  });
});