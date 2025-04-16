describe('Retire Asset with No Reason', () => {
  const assetManagementPage = new AssetManagementPage();

  beforeEach(() => {
    cy.visit('/asset-management');
  });

  it('should require a reason for asset retirement', () => {
    assetManagementPage.navigateToModule();
    assetManagementPage.searchAsset('A12345');
    assetManagementPage.clickRetireAssetButton();
    assetManagementPage.enterRetirementDate('2023-10-01');
    assetManagementPage.submitRetirementForm();
    assetManagementPage.verifyReasonRequiredPrompt();
  });
});