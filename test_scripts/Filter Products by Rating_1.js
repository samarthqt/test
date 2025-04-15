describe('Filter Products by Rating', () => {
  const searchPage = new SearchPage();
  const resultsPage = new ResultsPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should filter products by minimum 4-star rating', () => {
    searchPage.performSearch('Laptop');
    resultsPage.applyRatingFilter(4);
    resultsPage.verifyProductIsListed('Apple MacBook Pro');
  });
});