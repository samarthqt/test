describe('Product Search by Name', () => {
  before(() => {
    // Assume user is already logged in
    cy.visit('/');
  });

  it('should search for a product by name', () => {
    const searchTerm = 'Laptop';
    const expectedProduct = 'Dell Inspiron 15';

    const homepage = new Homepage();
    homepage.enterSearchTerm(searchTerm);
    homepage.clickSearchButton();

    const searchResultsPage = new SearchResultsPage();
    searchResultsPage.verifyProductIsListed(expectedProduct);
  });
});