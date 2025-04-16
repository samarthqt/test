describe('Medication Interaction Warning Test', () => {
  const patientPortal = new PatientPortal();

  before(() => {
    cy.visit('/login');
    patientPortal.login('validUsername', 'validPassword');
  });

  it('should navigate to the Prescriptions section and check for interactions', () => {
    patientPortal.navigateToPrescriptions();
    patientPortal.selectPrescription('Warfarin');
    patientPortal.checkInteraction();
    patientPortal.verifyWarningMessage();
    patientPortal.reviewInteractionDetails();
    patientPortal.acknowledgeWarning();
  });
});