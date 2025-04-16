describe('Lab Test History - View Test Results', () => {
  const patientId = 'P12345';
  const labTestId = 'L56789';

  before(() => {
    cy.visit('/login');
    cy.get('input[name="patientId"]').type(patientId);
    cy.get('input[name="password"]').type('password');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/dashboard');
  });

  it('should display lab test history', () => {
    cy.get('nav').contains('Lab Test History').click();
    cy.url().should('include', '/lab-test-history');
    cy.get('.lab-test-list').should('be.visible');
  });

  it('should display details for a specific lab test', () => {
    cy.get(`.lab-test-item[data-id="${labTestId}"]`).click();
    cy.get('.lab-test-details').should('be.visible');
    cy.get('.lab-test-date').should('contain.text', '2023-10-01');
    cy.get('.lab-test-results').should('contain.text', 'Results Text');
    cy.get('.lab-test-interpretation').should('contain.text', 'Interpretation Text');
  });

  after(() => {
    cy.get('button.logout').click();
    cy.url().should('include', '/login');
  });
});