class KeyRotationPage {
  initiateKeyRotation() {
    cy.get('#initiate-rotation').click();
  }

  verifyRotationInitiated() {
    cy.get('#rotation-status').should('contain', 'Rotation initiated successfully');
  }

  verifyDataAccessDuringRotation() {
    cy.get('#data-access-status').should('contain', 'Data is accessible and encrypted');
  }

  verifyLogsForErrors() {
    cy.get('#logs').should('not.contain', 'error').and('contain', 'Rotation successful');
  }
}