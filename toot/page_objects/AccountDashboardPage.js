import { expect } from 'chai';

class AccountDashboardPage {
  static login(username, password) {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  static verifyDashboardDisplayed() {
    cy.url().should('include', '/dashboard');
    cy.get('#dashboard').should('be.visible');
  }

  static navigateToOrderDetails() {
    cy.get('#orderDetailsLink').click();
  }

  static verifyOrderDetailsDisplayed() {
    cy.get('#orderDetails').should('be.visible');
  }

  static selectOrderById(orderId) {
    cy.get(`#order-${orderId}`).click();
  }

  static verifyOrderDetailsForId(orderId) {
    cy.get(`#orderDetails-${orderId}`).should('be.visible');
  }

  static verifyAccessCodeDisplayed(accessCode) {
    cy.contains(accessCode).should('be.visible');
  }

  static attemptToInitiateReturn() {
    cy.get('#initiateReturnButton').click({ force: true });
  }

  static verifyInitiateReturnButtonDisabled() {
    cy.get('#initiateReturnButton').should('be.disabled');
  }

  static verifyReturnPeriodExpiredNotification() {
    cy.contains('Return period has expired').should('be.visible');
  }

  static verifyAccountNameDisplayed(accountName) {
    cy.get('#accountName').should('contain.text', accountName);
  }

  static logout() {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  }

  static verifySuccessfulLogout() {
    cy.get('#loginButton').should('be.visible');
  }
}

export default AccountDashboardPage;