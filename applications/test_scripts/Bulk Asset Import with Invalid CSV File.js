describe('Bulk Asset Import with Invalid CSV File', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const assetManagementPage = new AssetManagementPage();
  const bulkImportPage = new BulkImportPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as admin and display the dashboard', () => {
    loginPage.loginAsAdmin();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to Asset Management module', () => {
    dashboardPage.goToAssetManagement();
    assetManagementPage.verifyAssetManagementDisplayed();
  });

  it('should select Bulk Import option', () => {
    assetManagementPage.selectBulkImport();
    bulkImportPage.verifyBulkImportScreenDisplayed();
  });

  it('should upload invalid CSV file', () => {
    bulkImportPage.uploadCSVFile('assets_invalid.csv');
    bulkImportPage.verifyFileUploaded('assets_invalid.csv');
  });

  it('should validate CSV file and display error', () => {
    bulkImportPage.clickValidateButton();
    bulkImportPage.verifyValidationErrorDisplayed();
  });

  it('should prevent import and display correction message', () => {
    bulkImportPage.clickImportButton();
    bulkImportPage.verifyImportPreventedMessage();
  });
});