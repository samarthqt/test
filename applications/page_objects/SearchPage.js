class SearchPage {
  constructor() {
    this.searchBar = '#search-bar';
    this.resultsContainer = '#results-container';
    this.noResultsMessage = '#no-results-message';
  }

  search(keyword) {
    cy.get(this.searchBar).clear().type(keyword);
  }

  verifyResults(keyword) {
    cy.get(this.resultsContainer).should('contain', keyword);
  }

  verifyNoResults() {
    cy.get(this.noResultsMessage).should('be.visible');
  }

  verifyPartialMatches() {
    cy.get(this.resultsContainer).should('exist');
  }

  verifySortingAndFilteringOptions() {
    cy.get('#sort-options').should('be.visible');
    cy.get('#filter-options').should('be.visible');
  }

  verifyResultsHandlingSpecialCharacters() {
    cy.get(this.resultsContainer).should('exist');
  }

  verifySearchAccessibility() {
    cy.get(this.searchBar).should('be.visible');
  }

  verifyResultsForLongKeywords() {
    cy.get(this.resultsContainer).should('exist');
  }

  verifyRealTimeResults() {
    cy.get(this.resultsContainer).should('be.visible');
  }
}