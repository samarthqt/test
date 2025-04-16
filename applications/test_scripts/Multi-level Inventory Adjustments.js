describe('Multi-level Inventory Adjustments', () => {
  const inventoryPage = new InventoryPage();

  before(() => {
    cy.login('user', 'password');
  });

  it('should log in and access the inventory management module', () => {
    inventoryPage.navigateToInventoryManagement();
    inventoryPage.verifyInventoryManagementModuleOpen();
  });

  it('should perform a minor stock adjustment', () => {
    inventoryPage.selectStockAdjustments();
    inventoryPage.chooseAdjustmentLevel('Minor');
    inventoryPage.enterProductId('P12345');
    inventoryPage.specifyAdjustmentReason('Stock Count Error');
    inventoryPage.enterAdjustmentAmount('10');
    inventoryPage.submitAdjustment();
    inventoryPage.verifyInventoryLevels('P12345', 10);
  });

  it('should apply a major adjustment level with permissions', () => {
    inventoryPage.chooseAdjustmentLevel('Major');
    inventoryPage.verifyMajorAdjustmentApplied();
  });

  it('should display error for invalid adjustment amount', () => {
    inventoryPage.enterAdjustmentAmount('invalid');
    inventoryPage.verifyInvalidAmountError();
  });

  it('should prevent adjustment without a reason', () => {
    inventoryPage.enterProductId('P12345');
    inventoryPage.enterAdjustmentAmount('10');
    inventoryPage.submitAdjustment();
    inventoryPage.verifyReasonRequiredError();
  });

  it('should handle multiple concurrent adjustments', () => {
    cy.concurrentAdjustments(inventoryPage);
    inventoryPage.verifyConcurrentAdjustmentsProcessed();
  });

  after(() => {
    cy.logout();
  });

  it('should deny access to stock adjustments without login', () => {
    cy.visit('/stock-adjustments');
    inventoryPage.verifyAccessDenied();
  });
});