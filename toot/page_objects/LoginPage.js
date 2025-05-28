import { Selector } from 'testcafe';

class LoginPage {

  static visit() {
    cy.visit('/login');
  }

  static enterEmail(email) {
    cy.get('#email').type(email);
  }

  static enterPassword(password) {
    cy.get('#password').type(password);
  }

  static clearEmail() {
    cy.get('#email').clear();
  }

  static clearPassword() {
    cy.get('#password').clear();
  }

  static togglePasswordVisibility() {
    cy.get('#passwordVisibilityToggle').click();
  }

  static selectCheckbox(checkbox) {
    cy.get(`#${checkbox}`).check();
  }

  static clickLink(link) {
    cy.contains(link).click();
  }

  static submit() {
    cy.get('#loginBtn').click();
  }

  static verifyErrorMessage(message) {
    cy.contains(message).should('be.visible');
  }

  static verifyPasswordVisibility(visible) {
    const type = visible ? 'text' : 'password';
    cy.get('#password').should('have.attr', 'type', type);
  }

  static verifyRememberedEmail() {
    cy.get('#email').should('have.value', 'user@example.com');
  }

  static checkRememberMe() {
    cy.get('#rememberMe').check();
  }

  static uncheckRememberMe() {
    cy.get('#rememberMe').uncheck();
  }

  static verifyLoginButtonEnabled(enabled) {
    const state = enabled ? 'not.be.disabled' : 'be.disabled';
    cy.get('#loginBtn').should(state);
  }

}

export default LoginPage;