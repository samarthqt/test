import 'cypress-xpath';
class OrdersPage {
  navigate() {
    cy.visit('/orders');
  }

  selectOrder(orderId) {
    cy.get(`[data-order-id=\${orderId}\]`).click();
  }

  updateShipmentStatus(status) {
    cy.get('#shipmentStatus').select(status);
  }

  checkAlertSystem() {
    cy.get('#alertSystem').click();
  }

  verifyOrderDetails(orderId, expectedDetails) {
    cy.get(`[data-order-id=\${orderId}\] .order-details`).should('contain', expectedDetails);
  }

  filterOrdersByStatus(status) {
    cy.get('#orderStatusFilter').select(status);
  }

  searchOrder(orderNumber) {
    cy.get('#orderSearchInput').type(orderNumber);
    cy.get('#orderSearchButton').click();
  }

  validateOrderPresence(orderNumber) {
    cy.get('.order-list').contains(orderNumber).should('be.visible');
  }

  cancelOrder(orderId) {
    cy.get(`[data-order-id=\${orderId}\] .cancel-order-button`).click();
  }

  confirmOrderCancellation(orderId) {
    cy.get(`[data-order-id=\${orderId}\] .confirm-cancellation`).click();
  }
}

export default OrdersPage;