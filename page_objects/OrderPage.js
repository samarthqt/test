import { expect } from 'chai';
import { Cypress } from 'cypress';

class OrderPage {
  static login(email, password) {
    cy.visit('/login');
    cy.get('#email').type(email);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static verifyDashboard() {
    cy.url().should('include', '/dashboard');
  }

  static verifyOrderID(orderID) {
    cy.get('.order-id').should('contain', orderID);
  }

  static navigateToOrderDetails() {
    cy.get('#orderDetailsLink').click();
  }

  static verifyOrderDetails() {
    cy.get('.order-details').should('be.visible');
  }

  static verifyCustomerEmail(email) {
    cy.get('.customer-email').should('contain', email);
  }

  static selectOrder(orderID) {
    cy.get(`.order-item[data-id='${orderID}']`).click();
  }

  static verifySelectedOrderDetails(orderID) {
    cy.get('.selected-order-details').should('contain', orderID);
  }

  static verifyAccessCode(accessCode) {
    cy.get('.access-code').should('contain', accessCode);
  }

  static attemptInitiateReturn() {
    cy.get('#initiateReturnBtn').click({ force: true });
  }

  static verifyInitiateReturnDisabled() {
    cy.get('#initiateReturnBtn').should('be.disabled');
  }

  static verifyPurchaseDate(daysAgo) {
    cy.get('.purchase-date').should('contain', daysAgo);
  }

  static verifyReturnNotAllowed() {
    cy.get('.return-not-allowed').should('be.visible');
  }

  static verifyReturnPeriodExpiredNotification() {
    cy.get('.return-period-expired').should('be.visible');
  }

  static helperFunction(methodName, selector, expectedValue) {
    cy.get(selector).should(methodName, expectedValue);
  }
}

export default OrderPage;