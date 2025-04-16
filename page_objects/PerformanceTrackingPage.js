class PerformanceTrackingPage {
  navigateToPerformanceTracking() {
    cy.get('.performance-tracking-nav').click();
  }

  verifyPerformanceTrackingPage() {
    cy.url().should('include', '/performance-tracking');
    cy.get('.performance-tracking-header').should('be.visible');
  }

  selectDateRange() {
    cy.get('.date-range-selector').click();
    cy.get('.date-range-option').contains('Last 30 Days').click();
  }

  verifyDateRangeSelection() {
    cy.get('.date-range-selected').should('contain', 'Last 30 Days');
  }

  viewPerformanceMetrics() {
    cy.get('.view-metrics-button').click();
  }

  verifyPerformanceMetricsDisplay() {
    cy.get('.performance-metrics').should('be.visible');
  }

  filterPerformanceMetrics() {
    cy.get('.filter-criteria').type('Customer Name');
    cy.get('.apply-filter-button').click();
  }

  verifyFilteredMetricsDisplay() {
    cy.get('.filtered-metrics').should('contain', 'Customer Name');
  }

  sortPerformanceMetrics() {
    cy.get('.sort-column').click();
  }

  verifyMetricsSorting() {
    cy.get('.sorted-metrics').should('be.sorted');
  }

  exportMetricsToCSV() {
    cy.get('.export-csv-button').click();
  }

  verifyCSVExport() {
    cy.get('.export-success-message').should('be.visible');
  }

  viewInteractionDetails() {
    cy.get('.interaction-details-button').click();
  }

  verifyInteractionDetailsDisplay() {
    cy.get('.interaction-details').should('contain', 'Customer Name');
  }

  addNotesToInteraction() {
    cy.get('.add-notes-button').click();
    cy.get('.notes-input').type('Follow up required');
    cy.get('.save-notes-button').click();
  }

  verifyNotesAddition() {
    cy.get('.notes-section').should('contain', 'Follow up required');
  }

  editNotesInteraction() {
    cy.get('.edit-notes-button').click();
    cy.get('.notes-input').clear().type('Updated notes');
    cy.get('.save-notes-button').click();
  }

  verifyNotesEditing() {
    cy.get('.notes-section').should('contain', 'Updated notes');
  }

  deleteInteraction() {
    cy.get('.delete-interaction-button').click();
  }

  verifyInteractionDeletion() {
    cy.get('.interaction-list').should('not.contain', 'Deleted Interaction');
  }

  verifyInteractionNotDisplayed() {
    cy.get('.performance-metrics').should('not.contain', 'Deleted Interaction');
  }

  generatePerformanceReports() {
    cy.get('.generate-report-button').click();
  }

  verifyReportGeneration() {
    cy.get('.report-generated-message').should('be.visible');
  }

  verifyMetricsAndReportsAccuracy() {
    cy.get('.metrics-accuracy').should('contain', 'Accurate');
  }

  verifyMetricsAndReportsUpToDate() {
    cy.get('.metrics-up-to-date').should('contain', 'Up to Date');
  }

  logout() {
    cy.get('.logout-button').click();
  }

  verifyLogout() {
    cy.url().should('include', '/login');
  }
}

export default PerformanceTrackingPage;