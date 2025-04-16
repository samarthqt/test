describe('TC-698 103 Manage Prescription - Edge Case Test', () => {
  const doctorId = 'D001';
  const patientId = 'P12345';
  const medicationName = 'Amoxicillin';
  const dosage = '1000mg';
  const frequency = 'Four times a day';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type(doctorId);
    cy.get('#password').type('validPassword');
    cy.get('#login-button').click();
    cy.url().should('include', '/dashboard');
  });

  it('Navigate to Prescription Management section', () => {
    cy.get('#main-menu').contains('Prescription Management').click();
    cy.url().should('include', '/prescription-management');
  });

  it('Select Manage Prescriptions', () => {
    cy.get('#manage-prescriptions').click();
    cy.get('#prescription-interface').should('be.visible');
  });

  it('Enter Patient ID and Medication Details', () => {
    cy.get('#patient-id').type(patientId);
    cy.get('#medication-name').type(medicationName);
    cy.get('#dosage').type(dosage);
    cy.get('#frequency').type(frequency);
    cy.get('#submit-prescription').click();
    cy.get('#warning-message').should('contain', 'exceeding recommended dosage limits');
  });

  it('Attempt to prescribe medication with high dosage', () => {
    cy.get('#confirm-prescription').click();
    cy.get('#error-message').should('contain', 'adjust dosage');
  });

  after(() => {
    cy.get('#logout-button').click();
    cy.url().should('include', '/login');
  });
});