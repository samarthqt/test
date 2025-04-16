class EHRPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  navigateToEHRModule() {
    cy.get('#ehrModuleLink').click();
  }

  addNewPatientRecord() {
    cy.get('#addPatientButton').click();
  }

  enterPatientDetails(name, allergy, diagnosis, treatment) {
    cy.get('#patientName').type(name);
    cy.get('#allergyInfo').type(allergy);
    cy.get('#diagnosisInfo').type(diagnosis);
    cy.get('#treatmentHistory').type(treatment);
  }

  savePatientRecord() {
    cy.get('#saveButton').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }

  searchPatient(name) {
    cy.get('#searchBox').type(name);
    cy.get('#searchButton').click();
  }

  verifyPatientRecord(name, allergy, diagnosis, treatment) {
    cy.get('#patientName').should('contain', name);
    cy.get('#allergyInfo').should('contain', allergy);
    cy.get('#diagnosisInfo').should('contain', diagnosis);
    cy.get('#treatmentHistory').should('contain', treatment);
  }

  editTreatmentHistory(updatedTreatment) {
    cy.get('#editTreatmentButton').click();
    cy.get('#treatmentHistory').clear().type(updatedTreatment);
  }

  verifyUpdatedTreatmentHistory(updatedTreatment) {
    cy.get('#treatmentHistory').should('contain', updatedTreatment);
  }
}