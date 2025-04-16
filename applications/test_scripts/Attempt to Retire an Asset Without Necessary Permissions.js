describe('Attempt to Retire an Asset Without Necessary Permissions', () => {
  const assetId = 'A12345';
  const restrictedUser = { username: 'restrictedUser', password: 'password' };

  beforeEach(() => {
    cy.visit('/login');
    cy.login(restrictedUser.username, restrictedUser.password);
  });

  it('should not allow retiring an asset without permissions', () => {
    cy.visit('/asset-management');
    cy.contains('Asset Management').should('be.visible');

    cy.get('.search-input').type(assetId);
    cy.get('.search-button').click();

    cy.contains(assetId).should('be.visible');

    cy.get('.retire-asset-button').should('not.exist');

    cy.visit(`/asset-management/retire/${assetId}`);
    cy.contains('Access Denied').should('be.visible');
  });
});