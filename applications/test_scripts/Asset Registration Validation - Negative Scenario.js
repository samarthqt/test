describe('Asset Registration Validation - Negative Scenario', () => {
  beforeEach(() => {
    cy.login('user', 'password'); // Custom command for logging in
    cy.visit('/asset-registration');
  });

  it('should reject asset registration with missing Asset Name and Serial Number', () => {
    const assetPage = new AssetRegistrationPage();
    assetPage.selectAssetType('Electronics');
    assetPage.enterPurchaseDate('2023-01-01');
    assetPage.enterCost('$1000');
    assetPage.submitForm();

    cy.contains('Error: Missing Asset Name and Serial Number').should('be.visible');
    cy.get('.asset-list').should('not.contain', 'Electronics');
  });
});