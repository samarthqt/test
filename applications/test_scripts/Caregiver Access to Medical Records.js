describe('Caregiver Access to Medical Records', () => {
  const caregiverId = 'C987';
  const patientId = 'P123';

  before(() => {
    cy.visit('/login');
    cy.loginAsCaregiver(caregiverId);
  });

  it('should display caregiver dashboard with linked patient records', () => {
    cy.get('.dashboard').should('be.visible');
    cy.get('.patient-records').should('contain', patientId);
  });

  it('should allow viewing of a patient record', () => {
    cy.visit(`/patient-records/${patientId}`);
    cy.get('.medical-record').should('be.visible');
    cy.get('.permission-level').should('contain', 'View Only');
  });

  it('should restrict editing of the medical record', () => {
    cy.get('.edit-button').should('be.disabled');
    cy.get('.edit-button').click({ force: true });
    cy.get('.error-message').should('contain', 'Permission denied');
  });

  after(() => {
    cy.logout();
    cy.url().should('include', '/login');
  });
});