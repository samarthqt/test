class VisitTrackingPage {
  navigate() {
    cy.visit('/visit-tracking');
  }

  verifyPageLoaded() {
    cy.get('.visit-tracking-header').should('be.visible');
  }

  selectParticipant(name) {
    cy.get('.participant-list').contains(name).click();
  }

  verifyParticipantDetailsDisplayed(name) {
    cy.get('.participant-details').should('contain', name);
  }

  scheduleVisit(participantName, visitData) {
    this.selectParticipant(participantName);
    cy.get('.schedule-visit-button').click();
    cy.fillVisitForm(visitData);
    cy.get('.submit-visit-button').click();
  }

  verifyVisitScheduled(participantName, visitData) {
    this.selectParticipant(participantName);
    cy.get('.visit-history').should('contain', visitData.date);
  }

  recordUnscheduledVisit(participantName, visitData) {
    this.selectParticipant(participantName);
    cy.get('.record-unscheduled-visit-button').click();
    cy.fillVisitForm(visitData);
    cy.get('.submit-visit-button').click();
  }

  verifyUnscheduledVisitRecorded(participantName, visitData) {
    this.selectParticipant(participantName);
    cy.get('.visit-history').should('contain', visitData.date);
  }

  verifyAllVisitsTracked(participantName) {
    this.selectParticipant(participantName);
    cy.get('.visit-history').should('contain', 'Scheduled').and('contain', 'Unscheduled');
  }

  verifyNotificationsForScheduledVisits() {
    cy.get('.notifications').should('contain', 'Upcoming scheduled visit');
  }

  trackVisitWithInvalidData(invalidData) {
    cy.get('.track-visit-button').click();
    cy.fillVisitForm(invalidData);
    cy.get('.submit-visit-button').click();
  }

  verifyErrorMessageDisplayed() {
    cy.get('.error-message').should('be.visible');
  }

  verifyDataSecurity() {
    cy.checkDataSecurity('.visit-data');
  }

  verifyAuditTrail() {
    cy.get('.audit-trail').should('contain', 'Visit tracked');
  }

  generateVisitReports(participantName) {
    this.selectParticipant(participantName);
    cy.get('.generate-report-button').click();
  }

  verifyVisitReportsGenerated(participantName) {
    cy.get('.report').should('contain', participantName);
  }

  verifyPerformanceWithLargeData() {
    cy.get('.large-data-performance').should('not.have.class', 'slow');
  }

  verifyComplianceWithStandards() {
    cy.get('.compliance-check').should('contain', 'Compliant');
  }

  updateVisitDetails(participantName, visitData) {
    this.selectParticipant(participantName);
    cy.get('.edit-visit-button').click();
    cy.fillVisitForm(visitData);
    cy.get('.submit-visit-button').click();
  }

  verifyVisitDetailsUpdated(participantName) {
    this.selectParticipant(participantName);
    cy.get('.visit-history').should('contain', 'Updated');
  }
}

export default new VisitTrackingPage();