describe('Automate Asset Workflow', () => {
  const assetId = '12345';

  beforeEach(() => {
    cy.visit('/login');
    cy.loginAs('Asset Manager');
    cy.url().should('include', '/dashboard');
  });

  it('should verify that workflows related to asset tasks are triggered automatically', () => {
    cy.navigateTo('Asset Management');
    cy.url().should('include', '/asset-management');

    cy.selectAssetById(assetId);
    cy.get('.asset-details').should('contain', assetId);

    cy.verifyWorkflowRule('Maintenance Notification');

    cy.triggerMaintenanceEvent(assetId);

    cy.checkNotification('Asset Manager', `Maintenance due for asset ID ${assetId}`);

    cy.reviewWorkflowLogs('Maintenance Notification');

    cy.verifyNoManualIntervention();
  });

  afterEach(() => {
    cy.logout();
    cy.url().should('include', '/login');
  });
});