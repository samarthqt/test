class AssetManagement {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  navigateToAssetManagement() {
    cy.get('#assetManagementModule').click();
  }

  selectAssetForAction(assetId, action) {
    cy.get(`#asset-${assetId}`).click();
    cy.get(`#action-${action}`).click();
  }

  allocateAssetToDepartment(assetId, department) {
    cy.get(`#allocate-${assetId}`).click();
    cy.get('#departmentSelect').select(department);
    cy.get('#submitAllocation').click();
  }

  verifyAllocationSuccess(assetId) {
    cy.get('#notification').should('contain', `Asset ${assetId} allocated successfully`);
  }

  recordMaintenanceTask(assetId, task) {
    cy.get(`#maintenance-${assetId}`).click();
    cy.get('#taskDescription').type(task);
    cy.get('#submitMaintenance').click();
  }

  verifyMaintenanceSuccess(assetId) {
    cy.get('#notification').should('contain', `Maintenance for asset ${assetId} recorded successfully`);
  }

  transferAssetToLocation(assetId, location) {
    cy.get(`#transfer-${assetId}`).click();
    cy.get('#locationSelect').select(location);
    cy.get('#submitTransfer').click();
  }

  verifyTransferSuccess(assetId) {
    cy.get('#notification').should('contain', `Asset ${assetId} transferred successfully`);
  }

  viewAssetHistory(assetId) {
    cy.get(`#history-${assetId}`).click();
  }

  verifyAssetHistory(assetId, actions) {
    actions.forEach(action => {
      cy.get('#assetHistory').should('contain', action);
    });
  }
}

export default AssetManagement;