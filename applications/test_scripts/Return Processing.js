describe('TC-389 302 Return Processing', () => {
  const customerID = '12345';
  const orderID = '54321';

  before(() => {
    cy.visit('/login');
    cy.loginAsCustomer(customerID);
  });

  it('should navigate to Order History and select the order for return', () => {
    cy.get('.order-history-link').click();
    cy.get(`.order-id-${orderID}`).click();
  });

  it('should initiate a return for the selected order', () => {
    cy.get('.initiate-return-button').click();
    cy.get('.return-option-refund').click();
    cy.get('.return-reason-field').type('Product not as expected');
    cy.get('.submit-return-button').click();
  });

  it('should verify return confirmation and status', () => {
    cy.get('.return-confirmation-notification').should('be.visible');
    cy.get('.order-history-link').click();
    cy.get(`.order-id-${orderID} .return-status`).should('contain', 'Pending');
  });

  it('should ensure refund process initiation and verify status', () => {
    cy.get('.payment-history-link').click();
    cy.get(`.order-id-${orderID} .refund-status`).should('contain', 'Processing');
  });

  it('should simulate refund process completion and verify final status', () => {
    cy.completeRefundProcess(orderID);
    cy.get('.payment-history-link').click();
    cy.get(`.order-id-${orderID} .refund-status`).should('contain', 'Completed');
  });

  it('should check return window compliance and customer notification', () => {
    cy.get('.order-id-${orderID} .return-window-compliance').should('be.within', 0, 30);
    cy.get('.notification-center').should('contain', 'Refund notification received');
  });
});