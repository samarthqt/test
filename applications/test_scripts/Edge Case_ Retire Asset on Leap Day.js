describe('Asset Management - Retire Asset on Leap Day', () => {
  const assetId = 'A12345';
  const retirementDate = '2024-02-29';
  const retirementReason = 'End of lifecycle';

  before(() => {
    cy.visit('/login');
    cy.login('username', 'password');
  });

  beforeEach(() => {
    cy.visit('/asset-management');
  });

  it('should navigate to the Asset Management module', () => {
    AssetManagementPage.verifyModuleAccess();
  });

  it('should search and display the asset details', () => {
    AssetManagementPage.searchAssetById(assetId);
    AssetManagementPage.verifyAssetDetailsDisplayed(assetId);
  });

  it('should open the retire asset form', () => {
    AssetManagementPage.clickRetireAssetButton();
    AssetManagementPage.verifyRetirementFormDisplayed();
  });

  it('should enter retirement date and reason', () => {
    AssetManagementPage.enterRetirementDate(retirementDate);
    AssetManagementPage.selectRetirementReason(retirementReason);
  });

  it('should submit the retirement form and verify asset is retired', () => {
    AssetManagementPage.submitRetirementForm();
    AssetManagementPage.verifyAssetRetired(assetId);
  });

  it('should verify the asset is no longer in active inventory', () => {
    AssetManagementPage.verifyAssetNotInActiveInventory(assetId);
  });
});