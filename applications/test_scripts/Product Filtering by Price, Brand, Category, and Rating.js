describe('Product Filtering Test Suite', () => {
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.login(); // Assume a custom command for user login
    productPage.navigateToProductListing();
  });

  it('should filter products by price range', () => {
    productPage.openFilterOptions();
    productPage.setPriceRangeFilter(10, 50);
    productPage.verifyProductsFilteredByPrice(10, 50);
  });

  it('should filter products by brand', () => {
    productPage.openFilterOptions();
    productPage.selectBrand('ExampleBrand');
    productPage.verifyProductsFilteredByBrand('ExampleBrand');
  });

  it('should filter products by category', () => {
    productPage.openFilterOptions();
    productPage.selectCategory('Electronics');
    productPage.verifyProductsFilteredByCategory('Electronics');
  });

  it('should filter products by rating', () => {
    productPage.openFilterOptions();
    productPage.setRatingFilter(4);
    productPage.verifyProductsFilteredByRating(4);
  });

  it('should combine all filters', () => {
    productPage.openFilterOptions();
    productPage.setPriceRangeFilter(10, 50);
    productPage.selectBrand('ExampleBrand');
    productPage.selectCategory('Electronics');
    productPage.setRatingFilter(4);
    productPage.verifyProductsFilteredByAllCriteria(10, 50, 'ExampleBrand', 'Electronics', 4);
  });

  it('should clear all filters', () => {
    productPage.clearAllFilters();
    productPage.verifyAllProductsDisplayed();
  });
});