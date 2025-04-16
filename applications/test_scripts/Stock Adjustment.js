describe('Stock Adjustment Tests', () => {
  const inventoryManagement = new InventoryManagementPage();
  const stockAdjustment = new StockAdjustmentPage();

  beforeEach(() => {
    cy.visit('/login');
    inventoryManagement.login('username', 'password');
    inventoryManagement.goToStockAdjustment();
  });

  it('should allow valid stock adjustment', () => {
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('+10');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyStockLevel('110');
  });

  it('should reject adjustment without reason', () => {
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('+10');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyErrorMessage('Reason is required');
  });

  it('should reject adjustment with invalid product ID', () => {
    stockAdjustment.selectProduct('invalid-id');
    stockAdjustment.enterAdjustmentQuantity('+10');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyErrorMessage('Invalid product ID');
  });

  it('should reject adjustment exceeding max quantity', () => {
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('+1000');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyErrorMessage('Exceeds maximum allowed quantity');
  });

  it('should reject adjustment with negative quantity', () => {
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('-10');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyErrorMessage('Negative quantity not allowed');
  });

  it('should verify audit logs for stock adjustment', () => {
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('+10');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyAuditLogs('12345', '+10', 'Discrepancy found during audit');
  });

  it('should check user permissions for stock adjustment', () => {
    inventoryManagement.verifyUserPermissions('adjust-stock');
  });

  it('should handle adjustment during system downtime', () => {
    cy.server({ force404: true });
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('+10');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyErrorMessage('System is currently down');
  });

  it('should verify notification to relevant departments', () => {
    stockAdjustment.selectProduct('12345');
    stockAdjustment.enterAdjustmentQuantity('+10');
    stockAdjustment.enterReason('Discrepancy found during audit');
    stockAdjustment.submitAdjustment();
    stockAdjustment.verifyNotificationSent('Stock adjustment notification sent');
  });
});