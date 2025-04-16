class CourseDashboardPage {
  verifyOnDashboard() {
    cy.url().should('include', '/course-dashboard');
  }

  clickCustomizeButton() {
    cy.get('.customize-dashboard-button').click();
  }

  verifyCustomizationOptionsDisplayed() {
    cy.get('.customization-options').should('be.visible');
  }

  rearrangeWidgets() {
    cy.get('.widget').first().trigger('dragstart');
    cy.get('.widget-drop-area').trigger('drop');
  }

  verifyWidgetsRearranged() {
    // Add specific assertions to check widget positions
    cy.get('.widget').first().should('have.class', 'rearranged');
  }

  saveDashboardLayout() {
    cy.get('.save-layout-button').click();
  }

  verifyLayoutSaved() {
    cy.get('.notification').should('contain', 'Layout saved successfully');
  }

  verifyLayoutPersistence() {
    // Assert that the layout is as expected after page refresh
    cy.get('.widget').first().should('have.class', 'rearranged');
  }
}