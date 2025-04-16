describe('Insurance Tracking Functionality', () => {
  const loginPage = new LoginPage();
  const assetManagementPage = new AssetManagementPage();
  const insurancePage = new InsurancePage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the asset management system', () => {
    loginPage.login('username', 'password');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Asset Management module', () => {
    assetManagementPage.navigateToAssetManagement();
    cy.url().should('include', '/asset-management');
  });

  it('should select Insurance sub-module', () => {
    assetManagementPage.selectInsuranceSubModule();
    cy.url().should('include', '/insurance');
  });

  it('should enter Asset ID and display details', () => {
    insurancePage.searchAsset('B456');
    insurancePage.verifyAssetDetailsDisplayed();
  });

  it('should add insurance details', () => {
    insurancePage.clickAddInsuranceDetails();
    insurancePage.enterInsuranceDetails('ABC Insurance', '5000', '12/31/2023');
    insurancePage.saveInsuranceDetails();
    insurancePage.verifyInsuranceDetails('ABC Insurance', '5000', '12/31/2023');
  });

  it('should handle incomplete insurance details', () => {
    insurancePage.enterIncompleteInsuranceDetails();
    insurancePage.verifyErrorMessage('Incomplete details');
  });

  it('should handle past expiration date', () => {
    insurancePage.enterInsuranceWithPastDate();
    insurancePage.verifyErrorMessage('Invalid expiration date');
  });

  it('should simulate system crash and recovery', () => {
    insurancePage.simulateCrashDuringEntry();
    cy.reload();
    insurancePage.verifyDataPersistence();
  });

  it('should handle multiple insurance entries', () => {
    insurancePage.enterMultipleInsuranceDetails();
    insurancePage.verifySystemPerformance();
  });

  it('should update insurance policy', () => {
    insurancePage.updateInsurancePolicy();
    insurancePage.verifyRealTimeUpdate();
  });

  it('should log out and verify data persistence after re-login', () => {
    loginPage.logout();
    loginPage.login('username', 'password');
    insurancePage.verifyDataPersistenceAfterLogin();
  });
});