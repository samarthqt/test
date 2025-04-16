describe('TC-478 365 Multi-user Support for Asset Actions - Negative Scenario', () => {
  const assetId = 'A12345';
  before(() => {
    cy.visit('/login');
    cy.get('#username').type('User4');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
    cy.url().should('include', '/asset-management');
  });
  it('should not allow User4 to select the asset', () => {
    cy.get(`#asset-${assetId}`).should('not.exist');
  });
  it('should show error message when User4 attempts allocation action', () => {
    cy.get('#allocateButton').click();
    cy.get('.error-message').should('contain', 'lack of permissions');
  });
  it('should show error message when User4 attempts maintenance action', () => {
    cy.get('#maintenanceButton').click();
    cy.get('.error-message').should('contain', 'lack of permissions');
  });
  it('should show error message when User4 attempts transfer action', () => {
    cy.get('#transferButton').click();
    cy.get('.error-message').should('contain', 'lack of permissions');
  });
});