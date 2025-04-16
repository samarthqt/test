describe('Investigational Product Supply Management', () => {
  const inventoryPage = new InventoryPage();

  before(() => {
    cy.visit('/');
    inventoryPage.login('validUsername', 'validPassword');
  });

  it('should navigate to Investigational Product module', () => {
    inventoryPage.navigateToInvestigationalProductModule();
    inventoryPage.verifyInvestigationalProductModuleDisplayed();
  });

  it('should track product supply', () => {
    inventoryPage.selectTrackProductSupply();
    inventoryPage.enterProductID('IP-001');
    inventoryPage.clickSearch();
    inventoryPage.verifyProductDetails('IP-001', 100, 'DC-01', '2023-12-31');
  });

  it('should simulate distribution and verify updated stock', () => {
    inventoryPage.simulateDistribution(20);
    inventoryPage.verifyUpdatedStockLevel(80);
    inventoryPage.checkAlertsForLowStock();
  });

  it('should simulate nearing expiration and acknowledge alert', () => {
    inventoryPage.simulateExpirationNearing();
    inventoryPage.acknowledgeExpirationAlert();
  });

  it('should generate report and log out', () => {
    inventoryPage.generateReport();
    inventoryPage.logout();
    inventoryPage.verifyDataSavedAndAccessible();
  });
});