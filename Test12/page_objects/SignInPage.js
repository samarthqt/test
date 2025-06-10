import { expect } from 'chai';

class SignInPage {
  static visit() {
    cy.visit('/signin');
  }

  static verifyExistingAccount() {
    cy.get('#existingAccountMsg').should('be.visible');
  }

  static enterEmail(email) {
    cy.get('#email').type(email);
  }

  static enterPassword(password) {
    cy.get('#password').type(password);
  }

  static clickSignIn() {
    cy.get('#signInBtn').click();
  }

  static signInWithGoogle() {
    cy.get('#googleSignInBtn').click();
  }

  static signInWithFacebook() {
    cy.get('#facebookSignInBtn').click();
  }

  static verifyErrorMessage(expectedMessage) {
    cy.get('#errorMsg').should('be.visible').and('contain', expectedMessage);
  }

  static clickForgotPassword() {
    cy.get('#forgotPasswordLink').click();
  }

  static verifyPasswordRecoveryEmail() {
    cy.get('#recoveryEmailSentMsg').should('be.visible');
  }

  static verifySuccessfulSignIn() {
    cy.url().should('include', '/dashboard');
  }

  static verifyAuthenticationLogging() {
    cy.get('#authLogMsg').should('be.visible');
  }

  static verifySignUpOrSignIn() {
    cy.url().should('include', '/signup').or('include', '/signin');
  }

  static verifyGDPRCompliance() {
    cy.get('#gdprComplianceMsg').should('be.visible');
  }

  static fillSignInForm(email, password) {
    this.enterEmail(email);
    this.enterPassword(password);
  }

  static submitSignInForm() {
    this.clickSignIn();
  }

  static completeSignIn(email, password) {
    this.fillSignInForm(email, password);
    this.submitSignInForm();
  }
}

export default SignInPage;