import { expect } from 'chai';
import 'cypress';

class EcommercePage {

 static visit() {
 cy.visit('/ecommerce');
 }

 static navigateCategories() {
 cy.get('.category-item').click();
 }

 static verifyResponsiveDesign() {
 const viewports = ['macbook-15', 'iphone-6'];
 viewports.forEach(viewport => {
 cy.viewport(viewport);
 cy.get('.product-list').should('be.visible');
 });
 }

 static selectProducts() {
 cy.get('.product').click();
 }

 static addToCart() {
 cy.get('.add-to-cart').click();
 }

 static verifyProductInCart(productName) {
 cy.get('.cart').should('contain', productName);
 }

 static removeFromCart() {
 cy.get('.remove-from-cart').click();
 }

 static verifyProductNotInCart(productName) {
 cy.get('.cart').should('not.contain', productName);
 }

 static adjustProductQuantity(quantity) {
 cy.get('.quantity-input').clear().type(quantity);
 }

 static verifyUpdatedQuantity(quantity) {
 cy.get('.cart').should('contain', `Quantity: ${quantity}`);
 }

 static readyToCheckout() {
 cy.get('.checkout').click();
 }

 static selectPaymentMethod(method) {
 cy.get('.payment-method').select(method);
 }

 static verifySecurePayment() {
 cy.url().should('include', '/secure-payment');
 }

 static placeOrder() {
 cy.get('.place-order').click();
 }

 static viewOrderDetails() {
 cy.get('.order-details').click();
 }

 static verifyOrderTracking() {
 cy.get('.order-tracking').should('be.visible');
 }

 static visitPaymentPage() {
 cy.visit('/payment');
 }

 static choosePaymentMethod(method) {
 cy.get('.payment-options').select(method);
 }

 static verifyMultiplePaymentMethods() {
 cy.get('.payment-options').should('contain', 'Credit Card').and('contain', 'PayPal');
 }

 static navigateToLogin() {
 cy.visit('/login');
 }

 static enterCredentials(username, password) {
 cy.get('#username').type(username);
 cy.get('#password').type(password);
 cy.get('#loginButton').click();
 }

 static verifyAuthentication() {
 cy.url().should('include', '/dashboard');
 }

 static browsePlatform() {
 cy.visit('/browse');
 }

 static navigateWebsite() {
 cy.get('.nav-item').click();
 }

 static verifyIntuitiveNavigation() {
 cy.get('.cart-abandonment').should('not.exist');
 }

 static changeOrderStatus() {
 cy.get('.order-status').click();
 }

 static verifyOrderNotifications() {
 cy.get('.notifications').should('contain', 'Order status updated');
 }

 static performShoppingActivities() {
 cy.get('.shopping').click();
 }

 static simulateError() {
 cy.get('.trigger-error').click();
 }

 static verifyErrorHandling() {
 cy.get('.error-message').should('be.visible');
 }

 static readyForTesting() {
 cy.visit('/testing');
 }

 static conductTesting() {
 cy.get('.test-button').click();
 }

 static verifySeamlessFunctionality() {
 cy.get('.test-result').should('contain', 'All features working');
 }
}

export default EcommercePage;