describe('Bulk Product Upload Validation', () => {
  const productManagementPage = new ProductManagementPage();

  before(() => {
    cy.login('admin', 'admin_password');
  });

  it('should upload products via CSV file', () => {
    productManagementPage.navigateToProductManagement();
    productManagementPage.selectBulkUpload();
    productManagementPage.uploadFile('BulkUploadProducts.csv');
    productManagementPage.validateFile();
    productManagementPage.checkValidationResults();
    productManagementPage.uploadProducts();
    productManagementPage.verifyUploadedProducts();
    productManagementPage.checkForErrorMessages();
  });

  it('should upload products via Excel file', () => {
    productManagementPage.uploadFile('BulkUploadProducts.xlsx');
    productManagementPage.validateFile();
    productManagementPage.checkValidationResults();
    productManagementPage.uploadProducts();
    productManagementPage.verifyUploadedProducts();
    productManagementPage.checkForErrorMessages();
  });

  it('should prevent upload of file with errors', () => {
    productManagementPage.uploadFile('BulkUploadProductsWithErrors.csv');
    productManagementPage.validateFile();
    productManagementPage.checkValidationErrors();
  });

  it('should upload products in a different category', () => {
    cy.logout();
    cy.login('admin', 'admin_password');
    productManagementPage.navigateToProductManagement();
    productManagementPage.selectBulkUpload();
    productManagementPage.uploadFile('DifferentCategoryProducts.csv');
    productManagementPage.validateFile();
    productManagementPage.checkValidationResults();
    productManagementPage.uploadProducts();
    productManagementPage.verifyUploadedProducts();
  });

  after(() => {
    cy.logout();
  });
});