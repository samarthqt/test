describe('Appointment Rescheduling Functionality', () => {
  const appointmentPage = new AppointmentPage();

  before(() => {
    cy.visit('https://patientportal.com');
  });

  it('should allow patient to log in and reschedule an appointment', () => {
    appointmentPage.login('54321', 'validPassword');
    appointmentPage.navigateToAppointments();
    appointmentPage.identifyMissedAppointment('AP12345');
    appointmentPage.clickRescheduleButton();
    appointmentPage.selectNewDate('2023-11-15');
    appointmentPage.selectNewTime('10:00 AM');
    appointmentPage.confirmNewAppointmentDetails();
    appointmentPage.confirmReschedule();
    appointmentPage.verifyEmailConfirmation();
    appointmentPage.logout();
  });
});