describe('Warehouse Layout Deletion Test', () => {
  const warehouseLayoutPage = new WarehouseLayoutPage();

  before(() => {
    cy.login('admin', 'password');
  });

  it('should prevent deletion of a warehouse layout currently in use', () => {
    warehouseLayoutPage.navigateToWarehouseLayoutManagement();
    warehouseLayoutPage.selectWarehouseLayout('Main Warehouse Low');
    warehouseLayoutPage.attemptToDeleteLayout();
    warehouseLayoutPage.verifyDeletionErrorMessage();
  });
});