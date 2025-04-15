class ProductSearchPage {
  selectRatingFilter() {
    cy.get('.rating-filter-option').click();
  }

  selectFourStarsAndAbove() {
    cy.get('.rating-four-stars-and-above').click();
  }

  applyFilters() {
    cy.get('.apply-filters-button').click();
  }

  verifyProductsHaveFourStarsOrHigher() {
    cy.get('.product-rating').each(($el) => {
      cy.wrap($el).invoke('text').then((text) => {
        const rating = parseFloat(text);
        expect(rating).to.be.gte(4);
      });
    });
  }
}