describe('Filter Products by Price', () => {
  before(() => {
    cy.login(); // Assume a custom command for logging in
  });

  it('should filter products by price range $10 - $50', () => {
    const productPage = new ProductPage();

    productPage.navigateToProductSearchPage();
    productPage.selectPriceFilter();
    productPage.enterPriceRange('10', '50');
    productPage.applyFilters();

    productPage.verifyProductsInPriceRange(10, 50);
  });
});