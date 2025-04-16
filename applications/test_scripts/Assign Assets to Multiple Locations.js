describe('Asset Management Module', () => {
  const assetManagementPage = new AssetManagementPage();

  beforeEach(() => {
    cy.visit('/asset-management');
  });

  it('should assign asset A123 to multiple locations', () => {
    assetManagementPage.selectAssetById('A123');
    assetManagementPage.clickAssignLocation();
    assetManagementPage.selectLocation('New York');
    assetManagementPage.clickAddLocation();
    assetManagementPage.selectLocation('San Francisco', 1);
    assetManagementPage.clickSave();
    assetManagementPage.generateLocationBasedReport();

    // Assertions
    assetManagementPage.verifyAssetAssignedToLocations('A123', ['New York', 'San Francisco']);
  });
});