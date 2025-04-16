class InsurancePage {
  navigateToAddInsurance() {
    cy.get('#add-insurance-btn').click();
  }

  enterPolicyNumber(policyNumber) {
    cy.get('#policy-number-input').type(policyNumber);
  }

  enterProvider(provider) {
    cy.get('#provider-input').type(provider);
  }

  selectCoverageType(coverageType) {
    cy.get('#coverage-type-select').select(coverageType);
  }

  submitInsuranceDetails() {
    cy.get('#submit-insurance-btn').click();
  }

  navigateToViewInsurance() {
    cy.get('#view-insurance-btn').click();
  }

  verifyPolicyNumber(expectedPolicyNumber) {
    cy.get('#policy-number-display').should('have.text', expectedPolicyNumber);
  }

  verifyProviderName(expectedProviderName) {
    cy.get('#provider-name-display').should('have.text', expectedProviderName);
  }

  verifyCoverageType(expectedCoverageType) {
    cy.get('#coverage-type-display').should('have.text', expectedCoverageType);
  }

  navigateToUpdateInsurance() {
    cy.get('#update-insurance-btn').click();
  }

  updateCoverageType(newCoverageType) {
    cy.get('#coverage-type-select').select(newCoverageType);
  }

  submitUpdatedInsuranceDetails() {
    cy.get('#submit-update-btn').click();
  }

  logout() {
    cy.get('#logout-btn').click();
  }
}