class WarehouseLayoutPage {
  navigateToWarehouseLayoutManagement() {
    cy.get('#warehouse-layout-management-nav').click();
  }

  selectWarehouseLayout(layoutName) {
    cy.contains(layoutName).click();
  }

  attemptToDeleteLayout() {
    cy.get('#delete-layout-button').click();
  }

  verifyDeletionErrorMessage() {
    cy.get('.error-message')
      .should('be.visible')
      .and('contain', 'layout is in use');
  }
}

export default WarehouseLayoutPage;