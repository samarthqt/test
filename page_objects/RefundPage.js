import { task } from 'cypress'; 
class RefundPage { 
 static login() { 
 cy.visit('/login'); 
 cy.get('#username').type('validUser'); 
 cy.get('#password').type('validPass'); 
 cy.get('#loginButton').click(); 
 } 
 
 static navigateToOrderHistory() { 
 cy.get('#orderHistoryLink').click(); 
 } 
 
 static verifyOrderHistoryDisplayed() { 
 cy.get('#orderHistory').should('be.visible'); 
 } 
 
 static selectEligibleTransaction() { 
 cy.get('.transaction').contains('Eligible for Refund').click(); 
 } 
 
 static verifyTransactionDetailsDisplayed() { 
 cy.get('#transactionDetails').should('be.visible'); 
 } 
 
 static clickRequestRefundButton() { 
 cy.get('#requestRefundButton').click(); 
 } 
 
 static verifyRefundFormDisplayed() { 
 cy.get('#refundForm').should('be.visible'); 
 } 
 
 static enterRefundDetails(refundAmount = '100', refundReason = 'Product Issue') { 
 cy.get('#refundAmount').type(refundAmount); 
 cy.get('#refundReason').type(refundReason); 
 } 
 
 static verifyRefundDetailsEntered(refundAmount = '100', refundReason = 'Product Issue') { 
 cy.get('#refundAmount').should('have.value', refundAmount); 
 cy.get('#refundReason').should('have.value', refundReason); 
 } 
 
 static selectPaymentGateway(gateway = 'Gateway1') { 
 cy.get('#paymentGateway').select(gateway); 
 } 
 
 static verifyPaymentGatewaySelected(gateway = 'Gateway1') { 
 cy.get('#paymentGateway').should('have.value', gateway); 
 } 
 
 static submitRefundRequest() { 
 cy.get('#submitRefundButton').click(); 
 } 
 
 static verifyRefundRequestSubmitted() { 
 cy.get('#refundConfirmation').should('be.visible'); 
 } 
 
 static verifyRefundStatus() { 
 cy.get('#transactionHistory').contains('Refund Processed'); 
 } 
 
 static verifyRefundStatusUpdated() { 
 cy.get('#transactionHistory').contains('Refund Processed').should('be.visible'); 
 } 
 
 static checkEmailNotification() { 
 cy.task('getEmail', 'refundConfirmation').should('exist'); 
 } 
 
 static verifyEmailNotificationReceived() { 
 cy.task('getEmail', 'refundConfirmation').should('contain', 'Refund Confirmed'); 
 } 
 
 static verifyRefundAmountCredited() { 
 cy.get('#paymentMethod').contains('Refund Amount Credited'); 
 } 
 
 static verifyRefundAmountCreditedBack() { 
 cy.get('#paymentMethod').contains('Refund Amount Credited').should('be.visible'); 
 } 
 
 static logout() { 
 cy.get('#logoutButton').click(); 
 } 
 
 static verifyLogoutSuccessful() { 
 cy.get('#loginPage').should('be.visible'); 
 } 
 
 static completeRefundProcess() { 
 this.login(); 
 this.navigateToOrderHistory(); 
 this.selectEligibleTransaction(); 
 this.clickRequestRefundButton(); 
 this.enterRefundDetails(); 
 this.selectPaymentGateway(); 
 this.submitRefundRequest(); 
 this.verifyRefundStatus(); 
 this.logout(); 
 } 
 
 static repeatRefundProcessWithDifferentGateway(gateway = 'Gateway2') { 
 this.login(); 
 this.navigateToOrderHistory(); 
 this.selectEligibleTransaction(); 
 this.clickRequestRefundButton(); 
 this.enterRefundDetails(); 
 this.selectPaymentGateway(gateway); 
 this.submitRefundRequest(); 
 this.verifyRefundStatus(); 
 this.logout(); 
 } 
 
 static verifyOnRefundForm() { 
 cy.get('#refundForm').should('be.visible'); 
 } 
 
 static attemptInvalidRefundAmount() { 
 cy.get('#refundAmount').type('1000'); 
 cy.get('#submitRefundButton').click(); 
 } 
 
 static verifyInvalidRefundAmountError() { 
 cy.get('#errorMessage').should('contain', 'invalid refund amount'); 
 } 
 
 static attemptRefundWithoutGateway() { 
 cy.get('#submitRefundButton').click(); 
 } 
 
 static verifyMissingGatewayError() { 
 cy.get('#errorMessage').should('contain', 'missing payment gateway selection'); 
 } 
 
 static attemptRefundWithInvalidTransactionID() { 
 cy.get('#transactionID').type('invalidID'); 
 cy.get('#submitRefundButton').click(); 
 } 
 
 static verifyInvalidTransactionIDError() { 
 cy.get('#errorMessage').should('contain', 'invalid transaction ID'); 
 } 
} 
 
export default RefundPage;