import { expect } from 'chai';
import { Cypress } from 'cypress';

class SocialMediaLoginPage {
  static visit() {
    cy.visit('/login');
  }

  static selectSocialMediaLogin(platform) {
    cy.get(`button[data-platform=${platform}]`).click();
  }

  static verifyRedirection(platform) {
    cy.url().should('include', `/${platform.toLowerCase()}-login`);
  }

  static enterValidCredentials(platform) {
    cy.get(`#${platform.toLowerCase()}-username`).type('validUser');
    cy.get(`#${platform.toLowerCase()}-password`).type('validPassword');
    cy.get(`#${platform.toLowerCase()}-login-button`).click();
  }

  static enterInvalidCredentials(platform) {
    cy.get(`#${platform.toLowerCase()}-username`).type('invalidUser');
    cy.get(`#${platform.toLowerCase()}-password`).type('invalidPassword');
    cy.get(`#${platform.toLowerCase()}-login-button`).click();
  }

  static authorizeApplication() {
    cy.get('#authorize-button').click();
  }

  static denyAuthorization() {
    cy.get('#deny-button').click();
  }

  static verifyHomePageRedirection() {
    cy.url().should('include', '/home');
  }

  static verifySuccessfulLogin() {
    cy.get('#welcome-message').should('be.visible');
  }

  static verifyInvalidCredentialsError() {
    cy.get('#error-message').should('contain', 'Invalid credentials');
  }

  static verifyNotLoggedIn() {
    cy.get('#login-button').should('be.visible');
  }

  static verifyLoginPageRedirection() {
    cy.url().should('include', '/login');
  }

  static checkSocialMediaOptions() {
    cy.get('#social-media-options').should('be.visible');
  }

  static verifySocialMediaOptions() {
    cy.get('#social-media-options').within(() => {
      cy.contains('Facebook');
      cy.contains('Google');
      cy.contains('Twitter');
      cy.contains('LinkedIn');
    });
  }
}

export default SocialMediaLoginPage;