describe('Data Entry Form Validation Test', () => {
  const loginPage = new LoginPage();
  const dataEntryPage = new DataEntryPage();

  beforeEach(() => {
    // Setup: Clinician login
    cy.visit('/login');
    loginPage.login('clinician_username', 'clinician_password');
  });

  it('should display an error when submitting incomplete data', () => {
    // Step 1: Access the Data Entry Forms section
    dataEntryPage.accessDataEntryForms();
    
    // Assert that the Data Entry Forms are accessible
    dataEntryPage.verifyDataEntryFormsAccessible();

    // Step 2: Attempt to submit the form with incomplete data
    dataEntryPage.enterStudyID('12345');
    dataEntryPage.enterPatientID('P001');
    dataEntryPage.submitForm();

    // Assert that an error message is displayed
    dataEntryPage.verifyErrorMessage('All required fields must be filled.');
  });
});