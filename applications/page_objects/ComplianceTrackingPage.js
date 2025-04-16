class ComplianceTrackingPage {
  loginAsAdmin() {
    cy.visit('/login');
    cy.get('#username').type('admin');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
  }

  visitComplianceTracking() {
    cy.get('#complianceTrackingLink').click();
  }

  selectStudyProtocol(studyProtocolId) {
    cy.get('#protocolList').select(studyProtocolId);
  }

  selectParticipant(participantId) {
    cy.get('#participantList').select(participantId);
  }

  enterDeviationDetails(participantId, details) {
    cy.get(`#deviationInput-${participantId}`).type(details);
    cy.get('#saveDeviationButton').click();
  }

  submitComplianceReport(participantId) {
    cy.get(`#submitReportButton-${participantId}`).click();
  }

  verifyComplianceReport(participantId, details) {
    cy.get(`#report-${participantId}`).contains(details);
  }

  checkAlertsSent(participantId) {
    cy.get(`#alerts-${participantId}`).should('exist');
  }

  accessComplianceDashboard() {
    cy.get('#complianceDashboardLink').click();
  }

  exportComplianceData(participantId) {
    cy.get(`#exportButton-${participantId}`).click();
  }

  verifyCSVExport(participantId) {
    cy.readFile(`cypress/downloads/${participantId}_compliance.csv`).should('exist');
  }

  generateSummaryReport(studyProtocolId) {
    cy.get(`#generateSummaryButton-${studyProtocolId}`).click();
  }

  filterComplianceDataByDeviationType(deviationType) {
    cy.get('#filterDeviationType').select(deviationType);
  }

  reviewAuditTrail(participantId) {
    cy.get(`#auditTrailLink-${participantId}`).click();
  }

  validateSecurityMeasures() {
    cy.get('#securityMeasuresLink').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}

module.exports = new ComplianceTrackingPage();