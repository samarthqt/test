class CheckoutPage {
    static enterDiscountCode(code) {
        cy.get('#discount-code-input').type(code);
    }

    static applyDiscount() {
        cy.get('#apply-discount-button').click();
    }

    static getTotalAmount() {
        return cy.get('.total-amount').invoke('text').then(parseFloat);
    }

    static getOriginalTotalAmount() {
        return cy.get('.original-total-amount').invoke('text').then(parseFloat);
    }

    static completeCheckout() {
        cy.get('#complete-checkout-button').click();
    }
}

export default CheckoutPage;