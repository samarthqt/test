describe('Low-Stock Notification Not Sent for Adequate Stock', () => {
  it('should not send a low-stock notification if stock levels are above the threshold', () => {
    const productId = '56789';
    const currentStockLevel = 15;
    const lowStockThreshold = 10;

    cy.visit('/inventory');
    const inventoryPage = new InventoryPage();

    inventoryPage.updateStockLevel(productId, currentStockLevel);
    inventoryPage.recordStockLevel(productId);

    cy.visit('/notifications');
    const notificationPage = new NotificationPage();

    notificationPage.checkNoLowStockAlert(productId);
  });
});