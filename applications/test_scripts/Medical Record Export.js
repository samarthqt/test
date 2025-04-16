describe('Medical Record Export Test', () => {
  const patientPortal = new PatientPortalPage();

  before(() => {
    cy.visit('https://patientportal.example.com');
  });

  it('should log into the patient portal', () => {
    patientPortal.login('username', 'password');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Medical Records section', () => {
    patientPortal.navigateToMedicalRecords();
    cy.contains('Medical Records').should('be.visible');
  });

  it('should select a medical record to export', () => {
    patientPortal.selectMedicalRecord('Medical History');
    cy.contains('Medical History Details').should('be.visible');
  });

  it('should choose export format as PDF', () => {
    patientPortal.chooseExportFormat('PDF');
    cy.contains('PDF format selected').should('be.visible');
  });

  it('should export the medical record', () => {
    patientPortal.exportRecord();
    cy.contains('Export successful').should('be.visible');
  });

  it('should download the exported medical record', () => {
    patientPortal.downloadRecord();
    cy.readFile('cypress/downloads/MedicalHistory.pdf').should('exist');
  });

  it('should verify the contents of the downloaded file', () => {
    cy.readFile('cypress/downloads/MedicalHistory.pdf').then(contents => {
      expect(contents).to.include('Patient Medical History');
    });
  });
});