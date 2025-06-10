import { expect } from 'chai';
import 'cypress-wait-until';

class RegistrationPage {
  static visit() {
    cy.visit('/register');
  }

  static enterEmailAndPassword(email = 'user@example.com', password = 'Password123') {
    cy.get('#email').type(email);
    cy.get('#password').type(password);
  }

  static submitForm() {
    cy.get('#registerBtn').click();
  }

  static verifyEmailSent() {
    cy.contains('Verification email sent').should('be.visible');
  }

  static registerWithGoogle() {
    cy.get('#googleRegisterBtn').click();
  }

  static completeGoogleAuth(email = 'user@gmail.com') {
    cy.origin('https://accounts.google.com', () => {
      cy.get('input[type=email]').type(email);
      cy.get('#identifierNext').click();
      // Add more steps as needed
    });
  }

  static registerWithFacebook() {
    cy.get('#facebookRegisterBtn').click();
  }

  static completeFacebookAuth(email = 'user@facebook.com', password = 'Password123') {
    cy.origin('https://www.facebook.com', () => {
      cy.get('#email').type(email);
      cy.get('#pass').type(password);
      cy.get('#loginbutton').click();
    });
  }

  static submitInvalidForm() {
    cy.get('#email').type('invalid-email');
    cy.get('#registerBtn').click();
  }

  static verifyErrorMessage() {
    cy.contains('Registration failed').should('be.visible');
  }

  static verifyRegistrationOptions() {
    cy.get('#emailRegisterBtn').should('be.visible');
    cy.get('#googleRegisterBtn').should('be.visible');
    cy.get('#facebookRegisterBtn').should('be.visible');
  }

  static completeRegistration(email, password) {
    this.enterEmailAndPassword(email, password);
    this.submitForm();
  }

  static verifyLogging() {
    // Verify logging mechanism, e.g., check logs or API calls
  }

  static successfulRegistration(email, password) {
    this.enterEmailAndPassword(email, password);
    this.submitForm();
    cy.contains('Welcome').should('be.visible');
  }

  static verifyProfileIntegration() {
    // Implement verification of profile integration
  }

  static startRegistration() {
    this.visit();
  }

  static verifyDataProtectionCompliance() {
    // Implement verification of data protection compliance
  }
}

export default RegistrationPage;