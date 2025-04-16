describe('Customizable Asset Types', () => {
  before(() => {
    cy.visit('/login');
    cy.get('#username').type('admin');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should allow admin to create and verify custom asset type', () => {
    const assetPage = new AssetPage();

    assetPage.navigateToCustomization();
    assetPage.createAssetType('Office Equipment');
    assetPage.defineAttributes('Brand', 'Model', 'Warranty Period');
    assetPage.saveAssetType();
    assetPage.verifyAssetType('Office Equipment');
  });
});