class ReportingPage {
  navigateToReportingModule() {
    cy.visit('/reporting');
  }

  verifyDashboardDisplayed() {
    cy.get('.reporting-dashboard').should('be.visible');
  }

  selectRentPaymentHistoryReports() {
    cy.get('.report-options').contains('Rent Payment History Reports').click();
  }

  verifyRentPaymentHistoryPageDisplayed() {
    cy.url().should('include', '/rent-payment-history-reports');
  }

  enterTenantID(tenantID) {
    cy.get('#tenant-id').type(tenantID);
  }

  verifyTenantIDDisplayed(tenantID) {
    cy.get('#tenant-id').should('have.value', tenantID);
  }

  selectDateRange(startDate, endDate) {
    cy.get('#start-date').type(startDate);
    cy.get('#end-date').type(endDate);
  }

  verifyDateRangeDisplayed(startDate, endDate) {
    cy.get('#start-date').should('have.value', startDate);
    cy.get('#end-date').should('have.value', endDate);
  }

  selectReportFormat(format) {
    cy.get('#report-format').select(format);
  }

  verifyFormatSelected(format) {
    cy.get('#report-format').should('have.value', format);
  }

  clickGenerateReport() {
    cy.get('#generate-report').click();
  }

  verifyLoadingIndicatorDisplayed() {
    cy.get('.loading-indicator').should('be.visible');
  }

  waitForReportGeneration() {
    cy.get('.notification').should('contain', 'Report generated successfully');
  }

  verifyReportGenerated() {
    cy.get('.notification').should('contain', 'Report generated successfully');
  }

  downloadReport() {
    cy.get('#download-report').click();
  }

  openDownloadedReport() {
    // Assuming the report opens in a new tab or window
  }

  verifyReportContents() {
    // Add assertions to verify report contents
  }

  verifyPaymentsWithinDateRange() {
    // Add assertions to verify payments within the date range
  }

  verifyPaymentDetails() {
    // Add assertions to verify payment details
  }

  verifyReportFormatting() {
    // Add assertions to verify report formatting
  }

  crossCheckReportDataWithSystem() {
    // Add assertions to cross-check report data
  }

  validateTotalPaymentAmount() {
    // Add assertions to validate total payment amount
  }
}

export default ReportingPage;