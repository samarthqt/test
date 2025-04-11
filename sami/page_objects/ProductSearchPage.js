class ProductSearchPage {
  visit() {
    cy.visit('/product-search');
  }

  selectPriceRangeFilter() {
    cy.get('#price-filter').select('20-50');
  }

  verifyProductsWithinPriceRange() {
    cy.get('.product-item').each(($el) => {
      const price = parseFloat($el.find('.product-price').text().replace('$', ''));
      expect(price).to.be.within(20, 50);
    });
  }

  selectRatingFilter() {
    cy.get('#rating-filter').select('4');
  }

  verifyProductsWithSelectedRatingOrHigher() {
    cy.get('.product-item').each(($el) => {
      const rating = parseFloat($el.find('.product-rating').text());
      expect(rating).to.be.at.least(4);
    });
  }

  selectPriceAndRatingFilters() {
    this.selectPriceRangeFilter();
    this.selectRatingFilter();
  }

  verifyProductsMeetingBothCriteria() {
    this.verifyProductsWithinPriceRange();
    this.verifyProductsWithSelectedRatingOrHigher();
  }

  applyFilters() {
    this.selectPriceRangeFilter();
  }

  clearAllFilters() {
    cy.get('#clear-filters').click();
  }

  verifyAllProductsDisplayed() {
    cy.get('.product-item').should('have.length.greaterThan', 0);
  }

  applyPriceFilter() {
    this.selectPriceRangeFilter();
  }

  modifyPriceFilter() {
    cy.get('#price-filter').select('50-100');
  }

  verifyProductsWithinNewPriceRange() {
    cy.get('.product-item').each(($el) => {
      const price = parseFloat($el.find('.product-price').text().replace('$', ''));
      expect(price).to.be.within(50, 100);
    });
  }
}

export default ProductSearchPage;