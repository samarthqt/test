describe('Asset Allocation Test Suite', () => {
  const loginPage = new LoginPage();
  const assetAllocationPage = new AssetAllocationPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in as admin and allocate asset B456 to John Doe in IT department', () => {
    loginPage.loginAsAdmin();
    assetAllocationPage.navigateToAssetAllocationModule();
    assetAllocationPage.selectAssetById('B456');
    assetAllocationPage.chooseDepartment('IT');
    assetAllocationPage.assignAssetToUser('John Doe');
    assetAllocationPage.verifyAllocationDetailsUpdated('B456', 'John Doe', 'IT');
  });
});