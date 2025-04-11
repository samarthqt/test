export class PaymentPage {
  verifyIntegration(paymentMethod) {
    cy.get('.integration-status').should('contain', paymentMethod);
  }

  initiatePayment(paymentMethod) {
    cy.get('.payment-method-selector').select(paymentMethod);
    cy.get('.initiate-payment-button').click();
  }

  verifyTransactionSecurity() {
    cy.get('.transaction-security-status').should('contain', 'Secure');
  }

  verifyPaymentConfirmationMessage() {
    cy.get('.confirmation-message').should('be.visible');
  }

  verifyReceiptProvided() {
    cy.get('.receipt').should('be.visible');
  }

  verifySuccessfulPaymentNotification() {
    cy.get('.payment-notification').should('contain', 'Payment Successful');
  }

  verifyPaymentLogging() {
    cy.get('.payment-log').should('contain', 'Logged');
  }

  simulateTransactionFailure() {
    cy.get('.simulate-failure-button').click();
  }

  verifyErrorMessageForFailedTransaction() {
    cy.get('.error-message').should('be.visible');
  }
}