import { Selector } from 'testcafe';

class LiveTrackingPage {
  navigate() {
    cy.visit('/live-tracking');
  }

  enterShipmentId(shipmentId) {
    cy.get('#trackingField').type(shipmentId);
  }

  clickTrackButton() {
    cy.get('#trackingButton').click();
  }

  verifyTrackingDetails(shipmentId) {
    cy.get('#trackingDetails').should('contain', shipmentId);
  }

  verifyCurrentLocation() {
    cy.get('#currentLocation').should('be.visible');
  }

  simulateLocationChange() {
    cy.get('#simulateLocationChangeButton').click();
  }

  verifyUpdatedLocation() {
    cy.get('#currentLocation').should('contain', 'Updated Location');
  }

  verifyEstimatedDeliveryTime() {
    cy.get('#estimatedDeliveryTime').should('be.visible');
  }

  refreshPage() {
    cy.reload();
  }

  checkNotificationSettings() {
    cy.get('#notificationSettings').should('be.checked');
  }

  simulateNetworkIssue() {
    cy.get('#simulateNetworkIssueButton').click();
  }

  verifyTrackingHistoryLog() {
    cy.get('#trackingHistoryLog').should('contain', 'Location Update');
  }

  checkForErrorMessages() {
    cy.get('.errorMessage').should('not.exist');
  }

  simulateLocationChangeFromAnotherDevice() {
    cy.get('#simulateLocationChangeAnotherDeviceButton').click();
  }

  verifyOnMobileDevice() {
    cy.viewport('iphone-x');
    cy.visit('/live-tracking');
    cy.get('#trackingDetails').should('contain', '54321');
  }

  simulateSystemReboot() {
    cy.get('#simulateSystemRebootButton').click();
  }

  verifyAccuracy() {
    cy.get('#trackingDetails').should('contain', 'Accurate Information');
  }
}

export default LiveTrackingPage;