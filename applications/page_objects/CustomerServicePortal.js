class CustomerServicePortal {
  clickLiveChatButton() {
    cy.get('.live-chat-button').click();
  }

  enterSupportTopic(topic) {
    cy.get('.support-topic-field').type(topic);
  }

  clickStartChat() {
    cy.get('.start-chat-button').click();
  }
}