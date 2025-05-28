import { simulateNetworkIssue, simulateSystemReboot } from '../utils/simulationHelpers';
import { simulateStatusUpdate } from '../utils/statusUpdateHelpers';

class ShipmentTrackingPage {
  visit() {
    cy.visit('/shipment-tracking');
  }

  enterShipmentId(id) {
    cy.get('#trackingField').type(id);
  }

  clickTrackButton() {
    cy.get('#trackButton').click();
  }

  getShipmentDetails() {
    return cy.get('#shipmentDetails');
  }

  getShipmentStatus() {
    return cy.get('#shipmentStatus');
  }

  getStatusTimestamp() {
    return cy.get('#statusTimestamp');
  }

  getNotificationSettings() {
    return cy.get('#notificationSettings');
  }

  getHistoryLog() {
    return cy.get('#historyLog');
  }

  getErrorMessages() {
    return cy.get('#errorMessages');
  }

  simulateStatusUpdate(id, status) {
    simulateStatusUpdate(id, status);
  }

  simulateNetworkIssue() {
    simulateNetworkIssue();
  }

  simulateStatusUpdateFromDifferentDevice(id, status) {
    simulateStatusUpdate(id, status, { device: 'different' });
  }

  systemReboot() {
    simulateSystemReboot();
  }
}

export default ShipmentTrackingPage;