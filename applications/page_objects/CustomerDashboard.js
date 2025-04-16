class CustomerDashboard {
  visit() {
    cy.visit('/dashboard');
  }

  loginAsCustomer(customerID) {
    cy.get('#customer-id-input').type(customerID);
    cy.get('#login-button').click();
  }

  navigateToOrderHistory() {
    cy.get('.order-history-link').click();
  }

  selectOrderForReturn(orderID) {
    cy.get(`.order-id-${orderID}`).click();
  }

  initiateReturn() {
    cy.get('.initiate-return-button').click();
  }

  chooseRefundOption() {
    cy.get('.return-option-refund').click();
  }

  provideReturnReason(reason) {
    cy.get('.return-reason-field').type(reason);
  }

  submitReturnRequest() {
    cy.get('.submit-return-button').click();
  }

  verifyReturnConfirmation() {
    cy.get('.return-confirmation-notification').should('be.visible');
  }

  checkReturnStatus(orderID) {
    cy.get(`.order-id-${orderID} .return-status`).should('contain', 'Pending');
  }

  verifyRefundStatus(orderID, status) {
    cy.get('.payment-history-link').click();
    cy.get(`.order-id-${orderID} .refund-status`).should('contain', status);
  }

  completeRefundProcess(orderID) {
    // Simulate backend process to complete refund
    cy.task('completeRefund', { orderID });
  }

  checkReturnWindowCompliance(orderID) {
    cy.get(`.order-id-${orderID} .return-window-compliance`).should('be.within', 0, 30);
  }

  ensureCustomerNotification() {
    cy.get('.notification-center').should('contain', 'Refund notification received');
  }
}

export default CustomerDashboard;