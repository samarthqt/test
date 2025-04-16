describe('Real-Time Inventory Update on Goods Receipt', () => {
  const inventoryManagementPage = new InventoryManagementPage();

  before(() => {
    cy.visit('/login');
    inventoryManagementPage.login('username', 'password');
  });

  it('should navigate to Goods Receipt section and submit goods receipt', () => {
    inventoryManagementPage.navigateToGoodsReceipt();
    inventoryManagementPage.enterProductID('12345');
    inventoryManagementPage.enterReceivedQuantity('50');
    inventoryManagementPage.submitGoodsReceipt();
    inventoryManagementPage.verifySuccessfulReceipt();
  });

  it('should verify inventory levels are updated', () => {
    inventoryManagementPage.navigateToInventoryLevels();
    inventoryManagementPage.searchProductID('12345');
    inventoryManagementPage.verifyInventoryLevel('12345', 50);
  });
});