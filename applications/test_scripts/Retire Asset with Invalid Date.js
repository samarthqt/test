describe('Retire Asset with Invalid Date', () => {
  const assetManagementPage = new AssetManagementPage();
  const assetId = 'A12345';
  const invalidDate = '2023-13-01';

  beforeEach(() => {
    cy.visit('/asset-management');
  });

  it('should access the Asset Management module', () => {
    assetManagementPage.verifyPageLoaded();
  });

  it('should search for the asset using Asset ID', () => {
    assetManagementPage.searchAssetById(assetId);
    assetManagementPage.verifyAssetDetailsPageDisplayed();
  });

  it('should reject invalid retirement date', () => {
    assetManagementPage.clickRetireAssetButton();
    assetManagementPage.enterRetirementDate(invalidDate);
    assetManagementPage.verifyInvalidDateErrorMessage();
  });
});