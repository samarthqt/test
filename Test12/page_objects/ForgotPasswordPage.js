import { expect } from 'chai';

class ForgotPasswordPage {

  static visit() {
    cy.visit('/forgot-password');
  }

  static enterEmail(email) {
    cy.get('#emailInput').type(email);
  }

  static recoverViaEmail() {
    cy.get('#recoverEmailBtn').click();
  }

  static verifyEmailSent() {
    cy.get('#emailSentConfirmation').should('be.visible');
  }

  static enterPhoneNumber(phoneNumber) {
    cy.get('#phoneInput').type(phoneNumber);
  }

  static recoverViaSMS() {
    cy.get('#recoverSMSBtn').click();
  }

  static verifySMSSent() {
    cy.get('#smsSentConfirmation').should('be.visible');
  }

  static initiateRecoveryRequest() {
    cy.get('#initiateRecoveryRequest').click();
  }

  static sendSecureToken() {
    cy.get('#sendTokenBtn').click();
  }

  static validateIdentityWithToken() {
    cy.get('#validateToken').should('be.visible');
  }

  static useExpiredToken() {
    cy.get('#expiredToken').click();
  }

  static displayExpiredTokenError() {
    cy.get('#expiredTokenError').should('be.visible');
  }

  static successfulPasswordReset() {
    cy.get('#resetSuccess').click();
  }

  static completePasswordReset() {
    cy.get('#completeReset').click();
  }

  static confirmSuccessfulReset() {
    cy.get('#confirmationMessage').should('be.visible');
  }

  static invalidToken() {
    cy.get('#invalidToken').click();
  }

  static resetWithInvalidToken() {
    cy.get('#resetInvalidToken').click();
  }

  static displayInvalidTokenError() {
    cy.get('#invalidTokenError').should('be.visible');
  }

  static initiateResetRequest() {
    cy.get('#initiateReset').click();
  }

  static processRequest() {
    cy.get('#processRequest').click();
  }

  static logResetRequest() {
    cy.get('#logRequest').should('be.visible');
  }

  static handleUserData() {
    cy.get('#handleData').click();
  }

  static processResetRequests() {
    cy.get('#processRequests').click();
  }

  static complyWithGDPR() {
    cy.get('#gdprCompliance').should('be.visible');
  }

  static verifyPageTitle(expectedTitle) {
    cy.title().should('eq', expectedTitle);
  }

  static verifyUrlContains(substring) {
    cy.url().should('include', substring);
  }

}

export default ForgotPasswordPage;