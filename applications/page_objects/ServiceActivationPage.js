class ServiceActivationPage {
  initiateCompatibilityCheck() {
    cy.get('#initiate-check-button').click();
  }

  verifyOSIncompatibility() {
    cy.get('#os-check').should('contain', 'Unsupported OS');
  }

  verifyRAMIncompatibility() {
    cy.get('#ram-check').should('contain', '2GB');
  }

  verifyProcessorIncompatibility() {
    cy.get('#processor-check').should('contain', 'Dual-core 1.0 GHz');
  }

  completeCompatibilityCheck() {
    cy.get('#complete-check').click();
    cy.get('#compatibility-result').should('contain', 'incompatible');
  }

  attemptServiceActivation() {
    cy.get('#activate-service-button').click();
    cy.get('#activation-result').should('contain', 'failed due to device incompatibility');
  }
}