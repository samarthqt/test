class AnalyticsDashboardPage {
  navigateToDashboard() {
    cy.visit('/analytics-dashboard');
  }

  verifySalesDataDisplayed() {
    cy.get('#sales-data').should('be.visible');
  }

  verifyPerformanceMetricsDisplayed() {
    cy.get('#performance-metrics').should('be.visible');
  }

  selectSalesDataTab() {
    cy.get('#sales-tab').click();
  }

  verifyGraphicalSalesData() {
    cy.get('#sales-graph').should('be.visible');
  }

  verifySalesDataFilteredByTime() {
    cy.get('#sales-data-time-filter').should('exist');
  }

  selectPerformanceMetricsTab() {
    cy.get('#performance-metrics-tab').click();
  }

  verifyGraphicalPerformanceMetrics() {
    cy.get('#performance-graph').should('be.visible');
  }

  verifyPerformanceMetricsFilteredByTime() {
    cy.get('#performance-metrics-time-filter').should('exist');
  }

  applyTimePeriodFilter() {
    cy.get('#time-period-filter').select('Last Month');
  }

  verifySalesDataUpdatedForTimePeriod() {
    cy.get('#sales-data-updated').should('contain', 'Last Month');
  }

  verifyPerformanceMetricsUpdatedForTimePeriod() {
    cy.get('#performance-metrics-updated').should('contain', 'Last Month');
  }

  selectExportDataOption() {
    cy.get('#export-data-button').click();
  }

  verifySalesDataDownloadableAsCSV() {
    cy.get('#download-sales-csv').should('exist');
  }

  verifyPerformanceMetricsDownloadableAsCSV() {
    cy.get('#download-performance-csv').should('exist');
  }

  setNoSalesDataAvailable() {
    // Simulate no sales data
    cy.intercept('/api/sales-data', { body: [] });
  }

  viewSalesData() {
    cy.get('#view-sales-data').click();
  }

  verifyNoDataMessage() {
    cy.get('#no-data-message').should('be.visible');
  }

  setNoPerformanceMetricsAvailable() {
    // Simulate no performance metrics
    cy.intercept('/api/performance-metrics', { body: [] });
  }

  viewPerformanceMetrics() {
    cy.get('#view-performance-metrics').click();
  }
}

export default AnalyticsDashboardPage;