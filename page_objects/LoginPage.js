import { Selector } from 'testcafe';

class LoginPage {
  constructor() {
    this.usernameInput = Selector('#username');
    this.passwordInput = Selector('#password');
    this.loginButton = Selector('#loginButton');
    this.emailInput = Selector('#email');
    this.customerIdInput = Selector('#customer-id');
    this.submitButton = Selector('button[type=submit]');
  }

  visit() {
    cy.visit('/login');
  }

  enterUsername(username) {
    cy.get(this.usernameInput).type(username);
  }

  enterPassword(password) {
    cy.get(this.passwordInput).type(password);
  }

  enterEmail(email) {
    cy.get(this.emailInput).type(email);
  }

  enterCustomerId(customerId) {
    cy.get(this.customerIdInput).type(customerId);
  }

  clickLogin() {
    cy.get(this.loginButton).click();
  }

  submit() {
    cy.get(this.submitButton).click();
  }

  loginWithUsername(username, password) {
    this.enterUsername(username);
    this.enterPassword(password);
    this.clickLogin();
  }

  loginWithEmail(email, password) {
    this.enterEmail(email);
    this.enterPassword(password);
    this.submit();
  }

  loginWithCustomerId(customerId, password) {
    this.enterCustomerId(customerId);
    this.enterPassword(password);
    this.clickLogin();
  }

  verifyLogoutSuccess() {
    cy.url().should('include', '/login');
    cy.get(this.loginButton).should('be.visible');
  }
}

export default LoginPage;