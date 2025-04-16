class OrderPage {
  placeOrder(orderId) {
    cy.get('#order-id').type(orderId);
    cy.get('#place-order').click();
  }

  verifyFulfillmentStarted() {
    cy.get('#fulfillment-status').should('contain', 'Started');
  }

  completeFulfillment(startTime, endTime) {
    cy.get('#fulfillment-start-time').type(startTime);
    cy.get('#fulfillment-end-time').type(endTime);
    cy.get('#complete-fulfillment').click();
  }

  verifyFulfillmentCompleted() {
    cy.get('#fulfillment-status').should('contain', 'Completed');
  }
}

class ReportPage {
  generateFulfillmentReport() {
    cy.get('#generate-report').click();
  }

  verifyReportGenerated(orderId, startTime, endTime) {
    cy.get('#report-order-id').should('contain', orderId);
    cy.get('#report-start-time').should('contain', startTime);
    cy.get('#report-end-time').should('contain', endTime);
  }
}