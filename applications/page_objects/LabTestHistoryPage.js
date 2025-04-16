class LabTestHistoryPage {
  navigate() {
    cy.get('nav').contains('Lab Test History').click();
  }

  selectLabTest(labTestId) {
    cy.get(`.lab-test-item[data-id="${labTestId}"]`).click();
  }

  verifyLabTestDetails() {
    cy.get('.lab-test-details').should('be.visible');
  }

  verifyTestDate(expectedDate) {
    cy.get('.lab-test-date').should('contain.text', expectedDate);
  }

  verifyTestResults(expectedResults) {
    cy.get('.lab-test-results').should('contain.text', expectedResults);
  }

  verifyTestInterpretation(expectedInterpretation) {
    cy.get('.lab-test-interpretation').should('contain.text', expectedInterpretation);
  }
}

export default LabTestHistoryPage;