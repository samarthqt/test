class LeaseManagementPage {
  visit() {
    cy.visit('/lease-management');
  }

  createNewLease() {
    cy.contains('Create New Lease Agreement').click();
  }

  selectStandardTemplate() {
    cy.contains('Standard Lease Template').click();
  }

  addCustomClause(clause) {
    cy.get('#customClauses').type(clause);
  }

  modifyExistingClause(clause) {
    cy.get('#existingClauses').clear().type(clause);
  }

  enterPropertyDetails(address, rent) {
    cy.get('#propertyAddress').type(address);
    cy.get('#rentAmount').type(rent);
  }

  reviewLeaseAgreement() {
    cy.contains('Review Lease Agreement').click();
  }

  saveLeaseAgreement() {
    cy.contains('Save Lease Agreement').click();
  }

  shareWithTenants() {
    cy.contains('Share with Tenants').click();
  }

  revertToStandardTemplate() {
    cy.contains('Revert to Standard Template').click();
  }
}

export default LeaseManagementPage;