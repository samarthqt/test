class DataSharingPage {
  visit() {
    cy.visit('/data-sharing');
  }

  verifyMainPageDisplayed() {
    cy.contains('Data Sharing').should('be.visible');
  }

  selectConsentToShareData() {
    cy.get('#consent-to-share-data').click();
  }

  verifyConsentFormDisplayed() {
    cy.contains('Consent Form').should('be.visible');
  }

  enterResearchInstitutionID(id) {
    cy.get('#research-institution-id').type(id);
  }

  verifyResearchInstitutionDetailsDisplayed() {
    cy.contains('Research Institution Details').should('be.visible');
  }

  selectConsentYes() {
    cy.get('#consent-yes').check();
  }

  submitConsent() {
    cy.get('#submit-consent').click();
  }

  verifyConfirmationMessage() {
    cy.contains('Your consent has been recorded.').should('be.visible');
  }
}

class MyConsentsPage {
  visit() {
    cy.visit('/my-consents');
  }

  verifyMyConsentsPageDisplayed() {
    cy.contains('My Consents').should('be.visible');
  }

  verifyConsentListed(institutionId) {
    cy.get('.consent-list').should('contain', institutionId);
  }
}