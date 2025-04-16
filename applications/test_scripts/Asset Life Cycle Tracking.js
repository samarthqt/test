describe('Asset Life Cycle Tracking', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUser', 'validPassword');
  });

  it('should navigate to asset management module', () => {
    const dashboard = new DashboardPage();
    dashboard.navigateToAssetManagement();
    cy.url().should('include', '/asset-management');
  });

  it('should track asset life cycle', () => {
    const assetManagement = new AssetManagementPage();
    assetManagement.selectAssetLifeCycleTracking();
    assetManagement.enterAssetDetails('Laptop', 'LAP123');
    assetManagement.defineLifecycleStages(['Acquisition', 'Deployment', 'Maintenance', 'Retirement']);
    assetManagement.saveLifecycleConfiguration();

    assetManagement.trackAssetStage('Acquisition');
    assetManagement.trackAssetStage('Deployment');
    assetManagement.trackAssetStage('Maintenance');
    assetManagement.trackAssetStage('Retirement');

    assetManagement.verifyLifecycleHistory();
    assetManagement.checkNotifications();
    assetManagement.validateMultipleAssetsTracking();
    assetManagement.ensureComplianceWithStandards();
    assetManagement.testIntegrationWithOtherModules();
  });
});