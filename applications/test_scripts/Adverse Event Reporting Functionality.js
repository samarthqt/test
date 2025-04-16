describe('Adverse Event Reporting Functionality', () => {
  const participantId = '67890';
  const eventType = 'Severe Headache';
  const eventDescription = 'Participant experienced severe headache post medication.';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Safety Monitoring module', () => {
    cy.get('#safetyMonitoringModule').click();
    cy.url().should('include', '/safety-monitoring');
  });

  it('should search for a participant using Participant ID', () => {
    cy.get('#participantSearch').type(participantId);
    cy.get('#searchButton').click();
    cy.get('#participantRecord').should('contain', participantId);
  });

  it('should view detailed adverse event information', () => {
    cy.get('#participantRecord').click();
    cy.get('#adverseEventDetails').should('be.visible');
  });

  it('should log a new adverse event', () => {
    cy.get('#logNewEventButton').click();
    cy.get('#eventType').select(eventType);
    cy.get('#eventDescription').type(eventDescription);
    cy.get('#saveEventButton').click();
    cy.get('#successMessage').should('contain', 'Event logged successfully');
  });

  it('should verify alerts are sent to investigators', () => {
    cy.get('#alerts').should('contain', 'Alerts sent to investigators');
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});