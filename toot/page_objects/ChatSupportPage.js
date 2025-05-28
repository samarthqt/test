import { expect } from 'chai';
import { cy } from 'cypress';

class ChatSupportPage {
 static visit() {
 cy.visit('/chat-support');
 }

 static verifySystemOperational() {
 cy.get('#systemStatus').should('contain', 'Operational');
 }

 static verifyRepresentativeLoggedIn() {
 cy.get('#repStatus').should('contain', 'Logged In');
 }

 static startChat() {
 cy.get('#startChatBtn').click();
 }

 static verifyChatSessionInitiated() {
 cy.get('#chatSessionStatus').should('contain', 'Active');
 }

 static verifyWelcomeMessage() {
 cy.get('#welcomeMessage').should('be.visible');
 }

 static sendChatRequestToRepresentative() {
 cy.get('#sendRequestBtn').click();
 }

 static verifyNotificationReceived() {
 cy.get('#notification').should('contain', 'New Chat Request');
 }

 static verifyChatSessionDisplayed() {
 cy.get('#repChatInterface').should('be.visible');
 }

 static customerSendMessage(message) {
 cy.get('#customerMessageInput').type(message);
 cy.get('#sendBtn').click();
 }

 static verifyMessageInChatWindow(message) {
 cy.get('#chatWindow').should('contain', message);
 }

 static verifyCustomerMessageSent(message) {
 cy.get('#chatWindow').should('contain', `Customer: ${message}`);
 }

 static representativeSendResponse(response) {
 cy.get('#repMessageInput').type(response);
 cy.get('#sendBtn').click();
 }

 static verifyResponseInChatWindow(response) {
 cy.get('#chatWindow').should('contain', `Representative: ${response}`);
 }

 static customerEndChat() {
 cy.get('#endChatBtn').click();
 }

 static representativeEndChat() {
 cy.get('#endChatBtn').click();
 }

 static verifyChatSessionTerminated() {
 cy.get('#chatSessionStatus').should('contain', 'Terminated');
 }

 static verifyFeedbackFormDisplayed() {
 cy.get('#feedbackForm').should('be.visible');
 }

 static verifyChatSummaryDisplayed() {
 cy.get('#chatSummary').should('be.visible');
 }

 static simulateInactivityTimeout() {
 cy.wait(60000); // simulate timeout
 }

 static verifyChatSessionAutoEnded() {
 cy.get('#chatSessionStatus').should('contain', 'Auto-ended');
 }

 static verifyTimeoutNotification() {
 cy.get('#timeoutNotification').should('be.visible');
 }
}

export default ChatSupportPage;