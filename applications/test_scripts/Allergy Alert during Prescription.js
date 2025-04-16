describe('Allergy Alert during Prescription', () => {
  const loginPage = new LoginPage();
  const patientPage = new PatientPage();
  const prescriptionPage = new PrescriptionPage();

  before(() => {
    cy.visit('/');
    loginPage.login('doctorUsername', 'doctorPassword');
  });

  it('should alert doctor of patient allergies when prescribing medication', () => {
    patientPage.accessPatientRecord('67890');
    prescriptionPage.selectPrescribeMedication();
    prescriptionPage.enterMedication('Amoxicillin');
    prescriptionPage.submitPrescription();
    prescriptionPage.verifyAllergyAlert('Penicillin');
    prescriptionPage.acknowledgeAllergyAlert();
  });
});