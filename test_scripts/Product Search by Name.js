describe('Product Search by Name', () => {
  const homepage = new Homepage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should search for products by name', () => {
    homepage.getSearchBar().should('be.visible');
    homepage.enterSearchTerm('Laptop');
    homepage.clickSearchButton();
    homepage.getSearchResults().should('contain', 'Laptop');
  });
});