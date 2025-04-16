describe('Order Cancellation Test Suite', () => {
  const customerId = '67890';
  const orderId = '98765';

  before(() => {
    cy.login(customerId);
  });

  it('should navigate to Active Orders section', () => {
    cy.visit('/dashboard');
    cy.get('a[href="/active-orders"]').click();
    cy.url().should('include', '/active-orders');
  });

  it('should select order for cancellation', () => {
    cy.get(`tr[data-order-id="${orderId}"]`).click();
    cy.get('.order-details').should('be.visible');
    cy.get('.order-status').should('contain', 'Pending');
  });

  it('should cancel the order', () => {
    cy.get('.cancel-order-btn').click();
    cy.get('.confirmation-prompt').should('be.visible');
    cy.get('.confirm-cancel-btn').click();
    cy.get('.cancellation-notification').should('be.visible');
  });

  it('should verify order status is updated to Cancelled', () => {
    cy.get(`tr[data-order-id="${orderId}"] .order-status`).should('contain', 'Cancelled');
  });

  it('should verify refund process initiation', () => {
    cy.get('.refund-status').should('contain', 'Processing');
  });

  it('should complete the refund process', () => {
    cy.completeRefund(orderId);
    cy.get('.refund-status').should('contain', 'Completed');
  });

  it('should verify customer receives refund notification', () => {
    cy.get('.refund-notification').should('be.visible');
  });

  it('should verify system logs for cancellation action', () => {
    cy.verifySystemLogs(orderId, 'Cancellation');
  });

  it('should check refund policy compliance', () => {
    cy.verifyRefundPolicy(orderId);
  });
});