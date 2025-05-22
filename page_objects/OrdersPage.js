import { login } from '../support/utils';

class OrdersPage {

  static visitOrdersPage() {
    cy.visit('/orders');
  }

  static verifyOrderExists(orderId) {
    cy.get('#orderTable').contains(orderId).should('exist');
  }

  static verifyCustomerUnsubscribed() {
    cy.get('#customerSubscriptionStatus').should('have.text', 'Unsubscribed');
  }

  static loginToDynamics365() {
    login('validUsername', 'validPassword');
  }

  static navigateToOrdersModule() {
    cy.get('#ordersModule').click();
  }

  static selectOrderById(orderId) {
    cy.get(`#order-${orderId}`).click();
  }

  static updateShipmentStatus(status) {
    cy.get('#shipmentStatusDropdown').select(status);
    cy.get('#updateStatusBtn').click();
  }

  static verifyNoAlertSent(email) {
    cy.get('#alertLog').should('not.contain', email);
  }

  static verifyNoAlertReceived(email) {
    cy.get('#emailInbox').should('not.contain', email);
  }

  static openOrderDetails(orderId) {
    this.selectOrderById(orderId);
    cy.get('#viewOrderDetailsBtn').click();
  }

  static verifyOrderDetails(orderId, customerName, status) {
    cy.get('#orderDetails').within(() => {
      cy.get('.order-id').should('have.text', orderId);
      cy.get('.customer-name').should('have.text', customerName);
      cy.get('.order-status').should('have.text', status);
    });
  }

  static cancelOrder(orderId) {
    this.selectOrderById(orderId);
    cy.get('#cancelOrderBtn').click();
    cy.get('#confirmCancelBtn').click();
  }

}

export default OrdersPage;