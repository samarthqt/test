class BillingPage {
  visitLoginPage() {
    cy.visit('/login');
  }

  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }

  verifyLoginSuccess() {
    cy.url().should('include', '/dashboard');
  }

  navigateToAppointmentDetails(patientId) {
    cy.visit(`/patients/${patientId}/appointments`);
  }

  checkInsuranceVerificationStatus() {
    cy.get('#insurance-status').should('contain', 'Pending');
  }

  triggerInsuranceVerification() {
    cy.get('#verify-insurance-button').click();
  }

  verifyInsuranceResponse() {
    cy.get('#insurance-response').should('exist');
  }

  checkUpdatedVerificationStatus() {
    cy.get('#insurance-status').should('not.contain', 'Pending');
  }

  verifyCoverageDetails() {
    cy.get('#coverage-details').should('match', /coverage details regex/);
  }

  checkAlertsOrNotifications() {
    cy.get('#alerts').should('exist');
  }

  attemptToScheduleAppointment() {
    cy.get('#schedule-appointment-button').click();
  }

  reviewVerificationLog() {
    cy.get('#verification-log').should('contain', 'Latest verification attempt');
  }
}

module.exports = BillingPage;