describe('Filter Products by Rating', () => {
  const productSearchPage = new ProductSearchPage();

  beforeEach(() => {
    // Assuming user is already logged in
    cy.visit('/product-search');
  });

  it('should filter products by 4 stars and above', () => {
    productSearchPage.selectRatingFilter();
    productSearchPage.selectFourStarsAndAbove();
    productSearchPage.applyFilters();
    productSearchPage.verifyProductsHaveFourStarsOrHigher();
  });
});