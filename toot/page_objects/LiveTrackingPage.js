import { expect } from 'chai';
import { cy } from 'cypress';

class LiveTrackingPage {
 static visit() {
 cy.visit('/live-tracking');
 }

 static verifyPageDisplayed() {
 cy.contains('Live Tracking').should('be.visible');
 }

 static enterShipmentId(shipmentId) {
 cy.get('#trackingField').type(shipmentId);
 cy.get('#trackButton').click();
 }

 static verifyTrackingDetailsDisplayed(shipmentId) {
 cy.contains(`Tracking Details for ID ${shipmentId}`).should('be.visible');
 }

 static checkCurrentLocation() {
 cy.get('#currentLocation').click();
 }

 static verifyCurrentLocationOnMap() {
 cy.get('#map').should('contain', 'Current Location');
 }

 static simulateLocationChange() {
 cy.get('#simulateChangeButton').click();
 }

 static verifyRealTimeLocationUpdate() {
 cy.get('#map').should('contain', 'Updated Location');
 }

 static verifyEstimatedDeliveryTime() {
 cy.get('#estimatedTime').should('be.visible');
 }

 static verifyEstimatedDeliveryTimeAccuracy() {
 cy.get('#estimatedTime').should('contain', 'Estimated Delivery Time');
 }

 static verifyTrackingInfoConsistency() {
 cy.get('#trackingDetails').should('be.visible');
 }

 static logoutAndLogin() {
 cy.get('#logoutButton').click();
 cy.get('#loginButton').click();
 }

 static verifyTrackingInfoAvailability() {
 cy.get('#trackingDetails').should('be.visible');
 }

 static checkNotificationSettings() {
 cy.get('#notificationSettings').click();
 }

 static verifyNotificationsEnabled() {
 cy.get('#notificationsEnabled').should('be.checked');
 }

 static simulateNetworkIssue() {
 cy.get('#simulateNetworkIssueButton').click();
 }

 static verifyNetworkIssueHandling() {
 cy.get('#retryButton').should('be.visible');
 }

 static verifyTrackingHistoryLog() {
 cy.get('#historyLog').click();
 }

 static verifyLogContainsUpdates() {
 cy.get('#historyLog').should('contain', 'Location Updates');
 }

 static checkForErrorMessages() {
 cy.get('#errorMessages').click();
 }

 static verifyNoErrorMessages() {
 cy.get('#errorMessages').should('not.exist');
 }

 static updateLocationFromDifferentDevice() {
 cy.get('#updateFromDifferentDeviceButton').click();
 }

 static verifySynchronizationAcrossDevices() {
 cy.get('#synchronizationStatus').should('contain', 'Synchronized');
 }

 static verifyLiveTrackingOnMobile() {
 cy.viewport('iphone-6');
 cy.get('#liveTracking').should('be.visible');
 }

 static verifyConsistencyWithDesktop() {
 cy.get('#liveTracking').should('contain', 'Consistent with Desktop');
 }

 static checkAfterSystemReboot() {
 cy.get('#checkAfterRebootButton').click();
 }

 static verifyTrackingInfoAfterReboot() {
 cy.get('#trackingDetails').should('be.visible');
 }

 static verifyTrackingSystemAccuracy() {
 cy.get('#verifyAccuracyButton').click();
 }

 static verifyAccuracyAndReliability() {
 cy.get('#accuracyStatus').should('contain', 'Accurate and Reliable');
 }
}

export default LiveTrackingPage;