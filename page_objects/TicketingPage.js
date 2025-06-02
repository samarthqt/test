import 'cypress-file-upload';
class TicketingPage {
 static visit() {
 cy.visit('/ticketing');
 }

 static navigateToSubmissionPage() {
 cy.get('#navigateToSubmission').click();
 }

 static verifySubmissionPageLoaded() {
 cy.url().should('include', '/submission');
 }

 static selectLanguage(language) {
 cy.get('#languageDropdown').select(language);
 }

 static verifyLanguageChange(language) {
 cy.get('body').should('have.class', `lang-${language.toLowerCase()}`);
 }

 static enterTicketDetails(language) {
 cy.get('#ticketDetails').type(`Details in ${language}`);
 }

 static verifyTicketDetailsLanguage(language) {
 cy.get('#ticketDetails').should('contain', `Details in ${language}`);
 }

 static attachFile(fileName) {
 cy.get('#fileUpload').attachFile(fileName);
 }

 static verifyFileAttachment(fileName) {
 cy.get('#uploadedFiles').should('contain', fileName);
 }

 static submitTicket() {
 cy.get('#submitTicket').click();
 }

 static verifySuccessfulSubmission() {
 cy.get('#successMessage').should('be.visible');
 }

 static generateConfirmationMessage() {
 cy.get('#generateConfirmation').click();
 }

 static verifyConfirmationMessageLanguage(language) {
 cy.get('#confirmationMessage').should('contain', language);
 }

 static verifyTicketSubmission() {
 cy.get('#ticketStatus').should('contain', 'Submitted');
 }

 static checkTicketStatus() {
 cy.get('#checkStatus').click();
 }

 static verifyTicketStatus() {
 cy.get('#status').should('contain', 'Successful');
 }

 static retrieveAttachedFile() {
 cy.get('#retrieveFile').click();
 }

 static verifyFileRetrieval() {
 cy.get('#fileContent').should('be.visible');
 }

 static logSubmissionDetails() {
 cy.get('#logDetails').click();
 }

 static verifyLogDetails() {
 cy.get('#log').should('contain', 'Language').and('contain', 'File Attachment');
 }

 static retrieveTicket() {
 cy.get('#retrieveTicket').click();
 }

 static observePerformance() {
 cy.get('#performanceMetrics').should('be.visible');
 }

 static verifyPerformance() {
 cy.get('#performance').should('not.contain', 'degradation');
 }

 static switchLanguagePreferences() {
 cy.get('#switchLanguage').click();
 }

 static verifyDataIntegrity() {
 cy.get('#dataIntegrity').should('not.contain', 'loss');
 }
}

export default TicketingPage;