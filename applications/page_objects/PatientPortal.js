class PatientPortal {
  visit() {
    cy.visit('/login');
  }

  login(username, password) {
    cy.get('input[name="username"]').type(username);
    cy.get('input[name="password"]').type(password);
    cy.get('button[type="submit"]').click();
  }

  navigateToConsentForms() {
    cy.get('.consent-forms-link').click();
  }

  selectConsentForm(procedureName) {
    cy.contains(procedureName).click();
  }

  signConsentForm() {
    cy.get('.sign-electronically-button').click();
    cy.get('.signature-pad').trigger('mousedown').trigger('mousemove', { clientX: 100, clientY: 100 }).trigger('mouseup');
  }

  submitConsentForm() {
    cy.get('.submit-button').click();
  }

  verifyConsentFormInRecords(consentFormId) {
    cy.get('.system-records-link').click();
    cy.contains(consentFormId).should('exist');
  }

  logout() {
    cy.get('.logout-button').click();
  }
}

export default PatientPortal;