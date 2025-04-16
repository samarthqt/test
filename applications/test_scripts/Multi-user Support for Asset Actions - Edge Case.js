describe('Multi-user Support for Asset Actions - Edge Case', () => {
  const assetID = 'A12345';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('User1, User2, and User3 perform actions on the same asset simultaneously', () => {
    // User1 logs in and navigates to Asset Management
    cy.login('User1', 'password1');
    cy.navigateToAssetManagement();
    cy.selectAssetForAllocation(assetID);

    // User2 logs in and navigates to Asset Management
    cy.login('User2', 'password2');
    cy.navigateToAssetManagement();
    cy.selectAssetForMaintenance(assetID);

    // User3 logs in and navigates to Asset Management
    cy.login('User3', 'password3');
    cy.navigateToAssetManagement();
    cy.selectAssetForTransfer(assetID);

    // User1 allocates the asset
    cy.allocateAssetToDepartment(assetID);
    cy.verifyAllocationSuccess(assetID);

    // User2 records maintenance
    cy.recordMaintenanceTask(assetID);
    cy.verifyMaintenanceSuccess(assetID);

    // User3 transfers the asset
    cy.transferAssetToLocation(assetID);
    cy.verifyTransferSuccess(assetID);

    // Verify asset history
    cy.verifyAssetHistory(assetID, ['Allocation', 'Maintenance', 'Transfer']);
  });
});