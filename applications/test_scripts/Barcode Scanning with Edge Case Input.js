describe('TC-372 285 Barcode Scanning with Edge Case Input', () => {
  const warehousePage = new WarehousePage();

  before(() => {
    cy.visit('/login');
    warehousePage.login('validUser', 'validPassword');
  });

  it('should display barcode scanning interface', () => {
    warehousePage.selectBarcodeScanning();
    warehousePage.verifyBarcodeScanningInterface();
  });

  it('should process short barcode and display appropriate message', () => {
    warehousePage.scanBarcode('123');
    warehousePage.verifyShortBarcodeResponse();
  });

  it('should process long barcode and display appropriate message', () => {
    warehousePage.scanBarcode('12345678901234567890');
    warehousePage.verifyLongBarcodeResponse();
  });

  after(() => {
    warehousePage.logout();
  });
});