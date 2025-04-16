class DashboardCustomizationPage {
  navigate() {
    cy.visit('/dashboard-customization');
  }

  verifyPageLoaded() {
    cy.url().should('include', '/dashboard-customization');
    cy.get('.dashboard-customization-page').should('be.visible');
  }

  selectWidgets(widgets) {
    widgets.forEach(widget => {
      cy.get(`input[value="${widget}"]`).check();
    });
  }

  verifySelectedWidgets(widgets) {
    widgets.forEach(widget => {
      cy.get('.selected-widgets').should('contain', widget);
    });
  }

  chooseLayoutOption(option) {
    cy.get(`input[value="${option}"]`).check();
  }

  verifyLayoutOption(option) {
    cy.get('.dashboard-layout').should('have.class', option.toLowerCase());
  }

  selectStatistics(statistics) {
    statistics.forEach(stat => {
      cy.get(`input[value="${stat}"]`).check();
    });
  }

  verifySelectedStatistics(statistics) {
    statistics.forEach(stat => {
      cy.get('.selected-statistics').should('contain', stat);
    });
  }

  saveSettings() {
    cy.get('.save-settings-button').click();
  }

  verifySettingsSaved() {
    cy.get('.notification').should('contain', 'Customization settings saved successfully');
  }
}

export default DashboardCustomizationPage;