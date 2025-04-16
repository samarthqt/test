describe('Asset Registration Validation - Positive Scenario', () => {
  const assetData = {
    name: 'Computer',
    type: 'Electronics',
    serialNumber: 'SN123456',
    purchaseDate: '2023-01-01',
    cost: '$1000'
  };

  beforeEach(() => {
    cy.visit('/login');
    cy.get('#username').type('validUser');
    cy.get('#password').type('validPassword');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/dashboard');
    cy.get('a[href="/asset-registration"]').click();
    cy.url().should('include', '/asset-registration');
  });

  it('should validate and register asset data correctly', () => {
    const assetPage = new AssetRegistrationPage();
    assetPage.enterAssetName(assetData.name);
    assetPage.selectAssetType(assetData.type);
    assetPage.enterSerialNumber(assetData.serialNumber);
    assetPage.enterPurchaseDate(assetData.purchaseDate);
    assetPage.enterCost(assetData.cost);
    assetPage.submitForm();

    cy.get('.asset-list').should('contain', assetData.name);
    cy.get('.asset-list').should('contain', assetData.type);
    cy.get('.asset-list').should('contain', assetData.serialNumber);
    cy.get('.asset-list').should('contain', assetData.purchaseDate);
    cy.get('.asset-list').should('contain', assetData.cost);
  });
});