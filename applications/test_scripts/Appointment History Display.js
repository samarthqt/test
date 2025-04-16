describe('Appointment History Display', () => {
  const patientId = '44556';
  before(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
  });

  it('should navigate to the Appointment History section', () => {
    cy.get('nav').contains('Appointment History').click();
    cy.url().should('include', '/appointment-history');
  });

  it('should select the date range for viewing appointment history', () => {
    cy.get('input[name="date-range"]').type('Last 6 months');
    cy.get('button').contains('Apply').click();
    cy.get('.date-range-display').should('contain', 'Last 6 months');
  });

  it('should display the list of appointments within the selected date range', () => {
    cy.get('.appointment-list').should('be.visible');
    cy.get('.appointment-item').should('have.length.greaterThan', 0);
  });

  it('should display detailed information for a selected appointment', () => {
    cy.get('.appointment-item').first().click();
    cy.get('.appointment-details').should('be.visible');
    cy.get('.appointment-details').should('contain', 'Doctor's notes');
    cy.get('.appointment-details').should('contain', 'Services rendered');
  });
});