class LegalCompliancePage {
  navigateToDashboard() {
    cy.get('.dashboard').should('be.visible');
  }

  selectProperty(property) {
    cy.get('.property-list').contains(property).click();
    cy.get('.property-details').should('be.visible');
  }

  enterPermitNumber(permitNumber) {
    cy.get('#permit-number-input').type(permitNumber);
  }

  verifyPermit() {
    cy.get('#verify-permit-button').click();
    cy.get('.verification-status').should('contain', 'Processing');
  }

  reviewVerificationResults() {
    cy.get('.verification-results').should('contain', 'validity of the building permit');
  }

  checkForWarnings() {
    cy.get('.warnings').should('not.exist');
  }

  saveVerificationReport() {
    cy.get('#save-report-button').click();
    cy.get('.notification').should('contain', 'Report saved successfully');
  }
}