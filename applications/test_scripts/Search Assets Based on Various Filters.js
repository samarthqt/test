describe('Asset Management System - Search Assets', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('username', 'password');
    cy.visit('/asset-dashboard');
  });

  it('should allow searching by name', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.searchByName('Office Laptop');
    assetPage.verifySearchResults('Office Laptop');
  });

  it('should allow searching by ID', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.searchById('A001');
    assetPage.verifySearchResults('A001');
  });

  it('should allow searching by category', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.selectCategory('Electronics');
    assetPage.verifySearchResults('Electronics');
  });

  it('should allow combining multiple search criteria', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.searchByName('Office Laptop');
    assetPage.searchById('A001');
    assetPage.selectCategory('Electronics');
    assetPage.verifySearchResults('Office Laptop', 'A001', 'Electronics');
  });

  it('should display search history', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.checkSearchHistory();
  });

  it('should handle invalid search criteria', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.searchByName('InvalidName');
    assetPage.verifyNoResults();
  });

  it('should display all assets with empty criteria', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.clearSearchCriteria();
    assetPage.verifyAllAssetsDisplayed();
  });

  it('should handle special characters in search', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.searchByName('@#$%^&*');
    assetPage.verifyRelevantResults();
  });

  it('should handle pagination and navigation', () => {
    const assetPage = new AssetPage();
    assetPage.navigateToSearchModule();
    assetPage.verifyPagination();
  });

  afterEach(() => {
    cy.logout();
  });
});