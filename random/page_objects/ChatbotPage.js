class ChatbotPage {
  verifyChatbotIsActive() {
    cy.get('.chatbot-active').should('be.visible');
  }

  askCommonBankingQuery() {
    cy.get('.chat-input').type('What is my account balance?{enter}');
  }

  verifyChatbotResponse() {
    cy.get('.chat-response').should('contain', 'Your account balance is');
  }

  verifyHandlingMultipleQueries(count) {
    for (let i = 0; i < count; i++) {
      this.askCommonBankingQuery();
      this.verifyChatbotResponse();
    }
  }

  sendQuery() {
    cy.get('.chat-input').type('How do I reset my password?{enter}');
  }

  verifyResponseTime(maxTime) {
    cy.get('.chat-response', { timeout: maxTime }).should('be.visible');
  }

  simulateUnresolvedQuery() {
    cy.get('.chat-input').type('I need help with a complex issue{enter}');
    cy.get('.chat-response').should('contain', 'Please hold on while we connect you to a human agent');
  }

  verifyEscalationToHumanAgent() {
    cy.get('.human-agent').should('be.visible');
  }

  interactWithChatbot() {
    cy.get('.chat-input').type('Tell me about your services{enter}');
  }

  verifyDataPrivacyCompliance() {
    cy.get('.privacy-compliance').should('be.visible');
  }

  finishInteraction() {
    cy.get('.chat-input').type('Thank you!{enter}');
  }

  verifyRatingFeature() {
    cy.get('.rating').should('be.visible');
  }
}

export default ChatbotPage;