class ChatPage {
  navigateToSupportSection() {
    cy.get('#support-section').click();
  }

  startLiveChat(inquiry) {
    cy.get('#live-chat-button').click();
    cy.get('#chat-user-details').type('User Details');
    cy.get('#chat-inquiry').type(inquiry);
    cy.get('#submit-chat').click();
  }

  waitForAgentResponse() {
    cy.get('#agent-response', { timeout: 10000 }).should('be.visible');
  }

  engageWithAgent() {
    cy.get('#chat-input').type('Thank you for the information.');
    cy.get('#send-chat').click();
  }

  verifyAgentInformation() {
    cy.get('#agent-info').should('contain', 'accurate and helpful');
  }

  endChatSession() {
    cy.get('#end-chat').click();
    cy.get('#rate-chat').should('be.visible');
  }

  rateChatSupport() {
    cy.get('#rate-chat').click();
    cy.get('#submit-rating').click();
  }

  verifyChatHistory() {
    cy.get('#chat-history').should('be.visible');
  }

  testNonBusinessHours() {
    cy.get('#live-chat-button').click();
    cy.get('#non-business-message').should('contain', 'Support not available');
  }

  testNonRegisteredUser() {
    cy.get('#live-chat-button').click();
    cy.get('#limited-functionality').should('be.visible');
  }
}

class LoginPage {
  login(userId) {
    cy.visit('/login');
    cy.get('#user-id').type(userId);
    cy.get('#login-button').click();
    cy.get('#welcome-message').should('contain', 'Welcome');
  }

  logout() {
    cy.get('#logout-button').click();
  }
}