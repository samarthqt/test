class ProductSearchPage {
  visit() {
    cy.visit('/product-search');
  }

  enterSearchKeyword(keyword) {
    cy.get('#search-bar').type(keyword);
  }

  clickSearchButton() {
    cy.get('#search-button').click();
  }

  verifySearchResults() {
    cy.get('.product-list').should('be.visible');
  }

  verifySearchResultsRelevance() {
    cy.get('.product-list-item').each(($el) => {
      cy.wrap($el).should('contain.text', 'example keyword');
    });
  }

  selectCategoryFilter(category) {
    cy.get('#category-filter').select(category);
  }

  verifyCategoryFilterResults() {
    cy.get('.product-list-item').each(($el) => {
      cy.wrap($el).should('contain.text', 'Electronics');
    });
  }

  selectPriceRangeFilter(priceRange) {
    cy.get('#price-range-filter').select(priceRange);
  }

  verifyPriceRangeFilterResults() {
    cy.get('.product-list-item').each(($el) => {
      cy.wrap($el).invoke('text').then((text) => {
        const price = parseFloat(text.replace('$', ''));
        expect(price).to.be.within(50, 100);
      });
    });
  }

  selectRatingFilter(rating) {
    cy.get('#rating-filter').select(rating);
  }

  verifyRatingFilterResults() {
    cy.get('.product-list-item').each(($el) => {
      cy.wrap($el).find('.rating').should('have.text', '4 stars & up');
    });
  }

  selectMultipleFilters(filters) {
    this.selectCategoryFilter(filters.category);
    this.selectPriceRangeFilter(filters.price);
    this.selectRatingFilter(filters.rating);
  }

  verifyMultipleFiltersResults() {
    this.verifyCategoryFilterResults();
    this.verifyPriceRangeFilterResults();
    this.verifyRatingFilterResults();
  }

  verifyInstantFilterApplication() {
    cy.get('.filter-status').should('contain.text', 'Filters applied instantly');
  }

  performSearchOrFilter() {
    this.enterSearchKeyword('example keyword');
    this.clickSearchButton();
  }

  verifyNotification() {
    cy.get('.notification').should('contain.text', 'Operation completed');
  }

  enterInvalidSearchQuery(query) {
    cy.get('#search-bar').type(query);
    this.clickSearchButton();
  }

  verifyErrorMessage() {
    cy.get('.error-message').should('contain.text', 'Invalid search query');
  }

  verifyAnalyticsLogging() {
    cy.request('/analytics-log').its('body').should('include', 'search or filter operation logged');
  }
}

export default ProductSearchPage;