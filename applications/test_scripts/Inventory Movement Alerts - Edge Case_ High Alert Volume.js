describe('Inventory Movement Alerts - High Alert Volume Test', () => {
  const inventoryPage = new InventoryPage();

  beforeEach(() => {
    cy.visit('/login');
    cy.login('USR001');
  });

  it('should generate high alert volume for incorrect movements', () => {
    inventoryPage.navigateToMovementAlerts();
    inventoryPage.selectMonitorInventoryMovement();

    const products = ['PROD003', 'PROD004', 'PROD005'];
    const incorrectLocations = ['LOC_INVALID1', 'LOC_INVALID2', 'LOC_INVALID3'];

    inventoryPage.moveProductsToIncorrectLocations(products, incorrectLocations);
    inventoryPage.verifyAlertNotifications(products, incorrectLocations);

    const correctLocations = ['LOC_CORRECT1', 'LOC_CORRECT2', 'LOC_CORRECT3'];
    inventoryPage.correctProductMovements(products, correctLocations);
  });

  afterEach(() => {
    cy.logout();
  });
});