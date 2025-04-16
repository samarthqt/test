describe('Low-Stock Notification Edge Case with Minimum Threshold', () => {
  const productId = '56789';
  const lowStockThreshold = 1;
  const currentStockLevel = 1;

  beforeEach(() => {
    cy.visit('/inventory');
  });

  it('should set the low-stock threshold to the minimum allowable value', () => {
    const inventoryPage = new InventoryPage();
    inventoryPage.setLowStockThreshold(productId, lowStockThreshold);
    inventoryPage.verifyThresholdUpdated(productId, lowStockThreshold);
  });

  it('should simulate a stock level drop to the threshold value', () => {
    const inventoryPage = new InventoryPage();
    inventoryPage.updateStockLevel(productId, currentStockLevel);
    inventoryPage.verifyStockLevelUpdated(productId, currentStockLevel);
  });

  it('should generate a low-stock notification', () => {
    const notificationPage = new NotificationPage();
    notificationPage.checkForLowStockAlerts(productId);
    notificationPage.verifyLowStockNotificationSent(productId);
  });
});