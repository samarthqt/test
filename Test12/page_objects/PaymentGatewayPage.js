import { configureStripeAPI, connectToStripeAPI, verifyStripeConnection, configurePayPalAPI, connectToPayPalAPI, verifyPayPalConnection, configureCardProcessorAPI, connectToCardProcessorAPI, verifyCardProcessorConnection, processTransaction, verifyDataEncryption, simulateTransactionFailure, detectFailure, handleFailureGracefully, processPayment, initiateTransaction, verifyComplianceWithPCIDSS } from '../tasks/paymentTasks';

class PaymentGatewayPage {

  static configureStripe() {
    configureStripeAPI();
  }

  static connectToStripe() {
    connectToStripeAPI();
  }

  static verifyStripeConnection() {
    verifyStripeConnection().should('be.true');
  }

  static configurePayPal() {
    configurePayPalAPI();
  }

  static connectToPayPal() {
    connectToPayPalAPI();
  }

  static verifyPayPalConnection() {
    verifyPayPalConnection().should('be.true');
  }

  static configureCardProcessor() {
    configureCardProcessorAPI();
  }

  static connectToCardProcessor() {
    connectToCardProcessorAPI();
  }

  static verifyCardProcessorConnection() {
    verifyCardProcessorConnection().should('be.true');
  }

  static selectPaymentMethod(method) {
    cy.get('#paymentMethod').select(method);
  }

  static completePaymentProcess() {
    cy.get('#completePayment').click();
  }

  static verifyTransactionCompletion() {
    cy.get('#transactionStatus').should('contain', 'completed');
  }

  static proceedWithPayment() {
    cy.get('#proceedWithPayment').click();
  }

  static processTransaction() {
    processTransaction();
  }

  static verifyDataEncryption() {
    verifyDataEncryption().should('be.true');
  }

  static simulateTransactionFailure() {
    simulateTransactionFailure();
  }

  static detectFailure() {
    detectFailure();
  }

  static handleFailureGracefully() {
    handleFailureGracefully().should('be.true');
  }

  static notifyUserOfFailure() {
    cy.get('#notification').should('contain', 'transaction failed');
  }

  static processPayment() {
    processPayment();
  }

  static initiateTransaction() {
    initiateTransaction();
  }

  static verifyComplianceWithPCIDSS() {
    verifyComplianceWithPCIDSS().should('be.true');
  }
}

export default PaymentGatewayPage;