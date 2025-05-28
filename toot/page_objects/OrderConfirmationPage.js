import { should } from 'chai';

class OrderConfirmationPage {

  static completePurchase() {
    cy.get('#completePurchaseBtn').click();
  }

  static verifyTransactionSuccess() {
    cy.get('#transactionStatus').should('contain', 'Success');
  }

  static verifyTransactionFailure() {
    cy.get('#transactionStatus').should('contain', 'Failed');
  }

  static verifyEmailSent() {
    cy.get('#emailStatus').should('contain', 'Sent');
  }

  static verifyNoEmailSent() {
    cy.get('#emailStatus').should('not.exist');
  }

  static failInitialEmailAttempt() {
    cy.get('#emailStatus').should('contain', 'Failed');
  }

  static verifyEmailContent() {
    cy.get('#emailContent').should('contain', 'Order ID');
    cy.get('#emailContent').should('contain', 'Items Purchased');
    cy.get('#emailContent').should('contain', 'Total Amount');
    cy.get('#emailContent').should('contain', 'Delivery Address');
  }

  static verifySenderEmailAddress() {
    cy.get('#senderEmail').should('contain', 'orders@example.com');
  }

  static attemptPurchase() {
    cy.get('#attemptPurchaseBtn').click();
  }

  static retryEmailSending() {
    cy.get('#retryEmailBtn').click();
  }

  static sendEmail() {
    cy.get('#sendEmailBtn').click();
  }

  static logEmailStatus() {
    cy.get('#logStatus').should('exist');
  }

  static verifyLogContent() {
    cy.get('#logContent').should('contain', 'Success').or('contain', 'Error');
  }

}

export default OrderConfirmationPage;