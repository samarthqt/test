class TrackerPage {
  navigateToSection() {
    cy.get('#carbonFootprintSection').click();
  }

  verifyVehicleData(vehicle) {
    cy.get('#vehicleData').should('contain', vehicle);
  }

  enterTripDetails(distance, fuelType) {
    cy.get('#tripDistance').type(distance);
    cy.get('#fuelType').select(fuelType);
  }

  calculateEmissions() {
    cy.get('#calculateEmissions').click();
  }

  verifyEmissionTips() {
    cy.get('#emissionTips').should('be.visible');
  }

  verifyLoggingOfTripData() {
    cy.get('#tripHistory').should('contain', 'Logged');
  }

  verifyIncompleteDataPrompt() {
    cy.get('#errorPrompt').should('contain', 'Complete all fields');
  }

  verifyZeroEmissionsAndMaintenanceTips() {
    cy.get('#zeroEmissions').should('be.visible');
    cy.get('#maintenanceTips').should('be.visible');
  }

  verifyInvalidDataError() {
    cy.get('#errorMessage').should('contain', 'Invalid data');
  }

  verifyAccurateEmissionsCalculation() {
    cy.get('#emissionsData').should('contain', 'Accurate');
  }

  verifyMultipleVehicleEmissionsTracking() {
    cy.get('#vehicleEmissions').should('contain', 'Separate tracking');
  }

  verifyTailoredTips(vehicle) {
    cy.get('#tailoredTips').should('contain', vehicle);
  }

  verifyLocalDataSave() {
    cy.get('#localDataSave').should('be.visible');
  }

  verifyDataUpdateOnConnectionRestore() {
    cy.get('#dataUpdate').should('be.visible');
  }

  exportData(format) {
    cy.get('#exportOptions').select(format);
    cy.get('#exportButton').click();
  }

  verifyDataExport() {
    cy.get('#exportSuccess').should('be.visible');
  }

  verifyIncentivesForReducedEmissions() {
    cy.get('#incentives').should('be.visible');
  }

  verifyEmissionFactorsUpdate() {
    cy.get('#emissionFactors').should('contain', 'Updated');
  }
}