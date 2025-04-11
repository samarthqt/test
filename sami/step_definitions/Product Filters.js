describe('Product Filters', () => {
  beforeEach(() => {
    cy.visit('/product-search');
  });

  it('should filter products by price range', () => {
    cy.get('.price-filter').select('20-50');
    cy.get('.search-results').should('contain', 'Price: 20-50');
  });

  it('should filter products by rating', () => {
    cy.get('.rating-filter').select('4 stars');
    cy.get('.search-results').should('contain', 'Rating: 4 stars');
  });

  it('should filter products by multiple criteria', () => {
    cy.get('.price-filter').select('20-50');
    cy.get('.rating-filter').select('4 stars');
    cy.get('.search-results').should('contain', 'Price: 20-50').and('contain', 'Rating: 4 stars');
  });

  it('should clear all filters', () => {
    cy.get('.price-filter').select('20-50');
    cy.get('.rating-filter').select('4 stars');
    cy.get('.clear-filters').click();
    cy.get('.search-results').should('not.contain', 'Price: 20-50').and('not.contain', 'Rating: 4 stars');
  });

  it('should display no products found message when no products match', () => {
    cy.get('.price-filter').select('1000-2000');
    cy.get('.rating-filter').select('5 stars');
    cy.get('.search-results').should('contain', 'No products were found');
  });

  it('should persist filters after page refresh', () => {
    cy.get('.price-filter').select('20-50');
    cy.get('.rating-filter').select('4 stars');
    cy.reload();
    cy.get('.price-filter').should('have.value', '20-50');
    cy.get('.rating-filter').should('have.value', '4 stars');
  });
});