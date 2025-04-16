describe('Stock Alerts for Expiry Notification', () => {
  const inventoryManagement = new InventoryManagement();

  beforeEach(() => {
    cy.visit('/inventory-management');
  });

  it('should display Inventory Management dashboard', () => {
    inventoryManagement.getDashboard().should('be.visible');
  });

  it('should navigate to Expiry Alerts section', () => {
    inventoryManagement.goToExpiryAlerts();
    inventoryManagement.getExpiryAlertsSection().should('be.visible');
  });

  it('should verify notification settings for product expiry', () => {
    inventoryManagement.checkNotificationSettings().should('contain', '30 days before expiry');
  });

  it('should check products nearing expiration', () => {
    inventoryManagement.getProductsNearExpiry().should('contain', 'Product A').and('contain', 'Product B');
  });

  it('should simulate current date as 2023-11-01 and verify notifications', () => {
    inventoryManagement.simulateCurrentDate('2023-11-01');
    inventoryManagement.verifyNotificationsWithinDays(30).should('contain', 'Product A');
  });

  it('should simulate current date as 2023-12-01 and verify notifications', () => {
    inventoryManagement.simulateCurrentDate('2023-12-01');
    inventoryManagement.verifyNotificationsWithinDays(30).should('contain', 'Product B');
  });

  it('should check notification log for accuracy', () => {
    inventoryManagement.getNotificationLog().should('contain', 'Product A').and('contain', 'Product B');
  });

  it('should change notification threshold to 15 days and verify settings', () => {
    inventoryManagement.changeNotificationThreshold(15);
    inventoryManagement.checkNotificationSettings().should('contain', '15 days before expiry');
  });

  it('should simulate current date as 2023-11-16 and verify notifications', () => {
    inventoryManagement.simulateCurrentDate('2023-11-16');
    inventoryManagement.verifyNotificationsWithinDays(15).should('not.contain', 'Product A');
  });

  it('should simulate current date as 2023-12-01 and verify notifications', () => {
    inventoryManagement.simulateCurrentDate('2023-12-01');
    inventoryManagement.verifyNotificationsWithinDays(15).should('contain', 'Product B');
  });
});