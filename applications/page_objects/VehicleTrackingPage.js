class VehicleTrackingPage {
  verifyTrackingInterface() {
    cy.get('.map-container').should('be.visible');
  }

  enableGPS() {
    cy.get('#gps-toggle').click();
  }

  verifyGPSEnabled() {
    cy.get('#gps-status').should('contain', 'Enabled');
  }

  verifyCurrentLocation() {
    cy.get('.current-location').should('be.visible');
  }

  moveVehicle() {
    cy.get('#move-vehicle').click();
  }

  verifyLocationUpdate() {
    cy.wait(60000);
    cy.get('.location-update').should('be.visible');
  }

  verifyLocationHistory() {
    cy.get('.location-history').should('be.visible').and('contain', 'History');
  }
}