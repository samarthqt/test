class AssetManagementPage {
  navigateTo() {
    cy.get('nav').contains('Asset Management').click();
  }

  selectAssetById(assetId) {
    cy.get('.asset-list').contains(assetId).click();
  }

  verifyWorkflowRule(ruleName) {
    cy.get('.workflow-rules').should('contain', ruleName);
  }

  triggerMaintenanceEvent(assetId) {
    cy.get('.trigger-event-button').click();
  }

  checkNotification(user, message) {
    cy.get('.notifications').should('contain', message);
  }

  reviewWorkflowLogs(ruleName) {
    cy.get('.workflow-logs').should('contain', ruleName);
  }

  verifyNoManualIntervention() {
    cy.get('.manual-intervention').should('not.exist');
  }
}

export default AssetManagementPage;