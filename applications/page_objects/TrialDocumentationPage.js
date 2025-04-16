class TrialDocumentationPage {
  navigate() {
    cy.visit('/trial-documentation');
  }

  get trialDocumentationHeader() {
    return cy.get('h1').contains('Trial Documentation');
  }

  get studyClosureSubModule() {
    return cy.get('#studyClosureSubModule');
  }

  get searchField() {
    return cy.get('#searchField');
  }

  get searchButton() {
    return cy.get('#searchButton');
  }

  get studyDetails() {
    return cy.get('.study-details');
  }

  get generateClosureDocButton() {
    return cy.get('#generateClosureDocButton');
  }

  get confirmationDialog() {
    return cy.get('.confirmation-dialog');
  }

  get confirmButton() {
    return cy.get('#confirmButton');
  }

  get successMessage() {
    return cy.get('.success-message');
  }

  get documentsList() {
    return cy.get('.documents-list');
  }

  get documentLink() {
    return cy.get('.document-link');
  }

  get documentContents() {
    return cy.get('.document-contents');
  }

  get documentMetadata() {
    return cy.get('.document-metadata');
  }

  get editDocumentButton() {
    return cy.get('#editDocumentButton');
  }

  get errorMessage() {
    return cy.get('.error-message');
  }

  get downloadButton() {
    return cy.get('#downloadButton');
  }

  get storagePath() {
    return cy.get('#storagePath');
  }

  get accessPermissions() {
    return cy.get('#accessPermissions');
  }

  get auditTrail() {
    return cy.get('#auditTrail');
  }

  get regenerateButton() {
    return cy.get('#regenerateButton');
  }

  get warningDialog() {
    return cy.get('.warning-dialog');
  }

  get confirmRegeneration() {
    return cy.get('#confirmRegeneration');
  }
}

export default TrialDocumentationPage;