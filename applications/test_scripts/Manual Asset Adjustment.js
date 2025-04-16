describe('Manual Asset Adjustment', () => {
  const assetId = '12345';
  const correctDate = '2023-01-01';
  const justification = 'Correcting incorrect registration date';

  beforeEach(() => {
    cy.visit('/login');
    cy.login('username', 'password'); // Custom command for login
    cy.visit('/asset-management');
  });

  it('should allow user to edit asset registration date with justification', () => {
    const assetPage = new AssetPage();

    assetPage.searchAssetById(assetId);
    assetPage.verifyAssetDetailsDisplayed(assetId);

    assetPage.editRegistrationDate(correctDate);
    assetPage.provideJustification(justification);
    assetPage.saveChanges();

    assetPage.verifyRegistrationDateUpdated(correctDate);
  });
});