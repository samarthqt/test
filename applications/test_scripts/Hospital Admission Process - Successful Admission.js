describe('Hospital Admission Process - Successful Admission', () => {
  const patientPortal = new PatientPortal();
  const hospitalAdmission = new HospitalAdmission();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the patient portal', () => {
    patientPortal.login('patientUsername', 'patientPassword');
    patientPortal.verifyLoginSuccess();
  });

  it('should navigate to Hospital Admission module', () => {
    hospitalAdmission.navigate();
    hospitalAdmission.verifyModuleDisplayed();
  });

  it('should enter personal details', () => {
    hospitalAdmission.enterPersonalDetails('John Doe', 30, 'Male');
  });

  it('should enter contact details', () => {
    hospitalAdmission.enterContactDetails('1234567890', 'john.doe@example.com');
  });

  it('should select admission date', () => {
    hospitalAdmission.selectAdmissionDate('2023-10-20');
  });

  it('should select department for admission', () => {
    hospitalAdmission.selectDepartment('Cardiology');
  });

  it('should enter insurance details', () => {
    hospitalAdmission.enterInsuranceDetails('Insurance123');
  });

  it('should review all entered details', () => {
    hospitalAdmission.reviewDetails();
  });

  it('should submit the admission form', () => {
    hospitalAdmission.submitForm();
    hospitalAdmission.verifySubmissionSuccess();
  });

  it('should log out from the patient portal', () => {
    patientPortal.logout();
    patientPortal.verifyLogoutSuccess();
  });
});