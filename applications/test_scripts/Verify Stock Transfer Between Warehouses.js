describe('Warehouse Stock Transfer', () => {
  const warehouseManagementPage = new WarehouseManagementPage();

  before(() => {
    cy.login();
  });

  it('should initiate and track stock transfer between warehouses', () => {
    warehouseManagementPage.navigateToModule();
    warehouseManagementPage.selectTransfers();
    warehouseManagementPage.initiateNewTransfer();
    warehouseManagementPage.enterProductID('3003');
    warehouseManagementPage.selectSourceWarehouse('Central');
    warehouseManagementPage.selectDestinationWarehouse('East');
    warehouseManagementPage.enterTransferQuantity(50);
    warehouseManagementPage.submitTransfer();
    warehouseManagementPage.verifyTransferInitiation();
    warehouseManagementPage.navigateToTransferHistory();
    warehouseManagementPage.searchTransferByProductID('3003');
    warehouseManagementPage.verifyTransferDetails('Central', 'East', 50);
    warehouseManagementPage.checkNotifications();
  });

  it('should prevent transfer initiation with quantity exceeding available stock', () => {
    warehouseManagementPage.initiateNewTransfer();
    warehouseManagementPage.enterProductID('3003');
    warehouseManagementPage.selectSourceWarehouse('Central');
    warehouseManagementPage.selectDestinationWarehouse('East');
    warehouseManagementPage.enterTransferQuantity(5000); // Exceeding quantity
    warehouseManagementPage.submitTransfer();
    warehouseManagementPage.verifyErrorMessage();
  });

  after(() => {
    cy.logout();
    cy.login();
    warehouseManagementPage.verifyTransferHistory();
  });
});