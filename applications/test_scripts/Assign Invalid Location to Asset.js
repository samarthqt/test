describe('Assign Invalid Location to Asset', () => {
  const assetId = 'A123';
  const invalidLocation = 'Atlantis';

  beforeEach(() => {
    cy.visit('/asset-management');
  });

  it('should prevent assigning invalid locations to assets', () => {
    const assetManagementPage = new AssetManagementPage();
    assetManagementPage.selectAssetById(assetId);
    assetManagementPage.clickAssignLocation();
    assetManagementPage.enterLocation(invalidLocation);
    assetManagementPage.saveLocationAssignment();
    assetManagementPage.verifyInvalidLocationError(invalidLocation);
  });
});