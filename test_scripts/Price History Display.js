describe('Price History Display Test', () => {
    const productId = '12345';
    const expectedPriceHistory = [
        { date: '2023-01-01', price: '$100' },
        { date: '2023-02-01', price: '$110' }
    ];

    beforeEach(() => {
        cy.visit(`/product/${productId}`);
    });

    it('should display the product details page', () => {
        cy.url().should('include', `/product/${productId}`);
        cy.get('.product-details').should('be.visible');
    });

    it('should locate the Price History section', () => {
        cy.get('.price-history-section').should('be.visible');
    });

    it('should verify the price history data', () => {
        cy.get('.price-history-section .price-history-item').each(($el, index) => {
            cy.wrap($el).within(() => {
                cy.get('.date').should('contain', expectedPriceHistory[index].date);
                cy.get('.price').should('contain', expectedPriceHistory[index].price);
            });
        });
    });
});