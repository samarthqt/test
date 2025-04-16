class ParkingAssistancePage {
  verifyPageLoaded() {
    cy.url().should('include', '/parking-assistance');
    cy.contains('Parking Assistance').should('be.visible');
  }

  selectParkingFacility(facilityId) {
    cy.get(`[data-facility-id="${facilityId}"]`).click();
  }

  verifyParkingFacilityDetails(facilityId) {
    cy.get('.facility-details').should('contain', facilityId);
  }

  clickFindParkingSpot() {
    cy.get('#find-parking-spot-btn').click();
  }

  verifyAvailableParkingSpots() {
    cy.get('.parking-spot').should('have.length.greaterThan', 0);
  }

  selectParkingSpotAndTime(time) {
    cy.get('.parking-spot').first().click();
    cy.get('#parking-time').select(time);
    cy.get('#reserve-btn').click();
  }

  verifyReservationSuccess() {
    cy.contains('Reservation successful').should('be.visible');
  }
}