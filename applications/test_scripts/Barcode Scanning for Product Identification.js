describe('Barcode Scanning for Product Identification', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const barcodeScannerPage = new BarcodeScannerPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the warehouse management system', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyLoginSuccess();
  });

  it('should select the Barcode Scanning option from the main menu', () => {
    dashboardPage.selectBarcodeScanning();
    barcodeScannerPage.verifyBarcodeScanningInterface();
  });

  it('should ensure the scanner device is properly connected', () => {
    barcodeScannerPage.verifyScannerDeviceConnected();
  });

  it('should scan the barcode and display product details', () => {
    barcodeScannerPage.scanBarcode('123456789012');
    barcodeScannerPage.verifyProductDetails({
      name: 'Example Product',
      id: '001',
      location: 'Warehouse A'
    });
  });

  it('should repeat the scanning process with a different barcode', () => {
    barcodeScannerPage.scanBarcode('987654321098');
    barcodeScannerPage.verifyProductDetails({
      name: 'Another Product',
      id: '002',
      location: 'Warehouse B'
    });
  });

  after(() => {
    dashboardPage.logout();
  });
});