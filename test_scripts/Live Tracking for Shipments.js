describe('Live Tracking for Shipments', () => {
  const shipmentId = '54321';
  const userId = '09876';

  before(() => {
    cy.login(userId);
  });

  it('should navigate to the live tracking page', () => {
    cy.visit('/live-tracking');
    cy.url().should('include', '/live-tracking');
  });

  it('should enter the Shipment ID and display live tracking details', () => {
    cy.get('#trackingField').type(shipmentId);
    cy.get('#trackingButton').click();
    cy.get('#trackingDetails').should('contain', shipmentId);
  });

  it('should display the current location of the shipment', () => {
    cy.get('#currentLocation').should('be.visible');
  });

  it('should update location in real-time', () => {
    cy.simulateLocationChange();
    cy.get('#currentLocation').should('contain', 'Updated Location');
  });

  it('should verify the estimated delivery time', () => {
    cy.get('#estimatedDeliveryTime').should('be.visible');
  });

  it('should refresh the page and maintain live tracking information', () => {
    cy.reload();
    cy.get('#trackingDetails').should('contain', shipmentId);
  });

  it('should log out and log back in without losing tracking information', () => {
    cy.logout();
    cy.login(userId);
    cy.get('#trackingDetails').should('contain', shipmentId);
  });

  it('should check notification settings for live tracking updates', () => {
    cy.get('#notificationSettings').should('be.checked');
  });

  it('should handle network issues gracefully', () => {
    cy.simulateNetworkIssue();
    cy.get('#retryButton').click();
    cy.get('#currentLocation').should('contain', 'Updated Location');
  });

  it('should verify the tracking history log', () => {
    cy.get('#trackingHistoryLog').should('contain', 'Location Update');
  });

  it('should check for error messages during location updates', () => {
    cy.get('.errorMessage').should('not.exist');
  });

  it('should update location from a different device', () => {
    cy.simulateLocationChangeFromAnotherDevice();
    cy.get('#currentLocation').should('contain', 'Updated Location');
  });

  it('should verify live tracking on a mobile device', () => {
    cy.viewport('iphone-x');
    cy.visit('/live-tracking');
    cy.get('#trackingDetails').should('contain', shipmentId);
  });

  it('should check live tracking after a system reboot', () => {
    cy.simulateSystemReboot();
    cy.get('#trackingDetails').should('contain', shipmentId);
  });

  it('should verify the accuracy of the live tracking system', () => {
    cy.get('#trackingDetails').should('contain', 'Accurate Information');
  });
});