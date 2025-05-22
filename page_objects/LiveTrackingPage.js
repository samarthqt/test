import { simulateNetworkIssue, simulateLocationChange, updateLocationFromDifferentDevice, rebootSystem } from '../helpers/simulations';
class LiveTrackingPage {
    visit() {
        cy.visit('/live-tracking');
    }

    enterShipmentId(shipmentId) {
        cy.get('.tracking-field').type(shipmentId);
    }

    clickTrackButton() {
        cy.get('.track-button').click();
    }

    verifyTrackingDetails(shipmentId) {
        cy.get('.tracking-details').should('contain', shipmentId);
    }

    verifyCurrentLocation() {
        cy.get('.current-location').should('be.visible');
    }

    verifyEstimatedDeliveryTime() {
        cy.get('.estimated-delivery-time').should('be.visible');
    }

    refreshPage() {
        cy.reload();
    }

    verifyNotificationSettings() {
        cy.get('.notification-settings').should('be.checked');
    }

    verifyTrackingHistoryLog() {
        cy.get('.tracking-history-log').should('contain', 'Location Update');
    }

    checkErrorMessages() {
        cy.get('.error-message').should('not.exist');
    }

    verifyTrackingOnMobile() {
        cy.viewport('iphone-x');
        this.visit();
        this.verifyTrackingDetails();
    }

    verifyTrackingAccuracy() {
        cy.get('.tracking-accuracy').should('contain', 'Accurate');
    }
    
    simulateLocationChange() {
        simulateLocationChange();
    }

    simulateNetworkIssue() {
        simulateNetworkIssue();
    }

    updateLocationFromDifferentDevice() {
        updateLocationFromDifferentDevice();
    }

    rebootSystem() {
        rebootSystem();
    }
}

export default LiveTrackingPage;