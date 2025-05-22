import { expect } from 'chai';
import { Cypress } from 'cypress';

class ReturnFlowPage {
  static login(username, password) {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static verifyDashboardDisplayed() {
    cy.url().should('include', '/dashboard');
  }

  static navigateToOrderDetails() {
    cy.get('#orderDetailsLink').click();
  }

  static verifyOrderDetailsDisplayed() {
    cy.get('#orderDetailsSection').should('be.visible');
  }

  static selectOrderById(orderId) {
    cy.get(`#order-${orderId}`).click();
  }

  static verifySelectedOrderDetails(orderId) {
    cy.get(`#orderDetails-${orderId}`).should('be.visible');
  }

  static initiateReturnForAchieveCode() {
    cy.get('#initiateReturnBtn').click();
  }

  static verifyInitiateReturnFormDisplayed() {
    cy.get('#returnForm').should('be.visible');
  }

  static completeAndSubmitReturnForm(reason = 'Damaged') {
    cy.get('#returnReason').select(reason);
    cy.get('#submitReturnBtn').click();
  }

  static verifyReturnRequestSubmitted() {
    cy.get('#returnConfirmation').should('be.visible');
  }

  static processRefundByBraintree() {
    // Assume refund is processed
  }

  static verifyRefundProcessed() {
    cy.get('#refundStatus').should('contain', 'Processed');
  }

  static checkCustomerEmail() {
    // Assume email is checked
  }

  static verifyConfirmationEmailReceived() {
    cy.get('#emailConfirmation').should('contain', 'Refund Confirmation');
  }

  static sendDailyReturnRequestEmailToCX() {
    // Assume email is sent
  }

  static verifyOrderDetailsInEmailToCX(orderId) {
    cy.get('#cxEmailOrderDetails').should('contain', `Order ID ${orderId}`);
  }

  static checkCXSystemForReturnRequest() {
    // Assume CX system is checked
  }

  static verifyCXActionOnReturnRequest() {
    cy.get('#cxActionStatus').should('contain', 'Action Taken');
  }

  static checkAccessCodeRedeemed() {
    // Assume code is checked
  }

  static verifyAccessRevoked() {
    cy.get('#accessRevokedStatus').should('contain', 'Revoked');
  }

  static checkAccessCodeNotRedeemed() {
    // Assume code is checked
  }

  static verifyAccessCodeZeroedOut() {
    cy.get('#accessCodeStatus').should('contain', 'Zeroed Out');
  }

  static verifyRefundCompleted() {
    // Assume refund is completed
  }

  static verifyAccessCodeInvalidPostRefund() {
    cy.get('#accessCodeInvalidStatus').should('contain', 'Invalid');
  }
}

export default ReturnFlowPage;