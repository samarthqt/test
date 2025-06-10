import { expect } from 'chai';

class LiveChatPage {

  static visitPlatform(platform) {
    cy.visit(`/${platform}`);
  }

  static navigateToSupportSection() {
    cy.get('#supportSection').click();
  }

  static verifyLiveChatOption() {
    cy.get('#liveChatOption').should('be.visible');
  }

  static verifySupportHours() {
    const currentTime = new Date().getHours();
    const supportHoursStart = 9;
    const supportHoursEnd = 17;
    expect(currentTime).to.be.within(supportHoursStart, supportHoursEnd);
  }

  static accessLiveChat() {
    cy.get('#liveChatFeature').click();
  }

  static verifyLiveChatAvailability() {
    cy.get('#liveChatAvailable').should('be.visible');
  }

  static initiateLiveChat() {
    cy.get('#initiateChat').click();
  }

  static ongoingCommunication() {
    cy.get('#chatWindow').should('contain', 'Chatting');
  }

  static verifySecureCommunication() {
    cy.get('#secureCommunication').should('exist');
  }

  static sendChatRequest() {
    cy.get('#sendChatRequest').click();
  }

  static receiveChatRequest() {
    cy.get('#requestReceived').should('exist');
  }

  static verifyImmediateAcknowledgment() {
    cy.get('#acknowledgment').should('be.visible');
  }

  static previousChatEngagement() {
    cy.get('#previousChat').click();
  }

  static navigateToChatHistory() {
    cy.get('#chatHistory').click();
  }

  static verifyChatHistoryAccess() {
    cy.get('#chatHistoryContent').should('be.visible');
  }

  static engagedInChatSession() {
    cy.get('#chatSession').should('exist');
  }

  static simulateConnectionError() {
    cy.get('#simulateError').click();
  }

  static handleConnectionError() {
    cy.get('#errorHandled').should('exist');
  }

  static askCommonQuery() {
    cy.get('#commonQuery').type('What is your return policy?');
  }

  static recognizeQuery() {
    cy.get('#queryRecognized').should('exist');
  }

  static provideAutomatedResponse() {
    cy.get('#automatedResponse').should('be.visible');
  }

  static requireEscalation() {
    cy.get('#escalateChat').click();
  }

  static initiateEscalation() {
    cy.get('#initiateEscalation').click();
  }

  static verifySeamlessIntegration() {
    cy.get('#seamlessIntegration').should('exist');
  }
}

export default LiveChatPage;