class CustomerServicePage {
  navigateToCustomerServicePage() {
    cy.visit('/customer-service');
    cy.contains('Customer Service').should('be.visible');
  }

  clickLiveChatButton() {
    cy.get('#liveChatButton').click();
    cy.get('.chatWindow').should('be.visible');
  }

  enterChatInquiry(inquiry) {
    cy.get('.chatInput').type(inquiry);
    cy.get('.chatSubmit').click();
    cy.get('.chatMessages').should('contain', inquiry);
  }

  verifyChatResponse() {
    cy.get('.chatMessages').should('contain', 'How can I assist you today?');
  }
}

export default CustomerServicePage;