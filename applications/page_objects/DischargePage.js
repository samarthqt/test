class DischargePage {
  goToDischargeSummary() {
    cy.get('a[href="/discharge-summary"]').click();
  }

  verifyDischargeSummaryPage() {
    cy.url().should('include', '/discharge-summary');
    cy.contains('Discharge Summary').should('be.visible');
  }

  selectPatient(patientId) {
    cy.get(`input[name="patientId"][value="${patientId}"]`).click();
  }

  verifyTreatmentDetails(expectedTreatment) {
    cy.get('.treatment-details').should('contain', expectedTreatment);
  }

  enterMedications(medication) {
    cy.get('input[name="medications"]').type(medication);
  }

  enterFollowUpCare(followUpCare) {
    cy.get('input[name="followUpCare"]').type(followUpCare);
  }

  finalizeDischargeSummary() {
    cy.get('button.finalize-summary').click();
  }

  verifyDischargeSummaryGenerated() {
    cy.contains('Discharge summary generated').should('be.visible');
  }

  provideDischargeSummary() {
    cy.get('button.provide-summary').click();
  }

  verifyDischargeSummaryProvided() {
    cy.contains('Discharge summary provided to patient').should('be.visible');
  }
}