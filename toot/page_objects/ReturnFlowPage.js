import { checkEmail, processRefundByBraintree } from '../helpers';

class ReturnFlowPage {

  static verifyPurchase() {
    // Code to verify purchase of Achieve access code
  }

  static checkPurchaseDate() {
    // Code to verify purchase date is within last 14 days
  }

  static login(username, password) {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static verifyDashboard() {
    cy.url().should('include', '/dashboard');
  }

  static verifyLoggedIn() {
    // Code to verify customer is logged in
  }

  static navigateToOrderDetails() {
    cy.get('#orderDetailsLink').click();
  }

  static verifyOrderList() {
    cy.get('#orderList').should('be.visible');
  }

  static verifyOrderDetailsDisplayed() {
    cy.get('#orderDetails').should('be.visible');
  }

  static selectOrder(orderId) {
    cy.get(`#order-${orderId}`).click();
  }

  static verifyOrderDetails(orderId) {
    cy.get(`#orderDetails-${orderId}`).should('be.visible');
  }

  static clickInitiateReturn() {
    cy.get('#initiateReturnBtn').click();
  }

  static verifyInitiateReturnForm() {
    cy.get('#initiateReturnForm').should('be.visible');
  }

  static submitReturnForm(details) {
    cy.get('#returnFormDetails').type(details);
    cy.get('#submitReturnFormBtn').click();
  }

  static verifyReturnSubmission() {
    cy.get('#returnConfirmation').should('be.visible');
  }

  static processRefund() {
    processRefundByBraintree();
  }

  static verifyRefundProcessing() {
    cy.get('#refundConfirmation').should('be.visible');
  }

  static checkEmailConfirmation() {
    checkEmail('Braintree');
  }

  static verifyEmailReceived() {
    cy.get('#emailConfirmation').should('contain', 'Braintree');
  }

  static verifyOrderDetailsInEmail() {
    // Code to verify order details in email to CX
  }

  static checkCXSystem() {
    // Code to check CX system for return request
  }

  static verifyCXAction() {
    // Code to verify CX action on return request
  }

  static verifyCourseAccess() {
    // Code to verify Achieve course access
  }

  static verifyAccessRevoked(status) {
    if (status === 'Redeemed') {
      cy.get('#accessRevoked').should('be.visible');
    }
  }

  static verifyAccessZeroedOut(status) {
    if (status === 'Not Redeemed') {
      cy.get('#accessZeroedOut').should('be.visible');
    }
  }

  static verifyAccessCodePostRefund() {
    cy.get('#accessCodePostRefund').should('not.be.visible');
  }

}

export default ReturnFlowPage;