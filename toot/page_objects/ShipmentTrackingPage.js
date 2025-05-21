import { expect } from 'chai';
import { cy } from 'cypress';

class ShipmentTrackingPage {
  static login() {
    cy.login();
  }

  static visit() {
    cy.visit('/shipment-tracking');
  }

  static verifyShipmentDetails(shipmentId) {
    cy.get('#shipment-details').contains(shipmentId);
  }

  static verifyCurrentStatus(status) {
    cy.get('#current-status').should('contain', status);
  }

  static simulateNetworkIssue() {
    cy.intercept('/update-status', { forceNetworkError: true });
  }

  static verifyMultipleUpdates() {
    cy.get('#status-history').should('have.length.greaterThan', 1);
  }

  static verifyMobileDevice() {
    cy.viewport('iphone-x');
  }

  static simulateSystemReboot() {
    cy.restartSystem();
  }

  static navigate() {
    cy.get('#navigate-tracking').click();
  }

  static enterShipmentID(shipmentId) {
    cy.get('#tracking-field').type(shipmentId);
  }

  static checkCurrentStatus() {
    cy.get('#current-status').click();
  }

  static updateStatus(newStatus) {
    cy.get('#update-status').select(newStatus);
  }

  static verifyTimestamp() {
    cy.get('#status-timestamp').invoke('text').then((timestamp) => {
      const currentTime = new Date().toLocaleString();
      expect(timestamp).to.eq(currentTime);
    });
  }

  static refreshPage() {
    cy.reload();
  }

  static logoutAndLogin() {
    cy.logout();
    cy.login();
  }

  static checkNotificationSettings() {
    cy.get('#notification-settings').click();
  }

  static attemptStatusUpdate() {
    cy.get('#attempt-update').click();
  }

  static verifyShipmentHistoryLog() {
    cy.get('#shipment-history-log').should('contain', 'status update');
  }

  static checkForErrorMessages() {
    cy.get('#error-messages').should('not.exist');
  }

  static attemptUpdateFromDifferentDevice() {
    cy.get('#update-from-different-device').click();
  }

  static verifyShipmentStatus() {
    cy.get('#shipment-status').should('be.visible');
  }

  static checkShipmentStatus() {
    cy.get('#check-status').click();
  }

  static verifyPageDisplayed() {
    cy.url().should('include', '/shipment-tracking');
  }

  static verifyShipmentDataAvailable() {
    cy.get('#shipment-data').should('exist');
  }

  static verifyRealTimeStatusUpdate(expectedStatus) {
    cy.get('#current-status').should('contain', expectedStatus);
  }

  static verifyTimestampMatchesCurrentTime() {
    cy.get('#status-timestamp').invoke('text').then((timestamp) => {
      const currentTime = new Date().toLocaleString();
      expect(timestamp).to.eq(currentTime);
    });
  }

  static verifyStatusAndTimestamp(expectedStatus) {
    cy.get('#current-status').should('contain', expectedStatus);
    cy.get('#status-timestamp').invoke('text').then((timestamp) => {
      const currentTime = new Date().toLocaleString();
      expect(timestamp).to.eq(currentTime);
    });
  }

  static verifyShipmentStatus(expectedStatus) {
    cy.get('#shipment-status').should('contain', expectedStatus);
  }

  static verifyNotificationsEnabled() {
    cy.get('#notifications-enabled').should('be.checked');
  }

  static verifyNetworkIssueHandling() {
    cy.get('#network-issue-handling').should('contain', 'retry');
  }

  static verifyCompleteShipmentHistoryLog() {
    cy.get('#shipment-history-log').should('contain', 'status update');
  }

  static verifyNoErrorMessages() {
    cy.get('#error-messages').should('not.exist');
  }

  static verifySynchronizationAcrossDevices() {
    cy.get('#synchronization-status').should('contain', 'synchronized');
  }

  static verifyConsistencyWithDesktopView() {
    cy.get('#mobile-status').should('contain', 'desktop view');
  }

  static verifyStatusAfterReboot(expectedStatus) {
    cy.get('#shipment-status').should('contain', expectedStatus);
  }
}

export default ShipmentTrackingPage;