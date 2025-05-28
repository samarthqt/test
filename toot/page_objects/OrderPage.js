import { expect } from 'chai';
import 'cypress-xpath';

class OrderPage {
  static visitLoginPage() {
    cy.visit('/login');
  }

  static login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static configureEmailSettings() {
    cy.get('#emailSettings').check();
  }

  static verifyOrderInSystem(orderId) {
    cy.request(`/orders/${orderId}`).its('body').should('exist');
  }

  static updateOrderStatus(status) {
    cy.get('#orderStatus').select(status);
    cy.get('#updateStatusBtn').click();
  }

  static verifyEmailSent() {
    cy.get('#emailNotification').should('be.visible');
  }

  static verifyEmailSubject(subject) {
    cy.get('#emailSubject').should('contain', subject);
  }

  static verifyEmailBodyContains(text) {
    cy.get('#emailBody').should('contain', text);
  }

  static verifyNoEmailSent() {
    cy.get('#emailNotification').should('not.exist');
  }

  static simulateEmailServerDown() {
    cy.intercept('/sendEmail', { statusCode: 500 });
  }

  static verifyErrorLogged() {
    cy.get('#errorLog').should('contain', 'Email could not be sent');
  }

  static verifyUserNotifiedOfFailure() {
    cy.get('#notification').should('contain', 'Failure to send email');
  }

  static verifyEmailContentForShipped() {
    this.verifyEmailBodyContains('Order ID, status, and customer details');
  }

  static verifyEmailContentForDelivered() {
    this.verifyEmailBodyContains('Order ID, status, and delivery details');
  }

  static verifyEmailBodyShippingDetails() {
    this.verifyEmailBodyContains('Shipping details and tracking info');
  }

  static verifyEmailBodyDeliveryDetails() {
    this.verifyEmailBodyContains('Delivery confirmation and feedback request');
  }

  static verifyEmailBodyCancellationDetails() {
    this.verifyEmailBodyContains('Cancellation details and refund info');
  }
}

export default OrderPage;