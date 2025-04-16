class CaregiverPortal {
  loginAsCaregiver(caregiverId) {
    cy.get('#username').type(caregiverId);
    cy.get('#password').type('password'); // use environment variables for passwords
    cy.get('#login-button').click();
  }

  navigateToPatientRecords() {
    cy.get('#patient-records-link').click();
  }

  viewPatientRecord(patientId) {
    cy.get(`#patient-${patientId}`).click();
  }

  verifyPermissionLevel(expectedLevel) {
    cy.get('.permission-level').should('contain', expectedLevel);
  }

  attemptEdit() {
    cy.get('.edit-button').click();
  }

  logout() {
    cy.get('#logout-button').click();
  }
}

export default CaregiverPortal;