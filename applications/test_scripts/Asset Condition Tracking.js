describe('Asset Condition Tracking', () => {
  const assetID = 'A789';
  const initialCondition = 'Needs Repair';
  const updatedCondition = 'Good';

  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should record the condition of an asset', () => {
    cy.visit('/asset-management');
    cy.get('.asset-management-module').click();
    cy.get('.condition-tracking-submodule').click();
    cy.get('.search-field').type(assetID);
    cy.get('.search-button').click();
    cy.get('.asset-details').should('contain', assetID);
    cy.get('.record-condition-button').click();
    cy.get('.condition-dropdown').select(initialCondition);
    cy.get('.submit-condition-button').click();
    cy.get('.asset-details').should('contain', initialCondition);
    cy.get('.edit-condition-button').click();
    cy.get('.condition-dropdown').select(updatedCondition);
    cy.get('.submit-condition-button').click();
    cy.get('.asset-details').should('contain', updatedCondition);
  });

  afterEach(() => {
    cy.logout();
    cy.url().should('include', '/login');
  });
});