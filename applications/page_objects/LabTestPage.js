class LabTestPage {
  navigateToLabTestScheduling() {
    cy.visit('/lab-test-scheduling');
  }

  verifyLabTestSchedulingSection() {
    cy.contains('Lab Test Scheduling').should('be.visible');
  }

  selectTest(testType) {
    cy.get('select[name="testType"]').select(testType);
  }

  verifyTestSelected(testType) {
    cy.get('select[name="testType"]').should('have.value', testType);
  }

  setPreferredDate(date) {
    cy.get('input[name="preferredDate"]').type(date);
  }

  verifyPreferredDate(date) {
    cy.get('input[name="preferredDate"]').should('have.value', date);
  }

  selectLocation(location) {
    cy.get('select[name="location"]').select(location);
  }

  verifyLocationSelected(location) {
    cy.get('select[name="location"]').should('have.value', location);
  }

  scheduleTest() {
    cy.get('button[name="scheduleTest"]').click();
  }

  verifyTestScheduled() {
    cy.contains('Test scheduled successfully').should('be.visible');
  }

  verifyReminderSet() {
    cy.contains('Reminder set for test date').should('be.visible');
  }

  verifyScheduledTestPersistence() {
    cy.contains('Scheduled Test Details').should('be.visible');
  }

  attemptScheduleOnFullyBookedDate() {
    cy.get('input[name="preferredDate"]').type('2023-12-05');
    cy.get('button[name="scheduleTest"]').click();
  }

  verifyFullyBookedError() {
    cy.contains('Selected date is not available').should('be.visible');
  }

  attemptScheduleWithoutLocation() {
    cy.get('select[name="testType"]').select('Blood Test');
    cy.get('input[name="preferredDate"]').type('2023-12-01');
    cy.get('button[name="scheduleTest"]').click();
  }

  verifyLocationError() {
    cy.contains('A location must be selected').should('be.visible');
  }

  attemptScheduleWithInvalidDate() {
    cy.get('input[name="preferredDate"]').type('12/01/2023');
    cy.get('button[name="scheduleTest"]').click();
  }

  verifyDateFormatError() {
    cy.contains('Invalid date format').should('be.visible');
  }

  rescheduleTest(newDate) {
    cy.get('button[name="rescheduleTest"]').click();
    cy.get('input[name="preferredDate"]').type(newDate);
    cy.get('button[name="confirmReschedule"]').click();
  }

  verifyRescheduling() {
    cy.contains('Rescheduled successfully').should('be.visible');
  }

  verifyReminderNotification() {
    cy.contains('Reminder notification sent').should('be.visible');
  }

  cancelScheduledTest() {
    cy.get('button[name="cancelTest"]').click();
  }

  verifyCancellation() {
    cy.contains('Test cancelled').should('be.visible');
  }

  scheduleMultipleTestsSameDate() {
    cy.get('select[name="testType"]').select('Blood Test');
    cy.get('input[name="preferredDate"]').type('2023-12-01');
    cy.get('button[name="scheduleTest"]').click();
    cy.get('select[name="testType"]').select('Urine Test');
    cy.get('button[name="scheduleTest"]').click();
  }

  verifyMultipleTestsScheduled() {
    cy.contains('Multiple tests scheduled').should('be.visible');
  }

  verifyAvailabilityUpdate() {
    cy.contains('Availability updated').should('be.visible');
  }
}