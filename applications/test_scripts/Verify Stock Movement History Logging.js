describe('Stock Movement History Logging', () => {
  const inventoryPage = new InventoryPage();
  const movementLogsPage = new MovementLogsPage();

  before(() => {
    cy.login(); // Custom command for logging in
  });

  it('should log and verify stock movement history', () => {
    inventoryPage.navigateToInventoryManagement();
    inventoryPage.selectMovementLogs();
    movementLogsPage.clickAddNewMovement();
    movementLogsPage.enterProductID('1001');
    movementLogsPage.selectMovementType('Intake');
    movementLogsPage.enterQuantity('50');
    movementLogsPage.enterDate('2023-11-10');
    movementLogsPage.selectWarehouse('Central');
    movementLogsPage.clickSave();

    movementLogsPage.navigateToMovementHistory();
    movementLogsPage.searchProductID('1001');
    movementLogsPage.verifyMovementEntry({
      productId: '1001',
      movementType: 'Intake',
      quantity: '50',
      date: '2023-11-10',
      warehouse: 'Central'
    });
    movementLogsPage.selectMovementEntry();
    movementLogsPage.verifyDetailedInformation();
    movementLogsPage.checkAuditTrail();
  });

  after(() => {
    cy.logout(); // Custom command for logging out
  });
});