class ChatPage {
  startChatSession(userId) {
    cy.get('#start-chat').click();
    cy.get('#user-id').type(userId);
    cy.get('#submit').click();
  }

  verifySessionTimeout() {
    cy.get('#chat-status').should('contain', 'Session timed out due to inactivity');
  }

  sendMessage(message) {
    cy.get('#message-input').type(message);
    cy.get('#send-message').click();
  }

  verifyMessageFailedToSend() {
    cy.get('#error-notification').should('contain', 'Message failed to send');
  }

  endChatSession() {
    cy.get('#end-chat').click();
  }
}