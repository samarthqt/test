describe('Product Search by Category', () => {
  const searchPage = new SearchPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow users to search for products by category', () => {
    searchPage.getSearchBar().should('be.visible');
    searchPage.enterSearchTerm('Electronics');
    searchPage.clickSearchButton();
    searchPage.getSearchResults().should('contain', 'Electronics');
  });
});