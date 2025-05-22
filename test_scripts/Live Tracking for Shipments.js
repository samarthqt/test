describe('Live Tracking for Shipments', () => {
    const shipmentId = '54321';
    const userId = '09876';

    before(() => {
        cy.login(userId);
    });

    it('should navigate to the live tracking page', () => {
        cy.visit('/live-tracking');
        cy.get('.live-tracking-page').should('be.visible');
    });

    it('should enter the Shipment ID and display live tracking details', () => {
        cy.get('.tracking-field').type(shipmentId);
        cy.get('.track-button').click();
        cy.get('.tracking-details').should('contain', shipmentId);
    });

    it('should display the current location of the shipment', () => {
        cy.get('.current-location').should('be.visible');
    });

    it('should simulate a change in shipment location and update in real-time', () => {
        cy.simulateLocationChange();
        cy.get('.current-location').should('contain', 'Updated Location');
    });

    it('should verify the estimated delivery time', () => {
        cy.get('.estimated-delivery-time').should('be.visible');
    });

    it('should refresh the page and maintain live tracking information', () => {
        cy.reload();
        cy.get('.tracking-details').should('contain', shipmentId);
    });

    it('should log out and log back in, maintaining live tracking information', () => {
        cy.logout();
        cy.login(userId);
        cy.get('.tracking-details').should('contain', shipmentId);
    });

    it('should check notification settings for live tracking updates', () => {
        cy.get('.notification-settings').should('be.checked');
    });

    it('should simulate a network issue and handle it gracefully', () => {
        cy.simulateNetworkIssue();
        cy.get('.network-error').should('not.exist');
    });

    it('should verify the tracking history log', () => {
        cy.get('.tracking-history-log').should('contain', 'Location Update');
    });

    it('should check for any error messages during location updates', () => {
        cy.get('.error-message').should('not.exist');
    });

    it('should update location from a different device and synchronize', () => {
        cy.updateLocationFromDifferentDevice();
        cy.get('.current-location').should('contain', 'Synchronized Location');
    });

    it('should verify live tracking on a mobile device', () => {
        cy.viewport('iphone-x');
        cy.visit('/live-tracking');
        cy.get('.tracking-details').should('contain', shipmentId);
    });

    it('should check live tracking after a system reboot', () => {
        cy.rebootSystem();
        cy.get('.tracking-details').should('contain', shipmentId);
    });

    it('should verify the accuracy of the live tracking system', () => {
        cy.get('.tracking-accuracy').should('contain', 'Accurate');
    });
});