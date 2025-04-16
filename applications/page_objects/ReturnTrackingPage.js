class ReturnTrackingPage {
  visit() {
    cy.visit('/return-tracking');
  }

  searchReturnID(returnID) {
    cy.get('.search-field').type(returnID);
    cy.get('.search-button').click();
  }

  verifyReturnDetails(reason, outcome) {
    cy.get('.return-details').should('contain', reason).and('contain', outcome);
  }

  filterByReason(reason) {
    cy.get('.filter-reason').select(reason);
  }

  exportData() {
    cy.get('.export-button').click();
  }

  verifyCSVContent(content) {
    cy.readFile('cypress/downloads/return-history.csv').then((csv) => {
      expect(csv).to.contain(content);
    });
  }

  navigateToAnalytics() {
    cy.get('.analytics-section').click();
  }

  generateReport() {
    cy.get('.generate-report-button').click();
  }

  attemptDeleteRecord() {
    cy.get('.return-record').within(() => {
      cy.get('.delete-button').click();
    });
  }

  loadLargeData() {
    cy.get('.load-large-data-button').click();
  }
}

export default ReturnTrackingPage;