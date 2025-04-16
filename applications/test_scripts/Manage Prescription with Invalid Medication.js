describe('Manage Prescription with Invalid Medication', () => {
  const doctorId = 'D001';
  const patientId = 'P12345';
  const invalidMedication = 'InvalidMed';
  const dosage = '500mg';
  const frequency = 'Twice a day';

  before(() => {
    cy.visit('/login');
    cy.login(doctorId);
  });

  it('should navigate to Prescription Management section', () => {
    cy.get('#main-menu').contains('Prescription Management').click();
    cy.url().should('include', '/prescription-management');
  });

  it('should display Prescription Management interface', () => {
    cy.get('#manage-prescriptions').click();
    cy.get('.prescription-interface').should('be.visible');
  });

  it('should display error for invalid medication', () => {
    cy.get('#patient-id').type(patientId);
    cy.get('#medication-name').type(invalidMedication);
    cy.get('#dosage').type(dosage);
    cy.get('#frequency').type(frequency);
    cy.get('#prescribe-button').click();
    cy.get('.error-message').should('contain', 'Medication not listed');
  });

  after(() => {
    cy.logout();
  });
});