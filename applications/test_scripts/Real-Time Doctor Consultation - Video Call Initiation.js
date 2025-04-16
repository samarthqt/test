describe('Real-Time Doctor Consultation - Video Call Initiation', () => {
  const patientPortal = new PatientPortal();
  const consultationModule = new ConsultationModule();

  before(() => {
    cy.visit('https://patientportal.com');
  });

  it('should log in to the patient portal', () => {
    patientPortal.login('P12345', 'validPassword');
    patientPortal.verifyLoginSuccess();
  });

  it('should navigate to the Consultation module', () => {
    consultationModule.navigate();
    consultationModule.verifyModuleDisplayed();
  });

  it('should select Real-Time Consultation option', () => {
    consultationModule.selectRealTimeConsultation();
    consultationModule.verifyDoctorListDisplayed();
  });

  it('should select a doctor and start consultation', () => {
    consultationModule.selectDoctor('D67890');
    consultationModule.verifyDoctorDetailsDisplayed();
    consultationModule.startConsultation();
  });

  it('should allow browser access to camera and microphone', () => {
    consultationModule.allowCameraAndMicrophoneAccess();
    consultationModule.verifyAccessGranted();
  });

  it('should initiate the video call', () => {
    consultationModule.initiateVideoCall();
    consultationModule.verifyVideoCallInitiated();
  });

  it('should conduct the consultation', () => {
    consultationModule.conductConsultation();
    consultationModule.verifyConsultationConducted();
  });

  it('should end the call after consultation', () => {
    consultationModule.endCall();
    consultationModule.verifyCallEnded();
  });

  it('should log out from the patient portal', () => {
    patientPortal.logout();
    patientPortal.verifyLogoutSuccess();
  });
});