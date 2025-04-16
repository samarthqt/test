describe('EHR Management System Test', () => {
  const ehrPage = new EHRPage();

  before(() => {
    cy.visit('/login');
    ehrPage.login('validUsername', 'validPassword');
  });

  it('should add a new patient record', () => {
    ehrPage.navigateToEHRModule();
    ehrPage.addNewPatientRecord();
    ehrPage.enterPatientDetails('John Doe', 'Penicillin', 'Hypertension', 'Medication - Lisinopril');
    ehrPage.savePatientRecord();
  });

  it('should verify the saved patient record', () => {
    ehrPage.logout();
    ehrPage.login('validUsername', 'validPassword');
    ehrPage.navigateToEHRModule();
    ehrPage.searchPatient('John Doe');
    ehrPage.verifyPatientRecord('John Doe', 'Penicillin', 'Hypertension', 'Medication - Lisinopril');
  });

  it('should edit the patient's treatment history', () => {
    ehrPage.editTreatmentHistory('Updated Medication');
    ehrPage.savePatientRecord();
    ehrPage.verifyUpdatedTreatmentHistory('Updated Medication');
  });

  after(() => {
    ehrPage.logout();
  });
});