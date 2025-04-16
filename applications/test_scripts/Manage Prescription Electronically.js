describe('Manage Prescription Electronically', () => {
  const doctorCredentials = { username: 'doctor', password: 'password' };
  const patientCredentials = { username: 'patient', password: 'password' };
  const prescriptionDetails = {
    patientId: 'P12345',
    medicationName: 'Amoxicillin',
    dosage: '500mg',
    frequency: 'Twice a day',
    date: '2023-10-10'
  };

  before(() => {
    cy.visit('application-url');
  });

  it('Doctor can prescribe medication', () => {
    cy.login(doctorCredentials.username, doctorCredentials.password);
    cy.url().should('include', '/dashboard');

    cy.get('[data-test=menu-prescription]').click();
    cy.url().should('include', '/prescription-management');

    cy.get('[data-test=manage-prescriptions]').click();
    cy.get('[data-test=prescription-form]').should('be.visible');

    cy.get('[data-test=patient-id]').type(prescriptionDetails.patientId);
    cy.get('[data-test=medication-name]').type(prescriptionDetails.medicationName);
    cy.get('[data-test=dosage]').type(prescriptionDetails.dosage);
    cy.get('[data-test=frequency]').type(prescriptionDetails.frequency);

    cy.get('[data-test=prescribe-button]').click();
    cy.get('[data-test=confirmation-message]').should('contain', 'Prescription confirmed');
  });

  it('Patient can view prescription', () => {
    cy.login(patientCredentials.username, patientCredentials.password);
    cy.url().should('include', '/dashboard');

    cy.get('[data-test=menu-prescription]').click();
    cy.url().should('include', '/prescription-management');

    cy.get('[data-test=view-prescriptions]').click();
    cy.get('[data-test=prescription-list]').should('be.visible');

    cy.get('[data-test=prescription-details]').should('contain', prescriptionDetails.medicationName);
    cy.get('[data-test=prescription-details]').should('contain', prescriptionDetails.dosage);
    cy.get('[data-test=prescription-details]').should('contain', prescriptionDetails.frequency);
  });

  after(() => {
    cy.logout();
  });
});