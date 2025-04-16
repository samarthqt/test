describe('Laboratory Test Scheduling - Scheduling and Reminders', () => {
  const labTestPage = new LabTestPage();
  before(() => {
    cy.login('67890');
  });

  it('should navigate to the Lab Test Scheduling section', () => {
    labTestPage.navigateToLabTestScheduling();
    labTestPage.verifyLabTestSchedulingSection();
  });

  it('should select Blood Test from the list of available tests', () => {
    labTestPage.selectTest('Blood Test');
    labTestPage.verifyTestSelected('Blood Test');
  });

  it('should set preferred date to 2023-12-01', () => {
    labTestPage.setPreferredDate('2023-12-01');
    labTestPage.verifyPreferredDate('2023-12-01');
  });

  it('should select City Hospital from the list of available locations', () => {
    labTestPage.selectLocation('City Hospital');
    labTestPage.verifyLocationSelected('City Hospital');
  });

  it('should schedule the test and display confirmation', () => {
    labTestPage.scheduleTest();
    labTestPage.verifyTestScheduled();
  });

  it('should verify that a reminder is set for the test date', () => {
    labTestPage.verifyReminderSet();
  });

  it('should log out and log back in to verify persistence of the scheduled test', () => {
    cy.logout();
    cy.login('67890');
    labTestPage.verifyScheduledTestPersistence();
  });

  it('should display error when scheduling a test on a fully booked date', () => {
    labTestPage.attemptScheduleOnFullyBookedDate();
    labTestPage.verifyFullyBookedError();
  });

  it('should display error when scheduling a test without selecting a location', () => {
    labTestPage.attemptScheduleWithoutLocation();
    labTestPage.verifyLocationError();
  });

  it('should display error when scheduling a test with invalid date format', () => {
    labTestPage.attemptScheduleWithInvalidDate();
    labTestPage.verifyDateFormatError();
  });

  it('should allow rescheduling of a test', () => {
    labTestPage.rescheduleTest('2023-12-02');
    labTestPage.verifyRescheduling();
  });

  it('should send a reminder notification one day before the test', () => {
    labTestPage.verifyReminderNotification();
  });

  it('should allow cancellation of a scheduled test', () => {
    labTestPage.cancelScheduledTest();
    labTestPage.verifyCancellation();
  });

  it('should allow scheduling multiple tests on the same date if slots are available', () => {
    labTestPage.scheduleMultipleTestsSameDate();
    labTestPage.verifyMultipleTestsScheduled();
  });

  it('should update availability after a test is scheduled', () => {
    labTestPage.verifyAvailabilityUpdate();
  });
});