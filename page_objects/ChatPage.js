import { expect } from 'chai';
import { cy } from 'cypress';

class ChatPage {
  
  static login() {
    cy.visit('/login');
    cy.get('#username').type('validUser');
    cy.get('#password').type('validPassword');
    cy.get('#loginBtn').click();
  }

  static enableLiveChat() {
    cy.get('#liveChatToggle').should('be.checked');
  }

  static goToSupportSection() {
    cy.get('#supportSectionLink').click();
  }

  static verifySupportSection() {
    cy.get('#supportOptions').should('be.visible');
  }

  static initiateLiveChat() {
    cy.get('#initiateChatBtn').click();
  }

  static verifyLiveChatInitiation() {
    cy.get('#chatAgent').should('be.visible');
  }

  static engageInConversation() {
    cy.get('#chatInput').type('Hello').type('{enter}');
  }

  static verifyConversation() {
    cy.get('#chatMessages').should('contain', 'Hello');
  }

  static endLiveChat() {
    cy.get('#endChatBtn').click();
  }

  static verifyLiveChatEnd() {
    cy.get('#confirmationMessage').should('be.visible');
  }

  static goToChatHistory() {
    cy.get('#chatHistoryLink').click();
  }

  static verifyChatHistory() {
    cy.get('#pastSessions').should('be.visible');
  }

  static selectRecentChat() {
    cy.get('#recentChat').click();
  }

  static verifyTranscriptDisplay() {
    cy.get('#transcript').should('be.visible');
  }

  static viewChatTranscript() {
    cy.get('#transcriptView').click();
  }

  static verifyTranscriptAccuracy() {
    cy.get('#transcriptContent').should('contain', 'entire conversation');
  }

  static checkDownloadPrintOptions() {
    cy.get('#downloadPrintOptions').click();
  }

  static verifyDownloadPrintOptions() {
    cy.get('#downloadBtn').should('be.visible');
    cy.get('#printBtn').should('be.visible');
  }

  static accessTranscriptsOnDifferentDevice() {
    cy.visit('/chatHistory');
  }

  static verifyTranscriptsAccessibility() {
    cy.get('#pastSessions').should('be.visible');
  }

  static verifySecurityPrivacy() {
    cy.get('#securityCheck').should('be.visible');
  }

  static checkRetentionPeriod() {
    cy.get('#retentionPolicy').click();
  }

  static verifyRetentionPolicy() {
    cy.get('#retentionDetails').should('contain', 'specified period');
  }

  static testWithSlowInternet() {
    cy.visit('/chatHistory', { timeout: 10000 });
  }

  static verifyTranscriptAccessWithDelay() {
    cy.get('#transcripts').should('be.visible');
  }

  static verifyDifferentChatTypes() {
    cy.get('#chatTypes').click();
  }

  static verifyAllChatTypesTranscripts() {
    cy.get('#allTranscripts').should('be.visible');
  }

  static checkForErrorMessages() {
    cy.get('#errorLogs').click();
  }

  static verifyNoErrorMessages() {
    cy.get('#errorLogs').should('not.contain', 'error');
  }
}

export default ChatPage;