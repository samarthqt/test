describe('Asset Categorization and Search', () => {
  const admin = new AdminPage();
  const user = new UserPage();

  it('should allow admin to categorize asset and user to filter and find it', () => {
    // Admin login
    cy.visit('/login');
    admin.login('admin', 'password');
    admin.verifyLogin();

    // Navigate to Asset Categorization
    admin.navigateToAssetCategorization();
    admin.verifyAssetCategorizationPage();

    // Select asset and categorize
    admin.selectAsset('A123');
    admin.selectCategory('Electronics');
    admin.categorizeAsset();
    admin.verifyAssetCategorized('Electronics');

    // Logout Admin and Login as User
    admin.logout();
    user.login('user', 'password');
    user.verifyLogin();

    // Navigate to Asset Search
    user.navigateToAssetSearch();
    user.verifyAssetSearchPage();

    // Apply filter and search
    user.applyCategoryFilter('Electronics');
    user.searchAssets();
    user.verifyAssetInSearchResults('A123');
  });
});