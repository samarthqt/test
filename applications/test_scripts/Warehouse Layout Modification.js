describe('Warehouse Layout Modification Test Suite', () => {
    beforeEach(() => {
        cy.visit('/login');
        const loginPage = new LoginPage();
        loginPage.loginAsAdmin('admin', 'password');
    });

    it('should allow admin to modify an existing warehouse layout', () => {
        const warehousePage = new WarehousePage();

        warehousePage.navigateToLayoutManagement();
        warehousePage.selectWarehouseLayout('Main Warehouse');
        warehousePage.modifyLayoutDetails({
            aisles: ['Aisle 1', 'Aisle 2', 'Aisle 3'],
            storageArea: 'Storage Area 3'
        });
        warehousePage.submitLayoutModification();

        warehousePage.verifyLayoutModification({
            aisles: ['Aisle 1', 'Aisle 2', 'Aisle 3'],
            storageArea: 'Storage Area 3'
        });
    });
});