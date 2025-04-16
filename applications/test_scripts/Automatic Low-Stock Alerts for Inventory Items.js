describe('Automatic Low-Stock Alerts for Inventory Items', () => {
  const inventoryPage = new InventoryPage();
  const stockAlertsPage = new StockAlertsPage();

  before(() => {
    cy.login();
  });

  beforeEach(() => {
    cy.visit('/inventory');
  });

  it('should verify low stock alert generation', () => {
    inventoryPage.navigateToStockAlerts();
    stockAlertsPage.selectInventoryItem('001');
    stockAlertsPage.verifyStockLevelBelowThreshold(5, 10);
    stockAlertsPage.checkAlertGenerated('001');
    stockAlertsPage.reviewNotificationSettings();
    stockAlertsPage.verifyEmailAlert('001');
    stockAlertsPage.verifySMSAlert('001');
  });

  it('should verify alert history and update threshold', () => {
    stockAlertsPage.checkAlertHistory();
    stockAlertsPage.adjustThresholdLevel('001', 8);
    stockAlertsPage.simulateStockLevelUpdate(9);
    stockAlertsPage.verifyNoNewAlertGenerated();
  });

  it('should test alert deactivation and reactivation', () => {
    stockAlertsPage.deactivateAlerts();
    stockAlertsPage.reactivateAlerts();
    stockAlertsPage.verifyNotificationSettings();
  });

  after(() => {
    cy.logout();
  });
});