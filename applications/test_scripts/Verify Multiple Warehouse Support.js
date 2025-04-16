describe('Verify Multiple Warehouse Support', () => {
  const warehousePage = new WarehousePage();

  before(() => {
    cy.login();
  });

  it('should navigate to Warehouse Management module', () => {
    warehousePage.navigateToWarehouseManagement();
    warehousePage.verifyAccessToModule();
  });

  it('should select Multi-Warehouse Support from the features list', () => {
    warehousePage.selectMultiWarehouseSupport();
    warehousePage.verifyMultiWarehouseSupportScreen();
  });

  it('should search for Product ID 2002', () => {
    warehousePage.searchProduct('2002');
    warehousePage.verifyProductDisplayed('2002');
  });

  it('should assign Central as the first warehouse location and set stock level to 100', () => {
    warehousePage.assignWarehouse('Central');
    warehousePage.setStockLevel('Central', 100);
  });

  it('should assign West as the second warehouse location and set stock level to 200', () => {
    warehousePage.assignWarehouse('West');
    warehousePage.setStockLevel('West', 200);
  });

  it('should save the changes to the product warehouse assignments', () => {
    warehousePage.saveChanges();
    warehousePage.verifyChangesSaved();
  });

  it('should navigate to stock overview screen and verify stock levels', () => {
    warehousePage.navigateToStockOverview();
    warehousePage.verifyStockLevel('2002', 'Central', 100);
    warehousePage.verifyStockLevel('2002', 'West', 200);
  });

  it('should perform a stock adjustment in Central and verify stock level', () => {
    warehousePage.adjustStock('Central', 120);
    warehousePage.verifyStockLevel('2002', 'Central', 120);
    warehousePage.verifyStockLevel('2002', 'West', 200);
  });

  it('should log out and verify warehouse assignments and stock levels after logging back in', () => {
    cy.logout();
    cy.login();
    warehousePage.verifyWarehouseAssignmentsAndStockLevels('2002');
  });
});