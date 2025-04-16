class SiteCoordinator {
  login() {
    cy.visit('/login');
    cy.get('#username').type('site_coordinator');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
  }

  visitSchedulingModule() {
    cy.get('#visitSchedulingModule').click();
  }

  selectSite(siteId) {
    cy.get('#siteList').select(siteId);
    cy.get('#siteDetails').should('be.visible');
  }

  scheduleNewVisit() {
    cy.get('#scheduleNewVisitButton').click();
    cy.get('#newVisitForm').should('be.visible');
  }

  enterVisitDate(date) {
    cy.get('#visitDate').type(date);
  }

  linkTrialProgressReport(reportId) {
    cy.get('#trialProgressReport').select(reportId);
  }

  submitVisitSchedule() {
    cy.get('#submitVisitSchedule').click();
  }

  verifyVisitSchedule(reportId) {
    cy.get('#visitSchedule').should('contain', reportId);
  }

  verifyNotifications() {
    cy.get('#notifications').should('contain', 'Visit scheduled notification sent');
  }

  accessSiteCalendar() {
    cy.get('#siteCalendar').click();
    cy.get('#scheduledVisits').should('be.visible');
  }

  exportVisitScheduleToPDF() {
    cy.get('#exportToPDFButton').click();
    cy.get('#pdfExportSuccess').should('be.visible');
  }

  generateVisitSummaryReport() {
    cy.get('#generateSummaryReportButton').click();
    cy.get('#summaryReport').should('be.visible');
  }

  checkReschedulingOptions() {
    cy.get('#reschedulingOptions').should('be.visible');
  }

  reviewAuditTrail(siteId) {
    cy.get('#auditTrail').click();
    cy.get(`#auditTrail-${siteId}`).should('be.visible');
  }

  validateSecurityMeasures() {
    cy.get('#securityMeasures').should('be.visible');
  }
}