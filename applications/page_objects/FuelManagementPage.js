class FuelManagementPage {
  navigateToFuelManagement() {
    cy.get('.menu').contains('Fuel Management').click();
  }

  selectVehicle(vehicleId) {
    cy.get('.vehicle-list').contains(vehicleId).click();
  }

  clickFuelEfficiencyTracker() {
    cy.get('.tracker-button').contains('Fuel Efficiency Tracker').click();
  }

  selectTimePeriod(period) {
    cy.get('.time-period-selector').select(period);
  }

  clickDisplayGraph() {
    cy.get('.display-graph-button').click();
  }

  verifyFuelEfficiencyGraph() {
    cy.get('.fuel-efficiency-graph').should('be.visible');
  }

  checkSuggestions() {
    cy.get('.fuel-efficiency-suggestions').should('be.visible');
  }
}

export default FuelManagementPage;