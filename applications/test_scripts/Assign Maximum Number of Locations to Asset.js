describe('Assign Maximum Number of Locations to Asset', () => {
  const assetID = 'A123';
  const maxLocations = 10; // Assume the system's maximum limit is 10 for demonstration

  beforeEach(() => {
    cy.login(); // Custom command to log in the user
    cy.visit('/asset-management');
  });

  it('should navigate to Asset Management module', () => {
    cy.url().should('include', '/asset-management');
  });

  it('should display asset details for selected asset ID', () => {
    AssetPage.selectAssetByID(assetID);
    AssetPage.assetDetailsShouldBeVisible(assetID);
  });

  it('should display the location assignment screen', () => {
    AssetPage.clickAssignLocation();
    AssetPage.locationAssignmentScreenShouldBeVisible();
  });

  it('should allow assignment of maximum number of locations', () => {
    AssetPage.assignLocations(maxLocations);
    AssetPage.verifyMaxLocationsAssigned(maxLocations);
  });

  it('should prevent assignment beyond maximum location limit', () => {
    AssetPage.tryAssignAdditionalLocation();
    AssetPage.verifyLimitReachedMessage();
  });
});