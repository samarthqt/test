import 'cypress-moment';

class ShipmentTrackingPage {

  visit() {
    cy.visit('/shipment-tracking');
  }

  login(userId) {
    cy.visit('/login');
    cy.get('#userId').type(userId);
    cy.get('#loginButton').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }

  enterShipmentId(shipmentId) {
    cy.get('#trackingField').type(shipmentId);
  }

  verifyShipmentDetails(shipmentId) {
    cy.get('#shipmentDetails').should('contain', shipmentId);
  }

  checkCurrentStatus(expectedStatus) {
    cy.get('#currentStatus').should('contain', expectedStatus);
  }

  simulateStatusUpdate(shipmentId, newStatus) {
    cy.request('POST', '/api/update-status', { shipmentId, status: newStatus });
  }

  simulateStatusUpdateFromDevice(shipmentId, newStatus) {
    cy.request('POST', '/api/update-status', { shipmentId, status: newStatus });
  }

  verifyTimestamp() {
    cy.get('#statusTimestamp').should('equal', Cypress.moment().format('HH:mm'));
  }

  refreshPage() {
    cy.reload();
  }

  checkNotificationSettings() {
    cy.visit('/notification-settings');
    cy.get('#realTimeUpdates').should('be.checked');
  }

  simulateNetworkIssue() {
    cy.intercept('/api/update-status', { forceNetworkError: true });
  }

  verifyShipmentHistoryLog() {
    cy.visit('/shipment-history');
    cy.get('#historyLog').should('contain', 'Delivered');
  }

  checkErrorMessages() {
    cy.get('#errorMessages').should('not.exist');
  }

  verifyStatusOnMobile() {
    cy.viewport('iphone-x');
    cy.visit('/shipment-tracking');
  }

  rebootSystem() {
    cy.request('POST', '/api/reboot');
  }
}

export default ShipmentTrackingPage;