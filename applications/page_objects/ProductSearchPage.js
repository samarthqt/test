class ProductSearchPage {
  enterProductName(name) {
    cy.get('[data-test=search-bar]').clear().type(name);
    cy.get('[data-test=search-button]').click();
  }

  enterSKU(sku) {
    cy.get('[data-test=search-bar]').clear().type(sku);
    cy.get('[data-test=search-button]').click();
  }

  selectCategory(category) {
    cy.get('[data-test=category-filter]').select(category);
    cy.get('[data-test=search-button]').click();
  }

  getSearchResults() {
    return cy.get('[data-test=search-results]');
  }
}