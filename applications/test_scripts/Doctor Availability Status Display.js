describe('Doctor Availability Status Display', () => {
  const patientPortal = new PatientPortalPage();
  const doctorSearch = new DoctorSearchPage();
  const appointments = new AppointmentsPage();

  before(() => {
    cy.visit('/login');
  });

  it('Log into the patient portal using valid credentials', () => {
    patientPortal.login('validUsername', 'validPassword');
    patientPortal.verifyLoginSuccess();
  });

  it('Navigate to the Find a Doctor section', () => {
    doctorSearch.navigateToFindDoctor();
    doctorSearch.verifyFindDoctorSectionDisplayed();
  });

  it('Enter the provider's name or specialty in the search field', () => {
    doctorSearch.enterProviderDetails('DR12345');
    doctorSearch.verifySearchFieldPopulated();
  });

  it('Click on the Search button', () => {
    doctorSearch.clickSearchButton();
    doctorSearch.verifyProviderListDisplayed();
  });

  it('Select a provider from the list to view availability', () => {
    doctorSearch.selectProviderFromList();
    doctorSearch.verifyProviderProfileDisplayed();
  });

  it('Verify the availability status for the selected date and time', () => {
    doctorSearch.verifyAvailabilityStatus('2023-11-10', '2:00 PM');
  });

  it('Navigate to the Appointments section to book an appointment', () => {
    appointments.navigateToAppointments();
    appointments.verifyAppointmentsSectionDisplayed();
  });

  it('Select the available time slot for the provider', () => {
    appointments.selectAvailableTimeSlot();
    appointments.verifyTimeSlotHighlighted();
  });

  it('Confirm the appointment booking', () => {
    appointments.confirmAppointmentBooking();
    appointments.verifyConfirmationMessageDisplayed();
  });

  it('Verify that an email confirmation is sent to the patient', () => {
    appointments.verifyEmailConfirmationSent();
  });

  it('Log out of the patient portal', () => {
    patientPortal.logout();
    patientPortal.verifyLogoutSuccess();
  });
});