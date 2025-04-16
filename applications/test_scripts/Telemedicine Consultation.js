describe('Telemedicine Consultation Test Suite', () => {
  const patient = new PatientPage();
  const doctor = new DoctorPage();

  before(() => {
    cy.visit('/login');
  });

  it('Patient logs in and schedules a consultation', () => {
    patient.login('johndoe123', 'password');
    patient.navigateTelemedicineSection();
    patient.scheduleConsultation('Dr. Smith', '10:00 AM');
    patient.initiateVideoCall();
    patient.endVideoCall();
    patient.checkPrescription('Ibuprofen');
    patient.logout();
  });

  it('Doctor logs in and verifies consultation details', () => {
    doctor.login('drsmith', 'password');
    doctor.verifyConsultationDetails('johndoe123');
    doctor.confirmPrescription('Ibuprofen');
    doctor.logout();
  });

  it('Patient logs back in and checks consultation history', () => {
    patient.login('johndoe123', 'password');
    patient.checkConsultationHistory();
    patient.verifyVideoCallQuality();
    patient.logout();
  });
});