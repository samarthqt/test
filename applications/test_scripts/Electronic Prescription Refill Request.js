describe('Electronic Prescription Refill Request', () => {
  const patientPortal = new PatientPortal();

  before(() => {
    cy.visit('https://patientportal.example.com');
  });

  it('should log into the patient portal', () => {
    patientPortal.login('patient123', 'password123');
    patientPortal.verifyLoginSuccess();
  });

  it('should navigate to prescriptions section', () => {
    patientPortal.navigateToPrescriptions();
    patientPortal.verifyPrescriptionsList();
  });

  it('should select the prescription to be refilled', () => {
    patientPortal.selectPrescription('RX987654');
    patientPortal.verifyPrescriptionDetails('Lipitor', '20mg');
  });

  it('should request a refill', () => {
    patientPortal.requestRefill();
    patientPortal.enterRefillQuantity(30);
    patientPortal.submitRefillRequest();
    patientPortal.verifyRefillRequestSubmission();
  });

  it('should check refill request status', () => {
    patientPortal.checkRefillRequestStatus('Pending Approval');
  });

  it('should receive notification of approval', () => {
    patientPortal.verifyNotificationReceived();
  });

  it('should verify refill status updates to approved', () => {
    patientPortal.verifyRefillStatus('Approved');
  });

  it('should check prescription history for refill entry', () => {
    patientPortal.verifyPrescriptionHistoryEntry();
  });
});