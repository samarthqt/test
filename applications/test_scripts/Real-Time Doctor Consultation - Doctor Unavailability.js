describe('Real-Time Doctor Consultation - Doctor Unavailability', () => {
  const patientPortal = new PatientPortal();
  const consultationModule = new ConsultationModule();

  it('should handle doctor unavailability during consultation', () => {
    // Step 1: Log in to the patient portal
    cy.visit('/login');
    patientPortal.login('P12345', 'password');
    patientPortal.verifyLogin();

    // Step 2: Navigate to Consultation module
    consultationModule.navigateToConsultation();
    consultationModule.verifyConsultationModuleDisplayed();

    // Step 3: Select Real-Time Consultation option
    consultationModule.selectRealTimeConsultation();
    consultationModule.verifyDoctorListDisplayed();

    // Step 4: Select a doctor marked as unavailable
    consultationModule.selectUnavailableDoctor('D67891');
    consultationModule.verifyDoctorUnavailableMessage();

    // Step 5: Attempt to start a consultation with the unavailable doctor
    consultationModule.attemptStartConsultation('D67891');
    consultationModule.verifyConsultationStartError();

    // Step 6: Log out from the patient portal
    patientPortal.logout();
    patientPortal.verifyLogout();
  });
});