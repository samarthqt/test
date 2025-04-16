describe('Product Search Functionality', () => {
  before(() => {
    cy.login();
  });

  it('should navigate to the product search page', () => {
    ProductSearchPage.visit();
    ProductSearchPage.verifySearchBarIsDisplayed();
  });

  it('should search for products by name', () => {
    ProductSearchPage.enterSearchTerm('Laptop');
    ProductSearchPage.submitSearch();
    ProductSearchPage.verifySearchResultsContain('Laptop');
  });

  it('should filter search results by category', () => {
    ProductSearchPage.selectCategory('Electronics');
    ProductSearchPage.submitSearch();
    ProductSearchPage.verifySearchResultsFilteredByCategory('Electronics');
  });

  it('should search for products by keyword', () => {
    ProductSearchPage.enterSearchTerm('Gaming');
    ProductSearchPage.submitSearch();
    ProductSearchPage.verifySearchResultsContain('Gaming');
  });

  it('should verify search results pagination', () => {
    ProductSearchPage.verifyPagination();
  });

  it('should select a product from the search results', () => {
    ProductSearchPage.selectProductFromResults();
    ProductDetailPage.verifyProductDetails();
  });

  it('should verify search suggestions', () => {
    ProductSearchPage.verifySearchSuggestions('Lap');
  });

  it('should check if search history is recorded', () => {
    ProductSearchPage.verifySearchHistoryContains('Laptop');
  });

  it('should handle special characters in search', () => {
    ProductSearchPage.enterSearchTerm('@#$%^&*');
    ProductSearchPage.submitSearch();
    ProductSearchPage.verifySpecialCharacterHandling();
  });

  it('should display a message for no matching results', () => {
    ProductSearchPage.enterSearchTerm('NonExistentProduct');
    ProductSearchPage.submitSearch();
    ProductSearchPage.verifyNoResultsMessage();
  });
});