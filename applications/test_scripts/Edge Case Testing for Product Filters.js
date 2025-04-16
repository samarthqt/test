describe('Edge Case Testing for Product Filters', () => {
  const productPage = new ProductPage();

  before(() => {
    cy.login(); // Assume cy.login() logs the user in
  });

  it('should display all available products on product listing page', () => {
    productPage.navigateToListingPage();
    productPage.verifyAllProductsDisplayed();
  });

  it('should display filter options when filter is selected', () => {
    productPage.selectFilterOption();
    productPage.verifyFilterOptionsDisplayed();
  });

  it('should not display products for invalid price range $0 - $0', () => {
    productPage.setPriceRangeFilter(0, 0);
    productPage.verifyNoProductsDisplayed();
  });

  it('should not change displayed products for empty brand filter', () => {
    productPage.applyEmptyBrandFilter();
    productPage.verifyNoChangeInDisplayedProducts();
  });

  it('should not change displayed products for empty category filter', () => {
    productPage.applyEmptyCategoryFilter();
    productPage.verifyNoChangeInDisplayedProducts();
  });

  it('should not display products for invalid rating filter of 0 stars', () => {
    productPage.setRatingFilter(0);
    productPage.verifyNoProductsDisplayed();
  });
});