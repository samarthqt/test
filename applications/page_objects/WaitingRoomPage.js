class WaitingRoomPage {
  getPageTitle() {
    return cy.get('h1');
  }

  getPatientById(patientId) {
    return cy.get(`[data-patient-id="${patientId}"]`);
  }

  getAppointmentTimeForPatient(patientId) {
    return cy.get(`[data-patient-id="${patientId}"] .appointment-time`);
  }

  getDoctorAvailability(doctorId) {
    return cy.get(`[data-doctor-id="${doctorId}"] .availability-status`);
  }

  initiateVideoConsultation(doctorId) {
    cy.get(`[data-doctor-id="${doctorId}"] .start-consultation`).click();
  }

  getVideoConsultationStatus() {
    return cy.get('.video-consultation-status');
  }

  completeConsultationForPatient(patientId) {
    cy.get(`[data-patient-id="${patientId}"] .complete-consultation`).click();
  }
}