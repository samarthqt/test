describe('Virtual Waiting Room for Telemedicine', () => {
  const waitingRoomPage = new WaitingRoomPage();

  beforeEach(() => {
    cy.visit('/consultation/waiting-room');
  });

  it('should display the Waiting Room page', () => {
    waitingRoomPage.getPageTitle().should('contain', 'Waiting Room');
  });

  it('should verify patient ID 12345 is listed in the waiting room', () => {
    waitingRoomPage.getPatientById('12345').should('exist');
  });

  it("should verify patient's appointment time is 10:00 AM", () => {
    waitingRoomPage.getAppointmentTimeForPatient('12345').should('contain', '10:00 AM');
  });

  it("should check doctor's availability status for ID 67890", () => {
    waitingRoomPage.getDoctorAvailability('67890').should('contain', 'Available');
  });

  it('should initiate video consultation when doctor is available', () => {
    waitingRoomPage.initiateVideoConsultation('67890');
    waitingRoomPage.getVideoConsultationStatus().should('contain', 'Video consultation started');
  });

  it('should verify patient is removed from the waiting room list post consultation', () => {
    waitingRoomPage.completeConsultationForPatient('12345');
    waitingRoomPage.getPatientById('12345').should('not.exist');
  });
});