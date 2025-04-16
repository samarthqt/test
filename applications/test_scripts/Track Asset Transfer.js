describe('Asset Transfer Test', () => {
  const loginPage = new LoginPage();
  const assetManagementPage = new AssetManagementPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in as Michael Johnson', () => {
    loginPage.login('Michael Johnson');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Asset Management module', () => {
    assetManagementPage.navigateToAssetManagement();
    cy.url().should('include', '/asset-management');
  });

  it('should select Transfers from sub-module menu', () => {
    assetManagementPage.selectTransfers();
    cy.url().should('include', '/transfers');
  });

  it('should search and select the asset Projector ABC', () => {
    assetManagementPage.searchAsset('Projector ABC');
    assetManagementPage.selectAsset('Projector ABC');
  });

  it('should set departments and transfer asset', () => {
    assetManagementPage.setDepartments('IT', 'Marketing');
    assetManagementPage.transferAsset();
  });

  it('should verify transfer log and email notifications', () => {
    assetManagementPage.verifyTransferLog('Projector ABC', 'IT', 'Marketing');
    assetManagementPage.verifyEmailNotification('IT', 'Marketing');
  });

  it('should verify asset department update', () => {
    assetManagementPage.verifyAssetDepartment('Projector ABC', 'Marketing');
  });
});