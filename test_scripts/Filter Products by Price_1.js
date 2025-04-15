describe('Filter Products by Price', () => {
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should perform a product search for Laptop', () => {
    productPage.searchForProduct('Laptop');
    productPage.verifySearchResultsDisplayed();
  });

  it('should apply price filter and verify Dell Inspiron 15 is listed', () => {
    productPage.setPriceFilter(500, 1000);
    productPage.verifyProductInFilteredResults('Dell Inspiron 15');
  });
});