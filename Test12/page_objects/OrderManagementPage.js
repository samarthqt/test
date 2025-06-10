import { Cypress } from 'cypress';

class OrderManagementPage {

 static login(username, password) {
 cy.visit('/login');
 cy.get('#username').type(username);
 cy.get('#password').type(password);
 cy.get('#loginBtn').click();
 }

 static navigateToSection(section) {
 cy.contains(section).click();
 }

 static verifyDeliveryStatusAndTrackingNumbers() {
 cy.get('.order-status').should('be.visible');
 cy.get('.tracking-number').should('be.visible');
 }

 static verifyOrderHistoryList() {
 cy.get('.order-history-list').should('be.visible');
 }

 static viewEligibleOrderForCancellation() {
 cy.get('.order-eligible-cancel').click();
 }

 static cancelOrder() {
 cy.get('#cancelOrderBtn').click();
 }

 static verifyCancellationProcess() {
 cy.get('.cancellation-confirmation').should('be.visible');
 cy.get('.notification').contains('Cancellation confirmed').should('be.visible');
 }

 static viewEligibleOrderForReturn() {
 cy.get('.order-eligible-return').click();
 }

 static returnOrder() {
 cy.get('#returnOrderBtn').click();
 }

 static verifyReturnProcess() {
 cy.get('.return-confirmation').should('be.visible');
 cy.get('.notification').contains('Return confirmed').should('be.visible');
 }

 static placeOrder() {
 cy.get('#placeOrderBtn').click();
 }

 static updateOrderStatus() {
 cy.get('#updateStatusBtn').click();
 cy.get('.notification').contains('Order status updated').should('be.visible');
 }

 static attemptInvalidOperation() {
 cy.get('#invalidOperationBtn').click();
 cy.get('.error-message').should('be.visible');
 }

 static interactWithSystem() {
 cy.get('#interactSystemBtn').click();
 }

 static navigateThroughSections() {
 cy.get('.section-navigation').click();
 }

 static verifyUserFriendlyInterface() {
 cy.get('.user-friendly').should('be.visible');
 }

 static accessPersonalOrderInfo() {
 cy.get('#personalInfoBtn').click();
 cy.get('.privacy-security').should('be.visible');
 }

 static performOrderRelatedActions() {
 cy.get('#orderActionsBtn').click();
 cy.get('.analytics-log').should('be.visible');
 }

 static needOrderAssistance() {
 cy.get('#orderAssistanceBtn').click();
 cy.get('#supportSectionBtn').click();
 cy.get('.support-contact').should('be.visible');
 }

 static performMultipleOrderActions() {
 cy.get('#multipleActionsBtn').click();
 cy.get('.performance-optimization').should('be.visible');
 }
}

export default OrderManagementPage;