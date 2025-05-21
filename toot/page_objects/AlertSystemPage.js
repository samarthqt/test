import { login } from '../support/auth';

class AlertSystemPage {

  static login() {
    login('validUsername', 'validPassword');
  }

  static verifyDashboardDisplayed() {
    cy.get('#dashboard').should('be.visible');
  }

  static verifyShipmentOrdersExist() {
    cy.get('.order-list').should('contain', '10001').and('contain', '10050');
  }

  static verifyCustomerSubscription() {
    cy.get('.subscription-status').should('contain', 'Subscribed');
  }

  static navigateToOrdersModule() {
    cy.get('#ordersModule').click();
  }

  static verifyOrdersModuleDisplayed() {
    cy.get('#ordersModule').should('be.visible');
  }

  static verifyCustomerEmail() {
    cy.get('.customer-email').should('contain', 'customer@example.com');
  }

  static selectOrders() {
    cy.get('.order-checkbox').check({ multiple: true });
  }

  static verifyOrderDetailsDisplayed() {
    cy.get('.order-details').should('be.visible');
  }

  static verifyShipmentStatusDispatched() {
    cy.get('.shipment-status').should('contain', 'Dispatched');
  }

  static updateShipmentStatus() {
    cy.get('.update-status-btn').click();
  }

  static verifyShipmentStatusUpdated() {
    cy.get('.shipment-status').should('contain', 'Dispatched');
  }

  static monitorAlertSystem() {
    cy.get('#alertMonitor').should('be.visible');
  }

  static verifyAlertsSent() {
    cy.get('.alert-log').should('contain', 'customer@example.com');
  }

  static verifySystemPerformance() {
    cy.get('.performance-status').should('contain', 'Optimal');
  }

  static updateAndVerifyShipmentStatus() {
    this.updateShipmentStatus();
    this.verifyShipmentStatusUpdated();
  }

  static navigateAndVerifyOrdersModule() {
    this.navigateToOrdersModule();
    this.verifyOrdersModuleDisplayed();
  }

}

export default AlertSystemPage;