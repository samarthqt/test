describe('Boundary Test for Return Date', () => {
  const assetId = 'A123';
  const borrower = 'IT Department';
  const currentDate = new Date().toISOString().split('T')[0];
  const futureDate = new Date(new Date().setFullYear(new Date().getFullYear() + 10)).toISOString().split('T')[0];

  before(() => {
    cy.visit('/asset-management');
  });

  it('should navigate to Asset Management module', () => {
    cy.url().should('include', '/asset-management');
  });

  it('should search for Asset ID A123', () => {
    AssetManagementPage.searchAsset(assetId);
    AssetManagementPage.verifyAssetInSearchResults(assetId);
  });

  it('should select Asset A123 and verify details', () => {
    AssetManagementPage.selectAsset(assetId);
    AssetManagementPage.verifyAssetDetails(assetId, currentDate);
  });

  it('should loan asset with current date as return date', () => {
    AssetManagementPage.clickLoanAsset();
    LoanAssetPage.enterBorrower(borrower);
    LoanAssetPage.selectReturnDate(currentDate);
    LoanAssetPage.clickSave();
    AssetManagementPage.verifyLoanedAsset(assetId, currentDate);
  });

  it('should update return date to a far future date', () => {
    LoanAssetPage.selectReturnDate(futureDate);
    LoanAssetPage.clickSave();
    AssetManagementPage.verifyLoanedAsset(assetId, futureDate);
  });
});