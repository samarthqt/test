class TenantManagementPage {
  navigate() {
    cy.visit('/tenant-management');
  }

  verifyModuleDisplayed() {
    cy.contains('Tenant Management').should('be.visible');
  }

  selectScreeningSubModule() {
    cy.get('[data-testid="screening-sub-module"]').click();
  }

  verifyScreeningSubModuleDisplayed() {
    cy.contains('Screening').should('be.visible');
  }

  enterTenantInfo({ name, ssn, address }) {
    cy.get('[data-testid="tenant-name-input"]').type(name);
    cy.get('[data-testid="tenant-ssn-input"]').type(ssn);
    cy.get('[data-testid="tenant-address-input"]').type(address);
  }

  verifyErrorMessageDisplayed() {
    cy.contains('Input exceeds maximum allowed length').should('be.visible');
  }
}