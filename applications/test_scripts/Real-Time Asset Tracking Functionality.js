describe('Real-Time Asset Tracking Functionality', () => {
  const assetId = 'A123';
  const invalidAssetId = 'Invalid123';
  const newLocation = 'Warehouse 2';
  let assetManagementPage;

  before(() => {
    cy.visit('/login');
    assetManagementPage = new AssetManagementPage();
    assetManagementPage.login('user', 'password');
  });

  it('should navigate to Asset Management module', () => {
    assetManagementPage.navigateToAssetManagement();
    cy.url().should('include', '/asset-management');
  });

  it('should display real-time tracking dashboard', () => {
    assetManagementPage.selectRealTimeTracking();
    cy.get('.dashboard').should('be.visible');
  });

  it('should display asset details for a valid asset ID', () => {
    assetManagementPage.searchAsset(assetId);
    cy.get('.asset-details').should('contain', 'In use').and('contain', 'Warehouse 1');
  });

  it('should update asset status and location in real-time', () => {
    assetManagementPage.updateAssetLocationAndStatus(assetId, newLocation, 'Available');
    assetManagementPage.refreshDashboard();
    cy.get('.asset-details').should('contain', 'Available').and('contain', newLocation);
  });

  it('should show accurate asset history log', () => {
    assetManagementPage.checkAssetHistory(assetId);
    cy.get('.history-log').should('contain', 'Available').and('contain', newLocation);
  });

  it('should handle network failure gracefully', () => {
    assetManagementPage.simulateNetworkFailure();
    cy.get('.error-message').should('contain', 'Network issues');
    assetManagementPage.restoreNetwork();
    cy.get('.asset-details').should('contain', 'Available').and('contain', newLocation);
  });

  it('should display error for invalid asset ID', () => {
    assetManagementPage.searchAsset(invalidAssetId);
    cy.get('.error-message').should('contain', 'Invalid asset ID');
  });

  it('should handle multiple asset updates efficiently', () => {
    assetManagementPage.performMultipleAssetUpdates();
    cy.get('.system-performance').should('not.contain', 'lag');
  });

  it('should update asset status in real-time', () => {
    assetManagementPage.changeAssetStatus(assetId, 'In use');
    cy.get('.asset-details').should('contain', 'In use');
  });

  it('should log out and re-login successfully', () => {
    assetManagementPage.logout();
    cy.url().should('include', '/login');
    assetManagementPage.login('user', 'password');
    assetManagementPage.navigateToAssetManagement();
    assetManagementPage.selectRealTimeTracking();
    assetManagementPage.searchAsset(assetId);
    cy.get('.asset-details').should('contain', 'In use').and('contain', newLocation);
  });
});