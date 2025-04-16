class TrialManagementPage {
  navigate() {
    cy.visit('/trial-management');
  }

  verifyDashboardDisplayed() {
    cy.get('.dashboard-header').should('be.visible');
  }

  selectInvestigatorTraining() {
    cy.get('.investigator-training-link').click();
  }
}

class InvestigatorTrainingPage {
  verifyPageDisplayed() {
    cy.get('.investigator-training-header').should('contain', 'Investigator Training');
  }

  searchInvestigator(name) {
    cy.get('.search-input').type(name);
    cy.get('.search-button').click();
  }

  verifyInvestigatorProfile(name) {
    cy.get('.investigator-name').should('contain', name);
  }

  verifyTrainingStatus(status) {
    cy.get('.training-status').should('contain', status);
  }

  verifyCertifications(certifications) {
    certifications.forEach(certification => {
      cy.get('.certifications').should('contain', certification);
    });
  }

  generateReport(name) {
    cy.get('.generate-report-button').click();
    cy.get('.report').should('contain', name);
  }
}