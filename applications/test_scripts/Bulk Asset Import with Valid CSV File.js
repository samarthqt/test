describe('Bulk Asset Import with Valid CSV File', () => {
  before(() => {
    cy.visit('/login');
    cy.get('#username').type('admin');
    cy.get('#password').type('adminpass');
    cy.get('button[type=submit]').click();
    cy.url().should('include', '/dashboard');
  });

  it('should import multiple assets from a valid CSV file', () => {
    const assetManagementPage = new AssetManagementPage();
    assetManagementPage.navigateToAssetManagement();
    assetManagementPage.selectBulkImportOption();
    assetManagementPage.uploadCSVFile('assets_valid.csv');
    assetManagementPage.clickValidateButton();
    assetManagementPage.verifyValidationSuccess();
    assetManagementPage.clickImportButton();
    assetManagementPage.verifyImportSuccess();
    assetManagementPage.verifyImportedRecords(100);
  });
});