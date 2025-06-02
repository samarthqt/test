import { Selector } from 'testcafe'; 

class ShoppingPage {
    static visit() {
        cy.visit('/');
    }

    static setViewport(viewport) {
        cy.viewport(viewport);
    }

    static verifyPageLoad() {
        cy.get('body').should('be.visible');
    }

    static setUserCredentials() {
        cy.fixture('user').then((user) => {
            this.user = user;
        });
    }

    static login() {
        cy.get('#username').type(this.user.username);
        cy.get('#password').type(this.user.password);
        cy.get('#loginBtn').click();
    }

    static verifyHomepageRedirect() {
        cy.url().should('include', '/home');
    }

    static searchProduct(productKeyword) {
        cy.get('#searchInput').type(productKeyword);
        cy.get('#searchBtn').click();
    }

    static verifySearchResults(productKeyword) {
        cy.get('#searchResults').should('contain', productKeyword);
    }

    static addProductToCart() {
        cy.get('#addToCartBtn').click();
    }

    static verifyProductInCart(productName) {
        cy.get('#cart').should('contain', productName);
    }

    static proceedToCheckout() {
        cy.get('#checkoutBtn').click();
        cy.get('#detailsForm').within(() => {
            cy.get('#name').type('John Doe');
            cy.get('#address').type('123 Main St');
            cy.get('#payment').type('4111111111111111');
        });
        cy.get('#submitOrder').click();
    }

    static verifyCheckoutCompletion() {
        cy.get('#orderConfirmation').should('contain', 'Order Confirmed');
    }

    static verifyOrderDetails() {
        cy.get('#orderDetails').should('contain', 'Order Confirmed');
    }

    static verifyLoggedIn() {
        cy.get('#logoutBtn').should('be.visible');
    }

    static logout() {
        cy.get('#logoutBtn').click();
    }

    static verifyLogout() {
        cy.get('#loginBtn').should('be.visible');
    }

    static checkResponsivenessAndUI() {
        this.setViewport('macbook-15');
        this.verifyPageLoad();
        this.setViewport('iphone-x');
        this.verifyPageLoad();
    }
}

export default ShoppingPage;