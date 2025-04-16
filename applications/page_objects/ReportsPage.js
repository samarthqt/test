class ReportsPage {
  selectLocationBasedReport() {
    cy.get('#report-type').select('Location-Based Report');
  }

  filterByLocation(location) {
    cy.get('#location-filter').select(location);
  }

  generateReport() {
    cy.get('#generate-report-button').click();
  }

  verifyAssetInReport(assetId) {
    cy.get('#report-table').should('contain', assetId);
  }

  exportReportToPDF() {
    cy.get('#export-pdf-button').click();
  }
}