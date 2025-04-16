class WarehousePage {
  navigateToLayoutManagement() {
    cy.get('nav').contains('Warehouse Layout Management').click();
  }

  getLayoutManagementSection() {
    return cy.get('#layout-management-section');
  }

  clickCreateNewLayout() {
    cy.get('button').contains('Create New Layout').click();
  }

  getLayoutForm() {
    return cy.get('#layout-form');
  }

  enterLayoutDetails(warehouseName, layoutDetails) {
    cy.get('#warehouse-name').type(warehouseName);
    cy.get('#layout-details').type(layoutDetails);
  }

  getEnteredLayoutDetails() {
    return cy.get('#layout-form').within(() => {
      cy.get('#warehouse-name'),
      cy.get('#layout-details')
    });
  }

  submitLayoutForm() {
    cy.get('button').contains('Submit').click();
  }

  getNewLayout() {
    return cy.get('#new-layout-summary');
  }
}