class CustomerSupportPage {
  navigateToSupportSection() {
    cy.get('#support-section').click();
  }

  verifyLiveChatOption() {
    cy.get('#live-chat-option').should('be.visible');
  }

  accessLiveChatFeature() {
    cy.get('#live-chat-feature').click();
  }

  verifyLiveChatIntegration() {
    cy.get('#live-chat-integration').should('exist');
  }

  accessLiveChatAnytime() {
    cy.get('#live-chat-anytime').click();
  }

  verifyLiveChatAvailability() {
    cy.get('#live-chat-availability').should('contain', '24/7');
  }

  liveChatBecomesAvailable() {
    cy.get('#chat-availability').invoke('show');
  }

  verifyChatAvailabilityNotification() {
    cy.get('#chat-notification').should('be.visible');
  }

  simulateChatConnectionFailure() {
    cy.intercept('POST', '/chat/connect', { statusCode: 500 });
  }

  verifyErrorMessageForFailedConnection() {
    cy.get('#error-message').should('contain', 'Connection failed');
  }

  simulateChatInteraction() {
    cy.get('#chat-input').type('Hello!');
    cy.get('#send-button').click();
  }

  verifyChatInteractionLogging() {
    cy.get('#chat-log').should('contain', 'Hello!');
  }
}

export default CustomerSupportPage;