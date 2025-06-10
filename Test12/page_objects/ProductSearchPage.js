import { expect } from 'chai';
import { cy } from 'cypress';

class ProductSearchPage {
    static visit() {
        cy.visit('/product-search');
    }

    static enterKeyword(keyword) {
        cy.get('#search-bar').type(keyword);
    }

    static clickSearchButton() {
        cy.get('#search-button').click();
    }

    static selectCategoryFilter(category) {
        cy.get('.category-filter').select(category);
    }

    static selectPriceFilter(priceRange) {
        cy.get('.price-filter').select(priceRange);
    }

    static selectRatingFilter(rating) {
        cy.get('.rating-filter').select(rating);
    }

    static verifyMatchingProducts(keyword) {
        cy.get('.product-list').should('contain', keyword);
    }

    static verifyCategoryFilteredResults(category) {
        cy.get('.product-list').should('contain', category);
    }

    static verifyPriceFilteredResults(priceRange) {
        cy.get('.product-list').should('contain', priceRange);
    }

    static verifyRatingFilteredResults(rating) {
        cy.get('.product-list').should('contain', rating);
    }

    static verifyAccurateResults(keyword) {
        cy.get('.product-list').should('contain', keyword);
    }

    static verifyPerformance() {
        cy.get('.product-list').should('be.visible');
    }

    static verifyErrorMessage() {
        cy.get('.error-message').should('be.visible').and('contain', 'invalid query');
    }

    static verifySearchOptions() {
        cy.get('.search-options').should('be.visible');
    }

    static verifyOptionsVisibility() {
        cy.get('.search-options').should('be.visible').and('be.enabled');
    }

    static verifyResultsOrganization() {
        cy.get('.product-list').should('be.visible').and('be.ordered');
    }

    static performSearch(keyword) {
        cy.get('#search-bar').type(keyword);
        cy.get('#search-button').click();
    }

    static interactWithSearchFunctionality() {
        cy.get('#search-bar').click();
    }

    static verifyLogging() {
        cy.window().then(win => {
            expect(win.console.log).to.be.called;
        });
    }

    static verifyCatalogIntegration(catalog) {
        cy.get('.product-list').should('contain', catalog);
    }

    static verifyUserExperienceCompliance() {
        cy.get('body').should('have.attr', 'data-ux-compliant');
    }
}

export default ProductSearchPage;