class MobilePage {
    visit() {
        cy.visit('/');
    }

    navigateToHome() {
        cy.get('nav').contains('Home').click();
    }

    performSearch(productName) {
        cy.get('input[placeholder="Search..."]').type(`${productName}{enter}`);
    }

    addToCart() {
        cy.get('.product-item').first().click();
        cy.get('button.add-to-cart').click();
    }

    proceedToCheckout() {
        cy.get('.cart').click();
        cy.get('button.checkout').click();
    }

    fillShippingDetails(name, address, city) {
        cy.get('input[name="shipping-name"]').type(name);
        cy.get('input[name="shipping-address"]').type(address);
        cy.get('input[name="shipping-city"]').type(city);
    }

    selectPaymentMethod(method) {
        cy.get('select[name="payment-method"]').select(method);
    }

    submitOrder() {
        cy.get('button.submit-order').click();
    }

    logout() {
        cy.get('.user-menu').click();
        cy.get('button.logout').click();
    }
}

export default MobilePage;