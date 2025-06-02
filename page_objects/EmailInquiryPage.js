import { expect } from 'chai';
import { cy } from 'cypress';

class EmailInquiryPage {
 static visit() {
 cy.visit('/email-inquiry-form');
 }

 static submitFormWithoutRequiredFields() {
 cy.get('#submitBtn').click();
 }

 static submitFormWithSomeRequiredFields() {
 cy.get('#name').type('John Doe');
 cy.get('#submitBtn').click();
 }

 static fillAllRequiredFields() {
 cy.get('#name').type('John Doe');
 cy.get('#email').type('john.doe@example.com');
 }

 static fillRequiredFieldsWithInvalidData() {
 cy.get('#name').type('J');
 cy.get('#email').type('not-an-email');
 }

 static fillRequiredFieldsLeaveOptionalBlank() {
 cy.get('#name').type('John Doe');
 cy.get('#email').type('john.doe@example.com');
 }

 static submitMultipleInquiriesQuickSuccession() {
 for (let i = 0; i < 5; i++) {
 this.fillAllRequiredFields();
 cy.get('#submitBtn').click();
 }
 }

 static submitForm() {
 cy.get('#submitBtn').click();
 }

 static verifyErrorMessageForMissingFields() {
 cy.get('.error-message').should('contain', 'required fields');
 }

 static verifySpecificMissingFieldsError() {
 cy.get('.error-message').should('contain', 'name and email are required');
 }

 static verifySubmissionBlocked() {
 cy.get('#submitBtn').should('be.disabled');
 }

 static verifyErrorForRemainingFields() {
 cy.get('.error-message').should('contain', 'email is required');
 }

 static verifyHighlightedMissingFields() {
 cy.get('#email').should('have.class', 'highlight');
 }

 static verifyNoErrorsLogged() {
 cy.readFile('logs/system.log').should('not.contain', 'error');
 }

 static verifySubmissionAttemptsRecorded() {
 cy.readFile('logs/system.log').should('contain', 'submission attempt');
 }

 static verifySuccessfulSubmission() {
 cy.get('.success-message').should('contain', 'Submission successful');
 }

 static verifyValidationErrorsForInvalidData() {
 cy.get('.error-message').should('contain', 'invalid data');
 }

 static verifyConfirmationNotification() {
 cy.get('.notification').should('contain', 'Inquiry submitted successfully');
 }

 static verifyMultipleSubmissionsHandled() {
 cy.get('.success-message').should('contain', 'Submission successful').and('have.length', 5);
 }

 static verifyUserAttemptsLoggedCorrectly() {
 cy.readFile('logs/system.log').should('contain', 'incomplete form submission attempt');
 }

 static verifyConsistentSystemPerformance() {
 cy.get('.performance-metrics').should('contain', 'consistent performance');
 }
}

export default EmailInquiryPage;