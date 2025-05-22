import { Selector } from 'testcafe';

class OrdersPage {

  constructor() {
    this.ordersList = '#ordersList';
    this.orderCheckbox = (id) => `#orderCheckbox-${id}`;
    this.orderDetails = '.orderDetails';
    this.updateStatusButton = '#updateStatusButton';
    this.statusDropdown = '#statusDropdown';
    this.confirmUpdateButton = '#confirmUpdateButton';
    this.status = '.status';
    this.monitorAlertsButton = '#monitorAlertsButton';
    this.alertRecipient = '.alertRecipient';
    this.alertStatus = '.alertStatus';
    this.performanceMetrics = '#performanceMetrics';
  }

  verifyOrdersModuleIsDisplayed() {
    cy.get(this.ordersList).should('be.visible');
  }

  selectOrderById(orderId) {
    cy.get(`#order-${orderId}`).click();
  }

  selectOrdersByIdRange(startId, endId) {
    for (let id = startId; id <= endId; id++) {
      cy.get(this.orderCheckbox(id)).check();
    }
  }

  verifyOrderDetailsDisplayed() {
    cy.get(this.orderDetails).should('be.visible');
  }

  updateShipmentStatusToDispatched() {
    cy.get(this.updateStatusButton).click();
    cy.get(this.statusDropdown).select('Dispatched');
    cy.get(this.confirmUpdateButton).click();
  }

  verifyShipmentStatusUpdated() {
    cy.get(this.status).each(($el) => {
      cy.wrap($el).should('have.text', 'Dispatched');
    });
  }

  monitorOutgoingAlerts(email) {
    cy.get(this.monitorAlertsButton).click();
    cy.get(this.alertRecipient).should('contain', email);
  }

  verifyAlertsSent() {
    cy.get(this.alertStatus).should('contain', 'Sent');
  }

  verifySystemPerformanceMetrics() {
    cy.get(this.performanceMetrics).should('contain', 'Optimal');
  }
}

export default OrdersPage;