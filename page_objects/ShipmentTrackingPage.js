import { Selector } from 'testcafe';
 
class ShipmentTrackingPage {
 
 static visit() {
 cy.visit('/shipment-tracking');
 }
 
 static verifyPageDisplayed() {
 cy.get('#trackingPage').should('be.visible');
 }
 
 static enterShipmentID(shipmentId) {
 cy.get('#trackingField').type(shipmentId);
 cy.get('#submitTracking').click();
 }
 
 static verifyShipmentDetails(shipmentId) {
 cy.get('#shipmentDetails').should('contain.text', shipmentId);
 }
 
 static checkCurrentStatus() {
 cy.get('#currentStatus').should('be.visible');
 }
 
 static verifyCurrentStatus(status) {
 cy.get('#currentStatus').should('contain.text', status);
 }
 
 static simulateStatusUpdate(newStatus) {
 cy.get('#simulateStatusUpdateBtn').click();
 cy.get('#newStatus').type(newStatus);
 cy.get('#updateStatus').click();
 }
 
 static verifyStatusUpdate(newStatus) {
 cy.get('#currentStatus').should('contain.text', newStatus);
 }
 
 static verifyTimestamp() {
 cy.get('#timestamp').should('be.visible');
 }
 
 static verifyTimestampMatchesCurrentTime() {
 cy.get('#timestamp').should('contain.text', new Date().toLocaleString());
 }
 
 static checkNotificationSettings() {
 cy.get('#notificationSettings').click();
 }
 
 static verifyNotificationsEnabled() {
 cy.get('#notifications').should('contain.text', 'enabled');
 }
 
 static simulateNetworkIssue() {
 cy.get('#simulateNetworkIssueBtn').click();
 }
 
 static verifyNetworkIssueHandled() {
 cy.get('#networkIssueHandled').should('be.visible');
 }
 
 static verifyRetryUpdate() {
 cy.get('#retryUpdate').should('be.visible');
 }
 
 static verifyStatusUpdatesMade() {
 cy.get('#statusUpdates').should('be.visible');
 }
 
 static verifyHistoryLog() {
 cy.get('#historyLog').click();
 }
 
 static verifyHistoryLogContents() {
 cy.get('#historyLogContents').should('be.visible');
 }
 
 static updateShipmentStatus() {
 cy.get('#updateStatusBtn').click();
 }
 
 static checkForErrorMessages() {
 cy.get('#errorMessages').should('not.exist');
 }
 
 static verifyNoErrorMessages() {
 cy.get('#errorMessages').should('not.exist');
 }
 
 static verifyMultipleDeviceAccess() {
 cy.get('#multipleDevices').should('be.visible');
 }
 
 static updateStatusFromDifferentDevice() {
 cy.get('#differentDeviceUpdate').click();
 }
 
 static verifyStatusSynchronization() {
 cy.get('#statusSynchronization').should('be.visible');
 }
 
 static checkStatusOnMobileDevice() {
 cy.get('#mobileDeviceStatus').click();
 }
 
 static verifyStatusDisplayed() {
 cy.get('#statusDisplayed').should('be.visible');
 }
 
 static verifyStatusConsistency() {
 cy.get('#statusConsistency').should('be.visible');
 }
 
 static rebootSystem() {
 cy.get('#rebootSystemBtn').click();
 }
 
 static checkShipmentStatus() {
 cy.get('#shipmentStatus').should('be.visible');
 }
}
 
export default ShipmentTrackingPage;