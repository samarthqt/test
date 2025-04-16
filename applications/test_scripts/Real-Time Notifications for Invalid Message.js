describe('Real-Time Notifications for Invalid Message', () => {
  beforeEach(() => {
    cy.login('user67890');
  });

  it('should not send notification for invalid message', () => {
    cy.sendInvalidMessage('00000');
    cy.getNotificationCenter().should('not.contain', 'Invalid Message Notification');
  });

  it('should check system logs for errors', () => {
    cy.checkSystemLogs().should('contain', 'error for invalid message attempt');
  });

  it('should not redirect when opening invalid message notification', () => {
    cy.attemptToOpenNotification('Invalid Message Notification');
    cy.url().should('eq', Cypress.config().baseUrl);
  });

  it('should verify no message content is available', () => {
    cy.verifyMessageContent('00000').should('be.empty');
  });
});