describe('Barcode Generation for New Products', () => {
  const inventoryPage = new InventoryPage();
  const barcodePage = new BarcodePage();

  before(() => {
    cy.login('validUser', 'validPassword');
  });

  it('should navigate to Inventory Management and add a new product', () => {
    inventoryPage.navigateToInventoryManagement();
    inventoryPage.clickAddNewProduct();
    inventoryPage.enterProductDetails('New Product', 'SKU123', 'Description');
    inventoryPage.enterCategoryAndSupplier('Category1', 'Supplier1');
    inventoryPage.setInitialStock(100);
    inventoryPage.saveNewProduct();
    inventoryPage.verifyBarcodeGenerated();
  });

  it('should print the barcode for the new product', () => {
    barcodePage.navigateToBarcodePrinting();
    barcodePage.selectProductForBarcode('New Product');
    barcodePage.printBarcode();
    barcodePage.verifyPrintedBarcodeMatchesGenerated();
  });

  it('should scan the printed barcode and verify recognition', () => {
    barcodePage.scanPrintedBarcode();
    barcodePage.verifySystemRecognition();
  });

  it('should edit product details, regenerate and print new barcode', () => {
    inventoryPage.editProductDetails('Updated Product', 'SKU124', 'Updated Description');
    inventoryPage.verifyNewBarcodeGenerated();
    barcodePage.printBarcode();
    barcodePage.verifyNewBarcodePrintedCorrectly();
  });
});