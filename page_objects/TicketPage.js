import 'cypress-file-upload';
class TicketPage {
 static login() {
 cy.login();
 }
 static navigateToSupportSection() {
 cy.get('.support-section').click();
 }
 static verifySupportSectionDisplayed() {
 cy.get('.support-section').should('be.visible');
 }
 static verifyInSupportSection() {
 cy.url().should('include', '/support');
 }
 static selectSubmitTicketOption() {
 cy.get('.submit-ticket-btn').click();
 }
 static verifyTicketFormDisplayed() {
 cy.get('.ticket-form').should('be.visible');
 }
 static fillInTicketDetails(title, description) {
 cy.get('#ticket-title').type(title);
 cy.get('#ticket-description').type(description);
 }
 static verifyFormInputAccepted(title, description) {
 cy.get('#ticket-title').should('have.value', title);
 cy.get('#ticket-description').should('have.value', description);
 }
 static verifyFormFilled(title) {
 cy.get('.ticket-form').should('contain.text', title);
 }
 static attachDocuments(filePath) {
 cy.get('#attachment').attachFile(filePath);
 }
 static verifyDocumentsAttached() {
 cy.get('.attachment-success').should('be.visible');
 }
 static verifyFormCompleted(description) {
 cy.get('.ticket-form').should('contain.text', description);
 }
 static submitTicket() {
 cy.get('.submit-ticket').click();
 }
 static verifyTicketSubmissionSuccessful() {
 cy.get('.confirmation-message').should('be.visible');
 }
 static checkEmail() {
 cy.checkEmail();
 }
 static verifyConfirmationEmailReceived() {
 cy.get('.email-confirmation').should('contain.text', 'Ticket Submitted');
 }
 static startTicketSubmission() {
 cy.get('.ticket-form').should('be.visible');
 }
 static completeSubmissionProcess() {
 cy.get('.submit-ticket').click();
 }
 static verifyNoErrorMessages() {
 cy.get('.error-message').should('not.exist');
 }
 static startFillingForm() {
 cy.get('.ticket-form').should('be.visible');
 }
 static submitIncompleteForm() {
 cy.get('.submit-ticket').click();
 }
 static verifyMissingFieldsPrompt() {
 cy.get('.missing-fields-alert').should('be.visible');
 }
 static accessOnMobileDevice() {
 cy.viewport('iphone-x');
 }
 static navigateAndSelectOnMobile() {
 cy.get('.support-section').click();
 cy.get('.submit-ticket-btn').click();
 }
 static verifyFormOnMobile() {
 cy.get('.ticket-form').should('be.visible');
 }
 static processTicket() {
 cy.wait(2000);
 }
 static verifyTicketLoggedInCRM() {
 cy.get('.crm-log').should('contain.text', 'Ticket Recorded');
 }
 static accessOnDifferentBrowsers() {
 cy.visit('/support');
 }
 static navigateToTicketForm() {
 cy.get('.ticket-form').click();
 }
 static verifyBrowserCompatibility() {
 cy.get('.ticket-form').should('be.visible');
 }
 static verifyResponseTime() {
 cy.get('.response-time').should('be.lessThan', 3000);
 }
 static simulatePeakTimes() {
 cy.server({ delay: 1000 });
 }
 static verifyPeakPerformance() {
 cy.get('.performance-message').should('not.exist');
 }
 static accessTicketStatus() {
 cy.get('.ticket-status').click();
 }
 static verifyTicketStatusViewable() {
 cy.get('.ticket-status-details').should('be.visible');
 }
 static startMultipleTicketSubmission() {
 cy.get('.multiple-tickets').should('be.visible');
 }
 static submitMultipleTickets() {
 cy.get('.submit-tickets').click();
 }
 static verifyMultipleSubmissionSuccess() {
 cy.get('.multi-submission-success').should('be.visible');
 }
}
export default TicketPage;