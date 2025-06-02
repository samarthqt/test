import { expect } from 'chai';

class TwoFactorAuthPage {

  static visit() {
    cy.visit('/login');
  }

  static verifyLoginPage() {
    cy.url().should('include', '/login');
  }

  static enterCredentials(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#submit').click();
  }

  static verifyCredentialsAccepted() {
    cy.get('#welcomeMessage').should('be.visible');
  }

  static generate2FACode() {
    cy.get('#generate2FA').click();
  }

  static verify2FACodeGenerated() {
    cy.get('#2FACode').should('not.be.empty');
  }

  static waitForCodeExpiration() {
    cy.wait(29000);
  }

  static verifyCodeNearExpiration() {
    cy.get('#2FACode').should('have.class', 'near-expiration');
  }

  static enter2FACodeAndLogin(code) {
    cy.get('#2FACodeInput').type(code);
    cy.get('#loginButton').click();
  }

  static verifyLoginProcessed() {
    cy.get('#processing').should('be.visible');
  }

  static enterCodeAtExpirationBoundary(code) {
    cy.get('#2FACodeInput').type(code);
    cy.get('#loginButton').click();
  }

  static verifyCodeExpirationHandling() {
    cy.get('#expirationHandlingMessage').should('be.visible');
  }

  static verifyCodeValidity() {
    cy.get('#codeValidity').should('contain', 'valid');
  }

  static verifyLoginOutcome() {
    cy.get('#loginOutcome').should('contain', 'success');
  }

  static checkErrorMessages() {
    cy.get('#errorMessage').should('be.visible');
  }

  static verifyErrorMessageForExpiredCode() {
    cy.get('#errorMessage').should('contain', 'expired code');
  }

  static testResponseTime() {
    cy.get('#responseTime').should('be.lessThan', 1000);
  }

  static verifyPromptProcessing() {
    cy.get('#promptProcessing').should('be.visible');
  }

  static loginWithNewCode(newCode) {
    cy.get('#2FACodeInput').type(newCode);
    cy.get('#loginButton').click();
  }

  static verifyLoginWithNewCode() {
    cy.get('#loginOutcome').should('contain', 'success');
  }

  static reviewSystemLogs() {
    cy.get('#systemLogs').should('contain', 'expiration event');
  }

  static verifyCodeExpirationLogs() {
    cy.get('#logEntries').should('contain', 'code expired');
  }

  static checkSystemBehavior() {
    cy.get('#systemBehavior').should('be.visible');
  }

  static verifyNetworkHandling() {
    cy.get('#networkHandling').should('contain', 'graceful');
  }

  static testDevices() {
    cy.get('#deviceTest').should('contain', 'consistent');
  }

  static verifyDeviceConsistency() {
    cy.get('#deviceConsistency').should('be.visible');
  }

  static verifySystemPrompts() {
    cy.get('#systemPrompts').should('be.visible');
  }

  static verifyNewCodePrompt() {
    cy.get('#newCodePrompt').should('be.visible');
  }

  static ensureRetryLogin() {
    cy.get('#retryLogin').should('be.visible');
  }

  static verifyRetryLogin() {
    cy.get('#retryLogin').should('contain', 'valid code');
  }
}

export default TwoFactorAuthPage;