class OrderFulfillmentPage {
  placeMaximumOrders() {
    cy.get('#place-orders-button').click();
    cy.get('#order-ids').should('contain', '[Maximum allowable orders]');
  }

  initiateFulfillment() {
    cy.get('#initiate-fulfillment-button').click();
  }

  verifyOrdersAreTracked() {
    cy.get('#order-status').should('contain', 'Tracked');
  }

  completeFulfillment() {
    cy.get('#complete-fulfillment-button').click();
    cy.get('#fulfillment-end-time').should('contain', '2023-10-01 10:00:00');
  }

  verifyEndTimesRecorded() {
    cy.get('#end-times-recorded').should('be.visible');
  }

  generateFulfillmentReport() {
    cy.get('#generate-report-button').click();
  }

  verifyReportGenerated() {
    cy.get('#fulfillment-report').should('contain', 'Order receipt to shipment');
  }
}