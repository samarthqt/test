describe('TC-477 365 Multi-user Support for Asset Actions - Positive Scenario', () => {
  const assetId = 'A12345';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('User1 allocates asset', () => {
    cy.login('user1', 'password1');
    cy.navigateToAssetManagement();
    cy.selectAssetForAction(assetId, 'allocation');
    cy.allocateAssetToDepartment(assetId, 'Finance');
    cy.verifyAllocationSuccess(assetId);
  });

  it('User2 performs maintenance on asset', () => {
    cy.login('user2', 'password2');
    cy.navigateToAssetManagement();
    cy.selectAssetForAction(assetId, 'maintenance');
    cy.recordMaintenanceTask(assetId, 'Routine Check');
    cy.verifyMaintenanceSuccess(assetId);
  });

  it('User3 transfers asset', () => {
    cy.login('user3', 'password3');
    cy.navigateToAssetManagement();
    cy.selectAssetForAction(assetId, 'transfer');
    cy.transferAssetToLocation(assetId, 'New York Office');
    cy.verifyTransferSuccess(assetId);
  });

  it('Verify all actions are logged in asset history', () => {
    cy.login('admin', 'adminPassword');
    cy.navigateToAssetManagement();
    cy.viewAssetHistory(assetId);
    cy.verifyAssetHistory(assetId, ['allocation', 'maintenance', 'transfer']);
  });
});