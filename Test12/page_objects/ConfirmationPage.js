import { Selector } from 'testcafe'; 
class ConfirmationPage {
 static completePurchaseDesktop() { 
 cy.visit('/confirmation-desktop'); 
 } 
 
 static completePurchaseMobile() { 
 cy.visit('/confirmation-mobile'); 
 } 
 
 static verifyTransactionSuccess() { 
 cy.get('#transactionStatus').should('contain', 'success'); 
 } 
 
 static verifyInstantConfirmation() { 
 cy.get('#confirmationMessage').should('be.visible'); 
 } 
 
 static verifyOrderDetails(orderId) { 
 cy.get('#orderId').should('contain', orderId); 
 } 
 
 static verifyCustomerInfo(customerName) { 
 cy.get('#customerName').should('contain', customerName); 
 } 
 
 static verifyPaymentMethod(paymentMethod) { 
 cy.get('#paymentMethod').should('contain', paymentMethod); 
 } 
 
 static verifyShippingAddress(shippingAddress) { 
 cy.get('#shippingAddress').should('contain', shippingAddress); 
 } 
 
 static verifyBillingAddress(billingAddress) { 
 cy.get('#billingAddress').should('contain', billingAddress); 
 } 
 
 static clickContinueShopping() { 
 cy.get('#continueShopping').click(); 
 } 
 
 static clickDownloadReceipt() { 
 cy.get('#downloadReceipt').click(); 
 } 
 
 static clickContactSupport() { 
 cy.get('#contactSupport').click(); 
 } 
 
 static verifyThankYouMessage() { 
 cy.get('#thankYouMessage').should('be.visible'); 
 } 
 
 static verifyOrderSummary() { 
 cy.get('#orderSummary').should('be.visible'); 
 } 
} 
 
export default ConfirmationPage;