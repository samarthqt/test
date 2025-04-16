class VehicleDiagnosticsPage {
  navigateToDiagnosticsModule() {
    cy.visit('/vehicle-diagnostics');
    cy.url().should('include', '/vehicle-diagnostics');
  }

  enterVehicleID(vehicleId) {
    cy.get('#vehicle-id').type(vehicleId);
    cy.get('#vehicle-id').should('have.value', vehicleId);
  }

  clickRequestDiagnostics() {
    cy.get('#request-diagnostics').click();
  }

  verifyRealTimeFeedback() {
    cy.get('#diagnostics-results').should('be.visible');
    cy.get('#diagnostics-results').should('contain', 'Real-time diagnostics results');
  }

  checkForErrorsOrWarnings() {
    cy.get('.error-message').should('not.exist');
    cy.get('.warning-message').should('not.exist');
  }
}