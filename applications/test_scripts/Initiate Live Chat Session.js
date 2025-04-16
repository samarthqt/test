describe('TC-68572 Initiate Live Chat Session', () => {
  const customerServicePortal = new CustomerServicePortal();

  before(() => {
    // Assuming user is already logged in
    cy.visit('/customer-service-portal');
  });

  it('should initiate a live chat session', () => {
    customerServicePortal.clickLiveChatButton();
    customerServicePortal.enterSupportTopic('Billing');
    customerServicePortal.clickStartChat();

    // Assertions
    cy.get('.chat-window').should('be.visible');
    cy.get('.support-representative').should('exist');
  });
});