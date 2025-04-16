class MobilePage {
    openHomepage() {
        cy.visit('/');
    }

    checkHomepageElements() {
        cy.get('.homepage-element').should('be.visible');
    }

    checkNavigationMenu() {
        cy.get('.navigation-menu').should('be.visible').click();
        cy.get('.menu-items').should('be.visible');
    }

    openProductPage() {
        cy.get('.product-link').click();
    }

    checkProductPageElements() {
        cy.get('.product-page').should('be.visible');
    }

    initiateCheckoutProcess() {
        cy.get('.checkout-button').click();
    }

    checkCheckoutPage() {
        cy.get('.checkout-page').should('be.visible');
    }

    performSearch(searchTerm) {
        cy.get('.search-bar').type(`${searchTerm}{enter}`);
    }

    checkSearchResults() {
        cy.get('.search-results').should('be.visible');
    }

    checkHorizontalScrolling() {
        cy.get('body').then($body => {
            expect($body[0].scrollWidth).to.be.lte(375);
        });
    }

    checkImageLoadingAndScaling() {
        cy.get('img').each(($img) => {
            cy.wrap($img).should('be.visible');
            cy.wrap($img).invoke('width').should('be.lte', 375);
        });
    }

    checkFormInputsAndButtons() {
        cy.get('input').each(($input) => {
            cy.wrap($input).should('be.visible');
        });
        cy.get('button').each(($button) => {
            cy.wrap($button).should('be.visible');
        });
    }

    checkNoOverlappingElements() {
        cy.get('.overlapping-element').should('not.exist');
    }
}

module.exports = new MobilePage();