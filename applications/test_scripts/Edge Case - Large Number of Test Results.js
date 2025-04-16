describe('Edge Case - Large Number of Test Results', () => {
  const patientId = 'P67890';

  before(() => {
    cy.visit('/login');
    cy.login(patientId);
  });

  it('should display the dashboard after login', () => {
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Test Results section', () => {
    cy.get('.test-results-nav').click();
    cy.url().should('include', '/test-results');
    cy.get('.test-results-list').should('be.visible');
  });

  it('should display all test results smoothly', () => {
    cy.get('.test-results-list').scrollTo('bottom');
    cy.get('.test-result-item').should('have.length', 1000);
  });

  it('should display detailed view of the selected test result', () => {
    cy.get('.test-result-item').last().click();
    cy.get('.test-result-detail').should('be.visible');
  });
});