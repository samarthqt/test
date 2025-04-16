describe('Product Pricing Update', () => {
  const loginPage = new LoginPage();
  const productManagementPage = new ProductManagementPage();
  const bulkUploadPage = new BulkUploadPage();
  const auditLogPage = new AuditLogPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.loginAsAdmin();
  });

  it('should update product price manually', () => {
    productManagementPage.navigateToProductManagement();
    productManagementPage.selectProduct('Sample Product');
    productManagementPage.enterNewPrice('100');
    productManagementPage.savePrice();
    productManagementPage.verifyUpdatedPrice('Sample Product', '100');
  });

  it('should update product prices via bulk upload', () => {
    bulkUploadPage.navigateToBulkUpload();
    bulkUploadPage.uploadPriceList('sample_price_list.csv');
    bulkUploadPage.mapColumns();
    bulkUploadPage.uploadPrices();
    productManagementPage.verifyUpdatedPrices(['Product1', 'Product2'], ['150', '200']);
  });

  it('should handle incorrect data format in bulk upload', () => {
    bulkUploadPage.navigateToBulkUpload();
    bulkUploadPage.uploadPriceList('incorrect_format.csv');
    bulkUploadPage.verifyErrorMessage('Incorrect data format');
    bulkUploadPage.uploadPriceList('corrected_format.csv');
    productManagementPage.verifyUpdatedPrices(['Product1', 'Product2'], ['150', '200']);
  });

  it('should log price updates in audit log', () => {
    auditLogPage.navigateToAuditLog();
    auditLogPage.verifyLogEntries(['Manual update for Sample Product', 'Bulk update for Product1, Product2']);
  });
});