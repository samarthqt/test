import { expect } from 'chai';

class SearchResultsPage {

  static verifySearchResults(keyword) {
    cy.get('.product-item').each($el => {
      cy.wrap($el).should('contain', keyword);
    });
  }

  static verifyProductRelevance() {
    cy.get('.product-item').should('have.length.gt', 0);
  }

  static verifyPaginationControls() {
    cy.get('.pagination-controls').should('be.visible');
  }

  static verifyFilteringOptionsVisible() {
    cy.get('.filter-options').should('be.visible');
  }

  static applyFilteringOptions() {
    cy.get('.filter-options').first().click();
  }

  static verifySortingOptionsVisible() {
    cy.get('.sorting-options').should('be.visible');
  }

  static applySortingOptions() {
    cy.get('.sorting-options').first().click();
  }

  static verifyProductDetailsDisplay() {
    cy.get('.product-item').each($el => {
      cy.wrap($el).find('.product-name').should('be.visible');
      cy.wrap($el).find('.product-price').should('be.visible');
      cy.wrap($el).find('.product-rating').should('be.visible');
    });
  }

  static clickOnProduct() {
    cy.get('.product-item').first().click();
  }

  static verifyProductDetailPage() {
    cy.url().should('include', '/product-detail');
    cy.get('.product-full-details').should('be.visible');
  }

  static clickHomeButtonOrLogo() {
    cy.get('#homeButton, #logo').click();
  }

  static verifyReturnToHomepage() {
    cy.url().should('eq', Cypress.config().baseUrl);
  }

  static verifySearchResultsCount(expectedCount) {
    cy.get('.product-item').should('have.length', expectedCount);
  }

  static verifyNoResultsMessage() {
    cy.get('.no-results-message').should('be.visible');
  }

  static navigateToNextPage() {
    cy.get('.pagination-controls .next').click();
  }

  static navigateToPreviousPage() {
    cy.get('.pagination-controls .prev').click();
  }

  static verifyCurrentPageNumber(expectedPageNumber) {
    cy.get('.pagination-controls .current-page').should('contain', expectedPageNumber);
  }

}

export default SearchResultsPage;