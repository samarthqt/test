class PatientPortalPage {
  login(patientId, password) {
    cy.get('#patient-id').type(patientId);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }

  verifyDashboard() {
    cy.url().should('include', '/dashboard');
    cy.get('.dashboard').should('be.visible');
  }

  goToTestResults() {
    cy.get('#test-results-link').click();
  }

  logout() {
    cy.get('#logout-button').click();
    cy.url().should('include', '/login');
  }
}

class TestResultsPage {
  verifyTestResultsList() {
    cy.get('.test-results-list').should('be.visible');
  }

  selectTestResult(testId) {
    cy.get(`.test-result-item[data-test-id="${testId}"]`).click();
  }

  verifyTestResultDetails() {
    cy.get('.test-result-details').should('be.visible');
  }

  verifySummaryAndInterpretations() {
    cy.get('.summary').should('be.visible').and('contain.text', 'Summary');
    cy.get('.interpretations').should('be.visible').and('contain.text', 'Interpretations');
  }
}