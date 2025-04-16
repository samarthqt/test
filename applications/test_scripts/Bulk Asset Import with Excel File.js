describe('Bulk Asset Import with Excel File', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const assetManagementPage = new AssetManagementPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in as admin', () => {
    loginPage.loginAsAdmin();
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Asset Management module', () => {
    dashboardPage.navigateToAssetManagement();
    assetManagementPage.verifyAssetManagementModuleIsOpened();
  });

  it('should select Bulk Import option', () => {
    assetManagementPage.selectBulkImportOption();
    assetManagementPage.verifyBulkImportScreenIsDisplayed();
  });

  it('should upload the valid Excel file', () => {
    assetManagementPage.uploadExcelFile('assets_valid.xlsx');
    assetManagementPage.verifyFileIsUploaded('assets_valid.xlsx');
  });

  it('should validate the Excel file', () => {
    assetManagementPage.clickValidateButton();
    assetManagementPage.verifyValidationSuccessMessage();
  });

  it('should import the records from Excel file', () => {
    assetManagementPage.clickImportButton();
    assetManagementPage.verifyImportSuccessMessage();
  });

  it('should verify imported records in asset list', () => {
    assetManagementPage.navigateToAssetList();
    assetManagementPage.verifyImportedRecords(100);
  });
});