describe('Appointment Wait Time Estimation with Invalid Patient ID', () => {
  before(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
  });

  it('Should navigate to Wait Time Estimation module', () => {
    cy.get('.dashboard').contains('Wait Time Estimation').click();
    cy.url().should('include', '/wait-time-estimation');
  });

  it('Should display error for invalid patient ID', () => {
    cy.get('#patientIdInput').type('ABC123');
    cy.get('#searchButton').click();
    cy.get('.error-message').should('contain', 'Patient ID is invalid or not found');
  });

  after(() => {
    cy.logout();
  });
});