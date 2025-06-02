import { expect } from 'chai';
import { readFileSync } from 'fs';

class TicketSubmissionPage {
 static visit() {
 cy.visit('/ticketSubmission');
 }

 static navigate() {
 cy.get('#navigateToTicketSubmission').click();
 }

 static verifyPageLoad() {
 cy.url().should('include', '/ticketSubmission');
 }

 static enterTicketId(ticketId) {
 cy.get('#ticketId').type(ticketId);
 }

 static enterUserId(userId) {
 cy.get('#userId').type(userId);
 }

 static enterDescription(description) {
 cy.get('#description').type(description);
 }

 static leaveDescriptionEmpty() {
 cy.get('#description').clear();
 }

 static submitTicket() {
 cy.get('#submitTicketBtn').click();
 }

 static verifyErrorMessage(message) {
 cy.get('.error-message').should('contain', message);
 }

 static verifySubmissionStatus(status) {
 cy.get('.submission-status').should('contain', status);
 }

 static verifyPromptMessage(message) {
 cy.get('.prompt-message').should('contain', message);
 }

 static verifyConfirmationMessage(message) {
 cy.get('.confirmation-message').should('contain', message);
 }

 static verifyTicketStatus(status) {
 cy.get('.ticket-status').should('contain', status);
 }

 static verifyResponseTime() {
 cy.get('.response-time').should('be.lessThan', 2000);
 }

 static verifyPerformanceStatus(status) {
 cy.get('.performance-status').should('contain', status);
 }

 static readErrorLogs(path) {
 const logs = readFileSync(path, 'utf8');
 expect(logs).to.contain('missing information');
 }

 static readSubmissionAttempts(path) {
 const logs = readFileSync(path, 'utf8');
 expect(logs).to.contain('submission attempts');
 }

 static resubmitTicket() {
 cy.get('#resubmitTicketBtn').click();
 }

 static submitWithDifferentMissingField() {
 cy.get('#submitDifferentFieldBtn').click();
 }

 static submitMultipleWithMissingInfo() {
 cy.get('#submitMultipleBtn').click();
 }
}

export default TicketSubmissionPage;