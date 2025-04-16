class CustomerPortal {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  }

  navigateToSupport() {
    cy.get('#supportSection').click();
    cy.url().should('include', '/support');
  }

  openLiveChat() {
    cy.get('#liveChatButton').click();
    cy.get('#chatWindow').should('be.visible');
  }

  enterInquiryMessage(message) {
    cy.get('#chatInput').type(message);
    cy.get('#chatInput').should('have.value', message);
  }

  sendMessage() {
    cy.get('#sendButton').click();
  }

  verifyRepresentativeJoined() {
    cy.get('#representativeJoined').should('be.visible');
  }

  engageInConversation() {
    cy.get('#chatWindow').should('contain', 'Support Representative');
  }

  requestChatTranscript() {
    cy.get('#requestTranscriptButton').click();
  }

  verifyTranscriptOption() {
    cy.get('#transcriptOptions').should('be.visible');
  }

  logout() {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  }
}