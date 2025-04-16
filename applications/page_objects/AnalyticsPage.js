class AnalyticsPage {
  verifyDashboard() {
    cy.get('.dashboard').should('be.visible');
    cy.get('.activity-insights').should('exist');
  }

  goToActivityInsights() {
    cy.get('.activity-insights').click();
  }

  verifyActivityInsightsDisplayed() {
    cy.get('.insights-options').should('be.visible');
  }

  viewGraphicalRepresentation() {
    cy.get('.view-graphs').click();
  }

  verifyGraphicalDisplay() {
    cy.get('.graphical-representation').should('be.visible');
    cy.get('.graphical-representation').should('not.have.class', 'performance-issue');
  }

  verifyDataAccuracy() {
    cy.get('.data-accuracy').should('contain', 'accurate');
  }

  verifyPerformance() {
    cy.get('.performance').should('not.contain', 'degraded');
  }
}