describe('Apply Discount Codes During Checkout', () => {
    beforeEach(() => {
        cy.visit('/cart');
        cy.login('user@example.com', 'password123'); // Assuming there's a login command
    });

    it('should apply a valid discount code and update the total amount', () => {
        const discountCode = 'DISCOUNT2023';

        cy.get('.checkout-button').click();
        cy.url().should('include', '/checkout');

        CheckoutPage.enterDiscountCode(discountCode);
        CheckoutPage.applyDiscount();

        CheckoutPage.getTotalAmount().should('be.lessThan', CheckoutPage.getOriginalTotalAmount());

        CheckoutPage.completeCheckout();

        cy.url().should('include', '/order-confirmation');
        cy.contains('Your order has been placed successfully').should('be.visible');
    });
});