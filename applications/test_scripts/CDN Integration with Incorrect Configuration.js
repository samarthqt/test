describe('CDN Integration with Incorrect Configuration', () => {
    beforeEach(() => {
        cy.visit('/');
    });

    it('Attempt to access the application with incorrect CDN configuration', () => {
        cy.intercept('GET', '**/node123.cdnprovider.com/**', { statusCode: 404 }).as('cdnError');
        cy.visit('/');
        cy.wait('@cdnError');
        cy.get('body').should('contain.text', 'Configuration Error');
    });

    it('Navigate to a product page with multiple images', () => {
        cy.intercept('GET', '**/node123.cdnprovider.com/**', { statusCode: 404 }).as('cdnError');
        cy.visit('/product-page');
        cy.wait('@cdnError');
        cy.get('.product-image').each(($img) => {
            cy.wrap($img).should('have.attr', 'alt', 'Configuration Error');
        });
    });

    it('Check the network activity for errors related to CDN nodes', () => {
        cy.visit('/');
        cy.intercept('GET', '**/node123.cdnprovider.com/**').as('cdnCheck');
        cy.visit('/product-page');
        cy.wait('@cdnCheck').then((interception) => {
            expect(interception.response.statusCode).to.eq(404);
        });
    });

    it('Verify error logs for CDN configuration issues', () => {
        cy.visit('/admin/error-logs');
        cy.get('.error-log').should('contain.text', 'CDN configuration errors');
    });
});