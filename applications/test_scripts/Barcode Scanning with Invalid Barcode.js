describe('TC-371 285 Barcode Scanning with Invalid Barcode', () => {
  const warehousePage = new WarehousePage();

  before(() => {
    cy.visit('/login');
    warehousePage.login('validUsername', 'validPassword');
  });

  it('should handle invalid barcode inputs gracefully', () => {
    warehousePage.selectBarcodeScanningOption();
    warehousePage.verifyScannerConnection();
    warehousePage.scanBarcode('999999999999');
    warehousePage.verifyInvalidBarcodeError();
    warehousePage.verifyNoProductDetailsDisplayed();
  });

  after(() => {
    warehousePage.logout();
  });
});