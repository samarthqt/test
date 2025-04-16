describe('Mobile Optimization Verification', () => {
    const mobileViewportWidth = 375;
    const mobileViewportHeight = 667;

    before(() => {
        cy.viewport(mobileViewportWidth, mobileViewportHeight);
        cy.visit('/');
    });

    it('should display the website correctly on mobile without layout issues', () => {
        cy.get('body').should('be.visible');
    });

    it('should display homepage elements correctly and responsively', () => {
        cy.get('.homepage-element').should('be.visible');
    });

    it('should have accessible and functional navigation menu', () => {
        cy.get('.navigation-menu').should('be.visible').click();
        cy.get('.menu-items').should('be.visible');
    });

    it('should display product page correctly with responsive elements', () => {
        cy.get('.product-link').click();
        cy.get('.product-page').should('be.visible');
    });

    it('should ensure checkout process is smooth and responsive', () => {
        cy.get('.checkout-button').click();
        cy.get('.checkout-page').should('be.visible');
    });

    it('should have functional search on mobile', () => {
        cy.get('.search-bar').type('product name{enter}');
        cy.get('.search-results').should('be.visible');
    });

    it('should not require horizontal scrolling', () => {
        cy.get('body').then($body => {
            expect($body[0].scrollWidth).to.be.lte(mobileViewportWidth);
        });
    });

    it('should load and scale images correctly', () => {
        cy.get('img').each(($img) => {
            cy.wrap($img).should('be.visible');
            cy.wrap($img).invoke('width').should('be.lte', mobileViewportWidth);
        });
    });

    it('should have accessible and functional form inputs and buttons', () => {
        cy.get('input').each(($input) => {
            cy.wrap($input).should('be.visible');
        });
        cy.get('button').each(($button) => {
            cy.wrap($button).should('be.visible');
        });
    });

    it('should have no overlapping elements', () => {
        cy.get('.overlapping-element').should('not.exist');
    });
});