describe('Product Search Functionality', () => {
  beforeEach(() => {
    cy.login(); // Assume a custom command for logging in
    cy.visit('/product-search');
  });

  it('should display products with name Laptop', () => {
    const searchPage = new ProductSearchPage();
    searchPage.enterProductName('Laptop');
    searchPage.getSearchResults().should('contain', 'Laptop');
  });

  it('should display product with SKU 12345', () => {
    const searchPage = new ProductSearchPage();
    searchPage.enterSKU('12345');
    searchPage.getSearchResults().should('contain', 'SKU: 12345');
  });

  it('should display products under Electronics category', () => {
    const searchPage = new ProductSearchPage();
    searchPage.selectCategory('Electronics');
    searchPage.getSearchResults().should('contain', 'Electronics');
  });

  it('should display products with name Laptop under Electronics category', () => {
    const searchPage = new ProductSearchPage();
    searchPage.enterProductName('Laptop');
    searchPage.selectCategory('Electronics');
    searchPage.getSearchResults().should('contain', 'Laptop').and('contain', 'Electronics');
  });
});