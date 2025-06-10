import { expect } from 'chai';
class PasswordResetPage {
 static verifyUserForgotPassword() {
 cy.get('#forgotPassword').should('exist');
 }

 static navigateToResetPage() {
 cy.get('#resetPage').click();
 }

 static enterEmailAddress(email) {
 cy.get('#emailInput').type(email);
 }

 static verifyResetLinkSent() {
 cy.get('#resetLinkMessage').should('contain', 'Password reset link sent');
 }

 static verifyPasswordResetLinkFunctionality() {
 cy.get('#resetLinkFunctionality').should('contain', 'Password can be set using reset link');
 }

 static verifyEmailInputExists() {
 cy.get('#emailInput').should('exist');
 }

 static clickSubmitButton() {
 cy.get('#submitButton').click();
 }

 static verifyErrorMessage(expectedMessage) {
 cy.get('#errorMessage').should('contain', expectedMessage);
 }

 static verifySuccessMessage(expectedMessage) {
 cy.get('#successMessage').should('contain', expectedMessage);
 }

 static performPasswordReset(email) {
 this.enterEmailAddress(email);
 this.clickSubmitButton();
 this.verifyResetLinkSent();
 }

 static validateEmailFormat(email) {
 const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
 expect(email).to.match(emailPattern);
 }
}
export default PasswordResetPage;