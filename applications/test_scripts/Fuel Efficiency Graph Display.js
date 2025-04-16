describe('Fuel Efficiency Graph Display', () => {
  before(() => {
    cy.visit('https://vehicle-monitoring-system.com');
    cy.login('U123456', 'password');
  });

  it('should navigate to Fuel Management module', () => {
    cy.get('.menu').contains('Fuel Management').click();
    cy.url().should('include', '/fuel-management');
  });

  it('should select the registered vehicle', () => {
    cy.get('.vehicle-list').contains('V987654').click();
    cy.get('.vehicle-details').should('contain', 'Fuel Consumption Data: [20, 22, 18, 25]');
  });

  it('should display fuel efficiency tracking options', () => {
    cy.get('.tracker-button').contains('Fuel Efficiency Tracker').click();
    cy.get('.tracker-options').should('be.visible');
  });

  it('should select time period and display graph', () => {
    cy.get('.time-period-selector').select('Last 6 months');
    cy.get('.display-graph-button').click();
    cy.get('.fuel-efficiency-graph').should('be.visible');
  });

  it('should verify graph displays fuel efficiency data correctly', () => {
    cy.get('.fuel-efficiency-graph').should('contain', 'Fuel Consumption Data');
  });

  it('should check for suggestions to improve fuel efficiency', () => {
    cy.get('.fuel-efficiency-suggestions').should('be.visible');
  });
});