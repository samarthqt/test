describe('Revalue Asset Based on Market Conditions', () => {
  const loginPage = new LoginPage();
  const assetManagementPage = new AssetManagementPage();
  const revaluationPage = new RevaluationPage();

  before(() => {
    cy.visit('https://dynamics365.example.com');
  });

  it('should log in as Emily Davis', () => {
    loginPage.login('Emily Davis', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Asset Management module', () => {
    assetManagementPage.navigateToAssetManagement();
    cy.url().should('include', '/asset-management');
  });

  it('should select Revaluation from the sub-module menu', () => {
    assetManagementPage.selectRevaluation();
    cy.url().should('include', '/revaluation');
  });

  it('should enter Vehicle DEF in the asset search field', () => {
    revaluationPage.searchAsset('Vehicle DEF');
    revaluationPage.verifyAssetDisplayed('Vehicle DEF');
  });

  it('should select the asset Vehicle DEF from the search results', () => {
    revaluationPage.selectAsset('Vehicle DEF');
    revaluationPage.verifyAssetDetails('Vehicle DEF');
  });

  it('should enter $25,000 as the new market value', () => {
    revaluationPage.enterNewMarketValue('25000');
    revaluationPage.verifyNewMarketValueEntered('25000');
  });

  it('should click on Revalue Asset', () => {
    revaluationPage.clickRevalueAsset();
    revaluationPage.verifyRevaluationProcessed();
  });

  it('should verify that the asset value is updated to the new market value', () => {
    revaluationPage.verifyAssetValueUpdated('25000');
  });

  it('should check if the revaluation log records the change details', () => {
    revaluationPage.verifyRevaluationLogDetails();
  });

  it('should verify if an email notification is sent to the asset manager', () => {
    revaluationPage.verifyEmailNotificationSent();
  });
});