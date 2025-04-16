describe('Warehouse Layout Edge Case', () => {
  it('should handle maximum sections in a warehouse layout', () => {
    const warehousePage = new WarehousePage();

    // Step 1: Log in to the warehouse management system as an admin
    cy.login('admin', 'adminPassword');
    cy.url().should('include', '/dashboard');

    // Step 2: Navigate to the 'Warehouse Layout Management' section
    warehousePage.navigateToLayoutManagement();
    warehousePage.getLayoutManagementSection().should('be.visible');

    // Step 3: Click on 'Create New Layout'
    warehousePage.clickCreateNewLayout();
    warehousePage.getLayoutForm().should('be.visible');

    // Step 4: Enter the warehouse name and maximum layout details
    warehousePage.enterLayoutDetails('Large Warehouse', 'Maximum allowable sections');
    warehousePage.getEnteredLayoutDetails().should('contain', 'Large Warehouse').and('contain', 'Maximum allowable sections');

    // Step 5: Submit the layout creation form
    warehousePage.submitLayoutForm();
    warehousePage.getNewLayout().should('contain', 'Large Warehouse').and('contain', 'Maximum allowable sections');
  });
});